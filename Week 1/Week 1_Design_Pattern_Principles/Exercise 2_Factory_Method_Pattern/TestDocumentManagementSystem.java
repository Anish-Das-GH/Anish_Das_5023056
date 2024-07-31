import java.util.Scanner;

public class TestDocumentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Document Management System (Factory Method):");
            System.out.println("1. Create Word Document");
            System.out.println("2. Create PDF Document");
            System.out.println("3. Create Excel Document");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            DocumentFactory factory = null;
            Document document = null;

            switch (option) {
                case 1:
                    factory = new WordDocumentFactory();
                    document = factory.createDocument();
                    break;

                case 2:
                    factory = new PdfDocumentFactory();
                    document = factory.createDocument();
                    break;

                case 3:
                    factory = new ExcelDocumentFactory();
                    document = factory.createDocument();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            if (document != null) {
                document.open();
                System.out.println("Document operations completed.");
            }
        }

        scanner.close();
    }
}
