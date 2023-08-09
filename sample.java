package bankmanagement;

public class sample {
    int i = m1();
    sample()
    {
        System.out.println("hello");
    }
    int m1()
    {
        System.out.println("method");
        return 20;
    }
    {
        System.out.println("instance block");
    }

    public static void main(String[] args) {
        sample a = new sample();
    }
}
