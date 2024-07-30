import java.util.*;

public class Search_Function {

    public static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product - {" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    public static class ProductSearch {

        public static Product linearSearch(Product[] products, int searchId) {
            for (Product product : products) {
                if (product.getProductId() == searchId) {
                    return product;
                }
            }
            return null;
        }

        public static Product binarySearch(Product[] products, int searchId) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Product midProduct = products[mid];

                if (midProduct.getProductId() == searchId) {
                    return midProduct;
                }

                if (midProduct.getProductId() < searchId) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(5, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(7, "Headphones", "Electronics"),
            new Product(1, "Shoes", "Footwear"),
            new Product(3, "Watch", "Accessories"),
            new Product(6, "Smartphone", "Electronics")
        };

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        int searchId = 6;
        Product foundProductLinear = ProductSearch.linearSearch(products, searchId);
        System.out.println("Linear Search Result: " + (foundProductLinear != null ? foundProductLinear : "Product not found"));

        Product foundProductBinary = ProductSearch.binarySearch(products, searchId);
        System.out.println("Binary Search Result: " + (foundProductBinary != null ? foundProductBinary : "Product not found"));
    }
}
