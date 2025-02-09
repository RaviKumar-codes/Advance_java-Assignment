// 1. Interface Segregation & Dependency Inversion Principles (ISP & DIP)
// Defines a general contract for all payment methods, ensuring consistency in implementation.
interface PaymentMethod { //Defines an abstraction for payment methods, ensuring flexibility and extensibility.
    void processPayment(double amount);
}

// 2. Open-Closed Principle (OCP) - Easily extendable for new payment methods
class CreditCardPayment implements PaymentMethod {   //Concrete implementation for credit card payments, adhering to the PaymentMethod interface.
    
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

// Implements the payment method for PayPal transactions.
class PayPalPayment implements PaymentMethod { //Concrete implementation of a PayPal payment method, demonstrating extensibility.
    
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class GooglePayPayment implements PaymentMethod { //Implements the payment method for Google Pay transactions.
    
    public void processPayment(double amount) {
        System.out.println("Processing Google Pay payment of $" + amount);
    }
}

// 3. Single Responsibility Principle (SRP)
// The PaymentProcessor class is responsible only for handling payments
class PaymentProcessor {   //Handles payment processing by delegating the payment request to the provided payment method.
    private PaymentMethod paymentMethod; //Stores the chosen payment method to be used for processing.
    
    public PaymentProcessor(PaymentMethod paymentMethod) { // Dependency Injection (DIP) //Uses Dependency Injection to allow different payment methods to be set dynamically at runtime.
        this.paymentMethod = paymentMethod;
    }
    
    public void process(double amount) {   //Calls the selected payment method’s processPayment method to execute the payment.
        paymentMethod.processPayment(amount);
    }
}

// 4. Liskov Substitution Principle (LSP)
// All payment methods behave as expected and can be used interchangeably
//PaymentSystemDemo
public class Assignment3 {    //Entry point of the program demonstrating different payment methods.
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentProcessor processor1 = new PaymentProcessor(creditCard);  //Creates a payment processor using the credit card payment method.
        processor1.process(100.00);

        PaymentMethod payPal = new PayPalPayment();
        PaymentProcessor processor2 = new PaymentProcessor(payPal); //Creates a payment processor using the PayPal payment method
        processor2.process(200.00);

        PaymentMethod googlePay = new GooglePayPayment();
        PaymentProcessor processor3 = new PaymentProcessor(googlePay); //Creates a payment processor using the Google Pay payment method.
        processor3.process(300.00);
    }
}
