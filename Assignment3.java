// 1. Interface Segregation & Dependency Inversion Principles (ISP & DIP)
// Define a PaymentMethod interface that ensures flexibility
interface PaymentMethod {
    void processPayment(double amount);
}

// 2. Open-Closed Principle (OCP) - Easily extendable for new payment methods
class CreditCardPayment implements PaymentMethod {
    
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements PaymentMethod {
    
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class GooglePayPayment implements PaymentMethod {
    
    public void processPayment(double amount) {
        System.out.println("Processing Google Pay payment of $" + amount);
    }
}

// 3. Single Responsibility Principle (SRP)
// The PaymentProcessor class is responsible only for handling payments
class PaymentProcessor {
    private PaymentMethod paymentMethod;
    
    public PaymentProcessor(PaymentMethod paymentMethod) { // Dependency Injection (DIP)
        this.paymentMethod = paymentMethod;
    }
    
    public void process(double amount) {
        paymentMethod.processPayment(amount);
    }
}

// 4. Liskov Substitution Principle (LSP)
// All payment methods behave as expected and can be used interchangeably
//PaymentSystemDemo
public class Assignment3 {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentProcessor processor1 = new PaymentProcessor(creditCard);
        processor1.process(100.00);

        PaymentMethod payPal = new PayPalPayment();
        PaymentProcessor processor2 = new PaymentProcessor(payPal);
        processor2.process(200.00);

        PaymentMethod googlePay = new GooglePayPayment();
        PaymentProcessor processor3 = new PaymentProcessor(googlePay);
        processor3.process(300.00);
    }
}
