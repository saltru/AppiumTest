import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "HT75N0204016");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //platformName
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); //platformVersion


        cap.setCapability("appPackage","ru.ozon.app.android");
        cap.setCapability("appActivity","ru.ozon.app.android.ui.start.PreStartActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        /*
        TouchAction touchAction = new TouchAction(driver);

        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_catalog")))))
                .perform();
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_cart")))))
                .perform();
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_favorites")))))
                .perform();
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_profile")))))
                .perform();
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_main")))))
                .perform();
        */

        OzonMainScreen ozonMainScreen = new OzonMainScreen(driver);

        /*
        ozonMainScreen.tapMenuCatalog();
        ozonMainScreen.tapMenuCart();
        ozonMainScreen.tapMenuFavorites();
        ozonMainScreen.tapMenuProfile();
        ozonMainScreen.tapMenuMain();
         */

        ozonMainScreen.tapMenuCatalog();
        ozonMainScreen.searchOzon("test");

    }
}
