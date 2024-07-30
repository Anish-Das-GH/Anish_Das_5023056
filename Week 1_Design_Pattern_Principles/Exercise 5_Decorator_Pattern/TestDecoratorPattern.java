public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackNotifier = new SlackNotifierDecorator(notifier);
        
        Notifier combinedNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(notifier));

        System.out.println("Sending email notification:");
        notifier.send("Hello via Email!");

        System.out.println("\nSending email and SMS notification:");
        smsNotifier.send("Hello via Email and SMS!");

        System.out.println("\nSending email and Slack notification:");
        slackNotifier.send("Hello via Email and Slack!");

        System.out.println("\nSending email, SMS, and Slack notification:");
        combinedNotifier.send("Hello via Email, SMS, and Slack!");
    }
}
