package Inheritance;

public class PolicyMain {
    public static void main(String[] args) {
        LifePolicy lifePolicy = new LifePolicy("Life Secure", 500000, 20);
        System.out.println(lifePolicy.toString());
    }

}
