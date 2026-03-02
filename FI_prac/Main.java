package FI_prac;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter data:");
        String data=sc.nextLine();
        int option;
        do {
            System.out.println("Enter 1.Shout 2.Sleep 3.reverse 4.exit");
            option= Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    //method-1
                    class func1 implements Function<String,String>{
                        @Override
                        public String apply(String s) {
                            return s.toUpperCase()+"!!!";
                        }
                    }
                    Function<String,String> a=new func1();
                    System.out.println(a.apply(data));

                    //method-2
                    Function<String,String> b=new Function<String, String>() {
                        @Override
                        public String apply(String s) {
                            return s.toUpperCase()+"!!!";
                        }
                    };
                    System.out.println(b.apply(data));

                    //method-3
                    Function<String,String> c=(s)->s.toUpperCase()+"!!!";
                    System.out.println(c.apply(data));
                    break;

                case 2:
                    //method-1
                    class func2 implements Function<String,String>{
                        @Override
                        public String apply(String s) {
                            return s.toLowerCase()+":(";
                        }
                    }
                    Function<String,String> d=new func2();
                    System.out.println(d.apply(data));

                    //method-2
                    Function<String,String> e= new Function<String, String>() {
                        @Override
                        public String apply(String s) {
                            return s.toLowerCase()+":(";
                        }
                    };
                    System.out.println(e.apply(data));

                    //method-3
                    Function<String,String> f=(s)->s.toLowerCase()+":(";
                    System.out.println(f.apply(data));
                    break;
                case 3:
                    //method-1
                    class func3 implements Function<String, StringBuilder> {
                        @Override
                        public StringBuilder apply(String s) {
                            StringBuilder reversedString = new StringBuilder(s);
                            return reversedString.reverse();
                        }
                    }
                    Function<String,StringBuilder> g=new func3();
                    System.out.println(g.apply(data));

                    //method-2
                    Function<String,StringBuilder> h=new Function<String, StringBuilder>(){
                        @Override
                        public StringBuilder apply(String s) {
                            StringBuilder reversedString = new StringBuilder(s);
                            return reversedString.reverse();
                        }
                    };
                    System.out.println(h.apply(data));

                    //method-3
                    Function<String,StringBuilder> i=(s)-> {
                        StringBuilder reversedString = new StringBuilder(s);
                        return reversedString.reverse();
                    };
                    System.out.println(i.apply(data));
                    break;

            }
        }while(option!=4);
    }
}
