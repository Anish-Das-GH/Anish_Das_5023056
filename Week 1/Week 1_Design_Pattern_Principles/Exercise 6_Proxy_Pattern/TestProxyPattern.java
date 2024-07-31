public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpeg");
        Image image2 = new ProxyImage("photo2.jpeg");

        System.out.println("Displaying image1:");
        image1.display(); 

        System.out.println("\nDisplaying image1 again:");
        image1.display(); 

        System.out.println("\nDisplaying image2:");
        image2.display(); 
    }
}
