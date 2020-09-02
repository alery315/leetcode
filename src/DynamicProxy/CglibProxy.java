package DynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/1 12:33
 * @Version 1.0
 */

public class CglibProxy implements MethodInterceptor {

    public Object CreateProxyObject(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method: " + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after method: " + method.getName());
        return result;
    }
}
