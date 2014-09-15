package wechat4j.support;

import org.apache.commons.lang.StringUtils;
import wechat4j.support.bean.AccessToken;
import wechat4j.support.bean.AppSecret;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * ConfigurationBase
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public class ConfigurationBase implements Configuration {
    private Configuration conf;
    private static AccessToken accessToken;
    private static AppSecret appSecret;
    private static IAccessTokenHandler accessTokenHandler;

    static {
        // 1st. Loading properties
        final String WECHAT4J_PROPERTIES = File.separator + "wechat4j.properties";
        PropertiesReader propertiesReader = new PropertiesReader(WECHAT4J_PROPERTIES);
        propertiesReader.load();

        // 2nd. Getting appid and appsecret
        String appIdStr = propertiesReader.getString("appId");
        String appSecretStr = propertiesReader.getString("appSecret");
        appSecret = new AppSecret(appIdStr, appSecretStr);

        // 3rd. Requesting access token from the remote
        accessToken = accessTokenHandler.getAccessToken();
    }


    @Override
    public String getAccessToken() {
        if (accessToken == null) {
            accessToken = requestAccessToken();
        }

        return accessToken.getAccessToken();
    }

    @Override
    public String getAppId() {
        return this.appSecret.getAppId();
    }

    @Override
    public String getAppSecret() {
        return this.appSecret.getAppSecret();
    }

    @Override
    public void setAppSecret(String appId, String appSecret) {
        this.appSecret.setAppId(appId);
        this.appSecret.setAppSecret(appSecret);
    }

    /**
     * Getting access token
     *
     * @return {@link wechat4j.support.bean.AccessToken}
     */
    private AccessToken requestAccessToken() {
        if (accessTokenHandler == null) {
            accessTokenHandler = new AccessTokenHandler();
        }

        try {
            Class<?> clazz = Class.forName(AccessTokenHandler.class.getName());
            Field field = clazz.getDeclaredField("conf");
            field.setAccessible(true);
            accessTokenHandler = (IAccessTokenHandler) clazz.newInstance();
            if (conf == null) {
                conf = new ConfigurationBase();

                String appIdStr = this.appSecret.getAppId();
                String appSecretStr = this.appSecret.getAppSecret();

                conf.setAppSecret(appIdStr, appSecretStr);
            }
            field.set(accessTokenHandler, conf);

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!isGetAccessTokenMethod(method)) {
                    continue;
                }

                // It will request access token from wechat server if access token is null
                if (accessToken == null) {
                    accessToken = (AccessToken) method.invoke(accessTokenHandler);

                    break;
                }

                if (accessToken != null) {
                    Date gotTokenTime = accessToken.getGotTokenTime();
                    Date disabledTime = new Date(gotTokenTime.getTime() * accessToken.getExpiresIn() * 1000);
                    Date now = new Date();
                    // Invoking access token handler depends on token disabled time.
                    if (now.getTime() > disabledTime.getTime()) {
                        accessToken = (AccessToken) method.invoke(accessTokenHandler);
                    }

                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return accessTokenHandler.getAccessToken();
    }

    private boolean isGetAccessTokenMethod(Method method) {
        return StringUtils.equals(method.getName(), "getAccessToken");
    }
}
