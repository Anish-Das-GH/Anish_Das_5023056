public class TestAdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor paytmProcessor = new PaytmAdapter(new PaytmGateway());

        payPalProcessor.processPayment(100.0);
        paytmProcessor.processPayment(200.0);
    }
}
