
public class Main {

    public static void main(String[] args) {
        float one = 1.23f;
        float two = 1.89f;
        System.out.println(fround(one));
        System.out.println(fround(two));
    }

    public static int fround(float x)
    {
        return (int)(x + 0.5);
    }
}