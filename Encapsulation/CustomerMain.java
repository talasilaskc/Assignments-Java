package Encapsulation;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer = new Customer("C001", "Alice Smith", "abc@gmail.com", 30);
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Email: " + customer.getCustomerEmail());

        customer.setCustomerEmail("alen@gmail.com");
        System.out.println("Updated Customer Email: " + customer.getCustomerEmail());

        int cust_age=customer.getAge();
        System.out.println("Customer Age: " + cust_age);
        if(cust_age>=18){
            System.out.println("Customer is eligible for membership.");
        } else {
            System.out.println("Customer is not eligible for membership.");
        }
    }
}


