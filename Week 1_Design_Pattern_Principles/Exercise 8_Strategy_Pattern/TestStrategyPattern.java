public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Smith", "123", "12/26");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(2500.00);

        PaymentStrategy payPalPayment = new PayPalPayment("john@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(1050.00);
    }
}
