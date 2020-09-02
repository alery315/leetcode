package DynamicProxy;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/1 11:13
 * @Version 1.0
 */

public class SpeakServiceImpl implements SpeakService {

    @Override
    public String speak(String message) {
        System.out.println("speak: " + message);
        return message;
    }
}
