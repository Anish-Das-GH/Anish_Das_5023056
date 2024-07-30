public class TestBuilderPattern {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder("Intel i7", "32GB")
            .setStorage("1TB SSD")
            .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "8GB")
            .setStorage("512GB SSD")
            .build();

        System.out.println(gamingComputer);
        System.out.println(officeComputer);
    }
}
