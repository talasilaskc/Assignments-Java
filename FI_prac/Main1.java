package FI_prac;
import java.util.Scanner;
import java.util.function.*;


public class Main1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int option;
        do {
            System.out.println("Enter 1.Add 2.Subtract 3.Multiply 4.Divide 5.Power 6.exit");
            option= Integer.parseInt(sc.nextLine());
            System.out.print("Enter a:");
            Double a=Double.parseDouble(sc.nextLine());
            System.out.print("Enter b:");
            Double b=Double.parseDouble(sc.nextLine());
            switch (option){
                case 1:
                    BinaryOperator<Double> sum=(a1,b1)->a1+b1;
                    System.out.println(sum.apply(a,b));
                    break;

                case 2:
                    BinaryOperator<Double> diff=(a2,b2)->a2-b2;
                    System.out.println(diff.apply(a,b));
                    break;
                case 3:
                    BinaryOperator<Double> mul=(a3,b3)->a3*b3;
                    System.out.println(mul.apply(a,b));
                    break;
                case 4:
                    BinaryOperator<Double> div=(a4,b4)->a4/b4;
                    System.out.println(div.apply(a,b));
                    break;
                case 5:
                    BinaryOperator<Double> pow=(a5,b5)->Math.pow(a5,b5);
                    System.out.println(pow.apply(a,b));
                    break;
            }
        }while(option!=6);
    }
}
