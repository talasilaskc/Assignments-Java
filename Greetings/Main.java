package Greetings;

public class Main {
    public static void main(String[] args) {
        //method 1
        class GoodMrng implements Greetings{
            @Override
            public void goodMorning(){
                System.out.println("Good Morning");
            }
        }
        Greetings g=new GoodMrng();
        g.goodMorning();

        //method 2
        Greetings h=new Greetings(){
            @Override
            public void goodMorning(){
                System.out.println("Good Morning");
            }
        };
        h.goodMorning();

        //method 3
        Greetings i=()->System.out.println("Good Morning");
        i.goodMorning();
    }
}
