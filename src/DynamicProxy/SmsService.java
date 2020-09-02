package DynamicProxy;

public interface SmsService {
    String send(String message);

    String receive(String message);
}
