package DynamicProxy;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/1 11:03
 * @Version 1.0
 */

public class Test {

    public static void main(String[] args) {

        // jdk动态代理
        DebugInvocationHandler debugProxy = new DebugInvocationHandler(new SmsServiceImpl());
        SmsService smsService = (SmsService) debugProxy.getProxy();
        System.out.println(smsService.send("java"));
        System.out.println(smsService.receive("php"));

        debugProxy.setTarget(new SpeakServiceImpl());
        SpeakService speakService = (SpeakService) debugProxy.getProxy();
        speakService.speak("python");

        // cglib动态代理
        CglibProxy proxy = new CglibProxy();
        SmsService smsService1 = (SmsService) proxy.CreateProxyObject(SmsServiceImpl.class);
        SmsService smsService2 = new SmsServiceImpl();
        System.out.println(smsService1.getClass().getName());
        System.out.println(smsService2.getClass().getName());
        smsService1.send("cglib");



    }

}
