package ObjectCreation;

public class PolicyMain {
    public static void main(String[] args) {
        Policy p=new Policy();
        p.policyNumber="P001";
        p.policyHolderName="John Doe";
        p.policyAmount=5000.0;
        p.displayPolicy();
        double annualPremium=p.calculateAmountPremium();
        System.out.println("Annual Premium: "+annualPremium);
    }
}
