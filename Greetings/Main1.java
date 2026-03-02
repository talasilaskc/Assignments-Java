package Greetings;
import org.apache.poi.ss.formula.functions.Function0Arg;

import java.util.function.Function;

public class Main1 {
    public static void main(String[] args) {

        class Func implements Function<String, Integer> {
            @Override
            public Integer apply(String s) {
                System.out.println("Input: " + s);
                return s.length();   // example logic
            }
        }
        //method 1
        Function<String, Integer> f = new Func();
        int result = f.apply("Hello");
        System.out.println("Length: " + result);

        //method 2
        Function<String, Integer> g = new Function<String, Integer>(){
            @Override
            public Integer apply(String s) {
                System.out.println("Input: " + s);
                return s.length();
            }
        };
        int result1 = g.apply("Hello");
        System.out.println("Length: " + result);

        //method 3
        Function<String, Integer> h =(s)->s.length();
        int result2 = h.apply("Hello");
        System.out.println("Length: " + result);

    }
}
