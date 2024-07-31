public class SingletonPatternExample {

    public static class Logger {
        private static Logger instance;

        private Logger() {
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public static class LoggerTest {
        public static void testSingleton() {
            Logger logger1 = Logger.getInstance();
            Logger logger2 = Logger.getInstance();
            Logger logger3 = Logger.getInstance();

            logger1.log("This is the first log message.");
            logger2.log("This is the second log message.");
            logger3.log("This is the third log message.");

            if (logger1 == logger2 && logger2 == logger3) {
                System.out.println("All logger instances refer to the same instance.");
            } else {
                System.out.println("Logger instances refer to different instances.");
            }
        }
    }

    public static void main(String[] args) {
        LoggerTest.testSingleton();
    }
}
