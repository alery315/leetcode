package DynamicProxy;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/1 10:57
 * @Version 1.0
 */

public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send: " + message);
        return message;
    }

    @Override
    public String receive(String message) {
        System.out.println("receive: " + message);
        return message;
    }
}
