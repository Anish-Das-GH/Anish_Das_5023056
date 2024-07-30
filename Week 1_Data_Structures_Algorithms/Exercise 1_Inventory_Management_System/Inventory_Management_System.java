import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class Inventory_Management_System {
    private Map<Integer, Product> inventory;

    public Inventory_Management_System() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is currently empty.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        Inventory_Management_System ims = new Inventory_Management_System();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Inventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    Product newProduct = new Product(addId, addName, addQuantity, addPrice);
                    ims.addProduct(newProduct);
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double updatePrice = scanner.nextDouble();
                    Product updatedProduct = new Product(updateId, updateName, updateQuantity, updatePrice);
                    ims.updateProduct(updateId, updatedProduct);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ims.deleteProduct(deleteId);
                    break;

                case 4:
                    System.out.println("Current Inventory:");
                    ims.displayInventory();
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
