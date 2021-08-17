import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class OzonMainScreen {
    private AndroidDriver driver;
    private TouchAction touchAction;

    OzonMainScreen(AndroidDriver driver) {
        this.driver = driver;
        touchAction = new TouchAction(driver);
    }

    private TouchAction getLastAction() {
        return this.touchAction;
    }

    public void tapMenuMain() {
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_main")))))
                .perform();
    }

    public void tapMenuCatalog() {
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_catalog")))))
                .perform();
    }

    public void tapMenuCart() {
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_cart")))))
                .perform();
    }

    public void tapMenuFavorites() {
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_favorites")))))
                .perform();
    }

    public void tapMenuProfile() {
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/menu_profile")))))
                .perform();
    }

    public void searchOzon(String text) {
        //Check if search field is available on the current screen
        if (
            driver.findElement(By.id("ru.ozon.app.android:id/menu_cart")).isSelected() ||
            driver.findElement(By.id("ru.ozon.app.android:id/menu_profile")).isSelected()
        )
        {
            //Switch to the main screen if not
            tapMenuMain();
        }

        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(driver.findElement(By
                        .id("ru.ozon.app.android:id/searchTv")))))
                .perform();

        Actions a = new Actions(driver);
        a.sendKeys(text + "\n");
        a.perform();
    }


}