public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockPrice(100.0);
        stockMarket.setStockPrice(105.5);

        stockMarket.deregister(mobileApp);
        stockMarket.setStockPrice(110.0);
    }
}
