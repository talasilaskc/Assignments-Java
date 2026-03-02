package ObjectCreation;

public class Policy {
    String policyNumber;
    String policyHolderName;
    double policyAmount;



    public void displayPolicy(){
        System.out.println("Policy Number: "+" "+policyNumber+"Policy Holder Name: "+policyHolderName+"Policy Amount: "+policyAmount);
    }

    public double calculateAmountPremium(){
        return policyAmount*12;
    }
}
