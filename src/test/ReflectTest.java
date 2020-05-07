package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-29 17:28
 */
public class ReflectTest {

    public static void main(String[] args) {
        Class aClass = CanReach.class;
        Constructor c;
        {
            try {
                c = aClass.getConstructor();
                CanReach canReach = (CanReach) c.newInstance();
                Method method = aClass.getMethod("canReach", int[].class, int.class);
                System.out.println(method.invoke(canReach, new int[]{1,2,4}, 2));
                System.out.println(canReach);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }

}
