package wechat4j.message.support;

import org.testng.annotations.Test;
import wechat4j.support.AccessTokenGetter;
import wechat4j.support.bean.AccessToken;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;

@Test(enabled = false)
public class GetAccessTokenTest {

    @Test
    public void getAccessTokenTest() {
        AccessTokenGetter tokenGetter = new AccessTokenGetter("wxd30e31bfd8c207ee", "d0f9c44269c0282a1a7337efea1950a1");

        AccessToken accessToken = tokenGetter.getAccessToken();
        System.out.println(accessToken.toString());
    }

    public static void main(String[] args) {
        Class clazz = null;
        try {
            clazz = Class.forName("Method1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method methlist[] = clazz.getDeclaredMethods();

        for(Method method: methlist){
            method.getExceptionTypes();
        }

        try {
            Constructor constructor = clazz.getConstructor(clazz);
            try {
                constructor.newInstance(new Integer(3));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }


}
