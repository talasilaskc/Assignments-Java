package Greetings;

import java.util.function.Predicate;

public class Main2 {
    public static void main(String[] args) {
        class func implements Predicate<Integer>{

            @Override
            public boolean test(Integer a) {
                return a > 18;
            }
        }
    }
}
