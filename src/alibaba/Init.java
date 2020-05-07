package alibaba;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-04-05 14:19
 */
public class Init {
    static Init a = new Init();
    static {
        System.out.println("static code");
    }
    Init b = new Init();
    {
        System.out.println("normal code");
    }
    public Init() {
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        Init a = new Init();
    }
}
