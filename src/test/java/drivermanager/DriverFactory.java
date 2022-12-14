package drivermanager;

public class DriverFactory {

    public DriverManager getManager(DriverType driverType) {

        DriverManager driverThreadLocalManager;

        switch (driverType) {
            case CHROME:
                driverThreadLocalManager = new ChromeDriverManager();
                break;
            case EDGE:
                driverThreadLocalManager = new EdgeDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type" + driverType);
        }
        return driverThreadLocalManager;
    }
}
