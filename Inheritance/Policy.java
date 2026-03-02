package Inheritance;

public class Policy {
    public String policyName;
    double policyAmount;

    public Policy(String policyName, double policyAmount) {
        this.policyName = policyName;
        this.policyAmount = policyAmount;
    }

    public String getPolicyName() {
        return policyName;
    }

    public double getPolicyAmount() {
        return policyAmount;
    }
}
