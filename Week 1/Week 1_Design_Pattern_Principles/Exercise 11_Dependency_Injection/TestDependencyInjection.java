public class TestDependencyInjection {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        String customer = customerService.getCustomer("1234");
        System.out.println(customer);
    }
}
