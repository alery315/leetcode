package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/1 10:59
 * @Version 1.0
 */

public class DebugInvocationHandler implements InvocationHandler {

    private Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("receive")) {
            System.out.println("before method: " + method.getName());
            Object result = method.invoke(target, args);
            System.out.println("after method: " + method.getName());
            return result;
        }
        return null;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

}
