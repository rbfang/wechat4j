package wechat4j;

import wechat4j.support.AccessTokenHandler;
import wechat4j.support.Configuration;
import wechat4j.support.ConfigurationBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

public abstract class WechatTestBase {
    private Configuration configuration = new ConfigurationBase();
    private String appId = "wxd30e31bfd8c207ee";
    private String appSecret = "d0f9c44269c0282a1a7337efea1950a1";
    private String packageName = "wechat4j.handler.impl";
    protected Map<String, Object> handlerMap = new HashMap<String, Object>();

    {
        configuration.setAppSecret(appId, appSecret);

        try {
            // 将wechat4j.handler.impl下实现类的conf配置文件赋值
            Class[] classesInPackage = getClasses(packageName);
            Class[] classes = new Class<?>[classesInPackage.length + 1];

            for (int i = 0; i < classesInPackage.length; i++) {
                classes[i] = classesInPackage[i];
            }

            // 将access token handler加入数组中
            classes[classes.length - 1] = Class.forName(AccessTokenHandler.class.getName());

            for (Class clazz : classes) {
                Field field = clazz.getDeclaredField("conf");
                field.setAccessible(true);
                Object obj = clazz.newInstance();
                field.set(obj, configuration);

                handlerMap.put(clazz.getName(), obj);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws java.io.IOException
     * @see [http://www.dzone.com/snippets/get-all-classes-within-package]
     */
    private Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }

        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     * @see [http://www.dzone.com/snippets/get-all-classes-within-package]
     */
    private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }

        return classes;
    }
}
