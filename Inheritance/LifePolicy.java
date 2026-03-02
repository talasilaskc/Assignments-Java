package Inheritance;

public class LifePolicy extends Policy {
    private int termYears;

    public LifePolicy(String policyName, double policyAmount, int termYears) {
        super(policyName, policyAmount);
        this.termYears = termYears;
    }

    public int getTermYears() {
        return termYears;
    }

    @Override
    public String toString() {
        return "LifePolicy{" +
                "policyName='" + policyName + '\'' +
                ", policyAmount=" + policyAmount +
                ", termYears=" + termYears +
                '}';
    }
}
