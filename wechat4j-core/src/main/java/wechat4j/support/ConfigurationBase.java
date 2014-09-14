package wechat4j.support;

import org.apache.commons.lang.StringUtils;
import wechat4j.support.bean.AccessToken;
import wechat4j.support.bean.AppSecret;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ConfigurationBase
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public class ConfigurationBase implements Configuration {
    private Configuration conf;
    private AccessToken accessToken;
    private AppSecret appSecret = new AppSecret();
    private IAccessTokenHandler accessTokenHandler;


    @Override
    public String getAccessToken() {
        if (accessToken == null) {
            accessToken = requsetAccessToken();
        }

        return accessToken.getAccessToken();
    }

    @Override
    public AppSecret getAppSecret() {
        return appSecret;
    }

    @Override
    public String getAppId() {
        return appSecret.getAppId();
    }

    @Override
    public String getAppSercret() {
        return appSecret.getAppSercret();
    }

    @Override
    public void setAppSecret(String appId, String appSercret) {
        this.appSecret.setAppId(appId);
        this.appSecret.setAppSercret(appSercret);
    }

    /**
     * 获取access token
     *
     * @return {@link wechat4j.support.bean.AccessToken}
     */
    private AccessToken requsetAccessToken() {
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
                //TODO 如果appid和appsercret的值为空，这里应该做一个读取xml或者properties之类的载入顺序的调用。
                conf.setAppSecret(appSecret.getAppId(), appSecret.getAppSercret());
            }
            field.set(accessTokenHandler, conf);

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!isGetAccessTokenMethod(method)) {
                    continue;
                }

                method.invoke(accessTokenHandler);
                break;
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
