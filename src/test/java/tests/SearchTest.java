package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComTest(String text) throws InterruptedException {

        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Selenium WebDriver")
                .verifyThatTopResultContainsProperAttributeText("LC20lb");

    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        steps.openTooltip()
                .verifyThatTooltipContainsProperText("Голосовой поиск");
    }

    @Test
    public void openGoogleComInChromeTest() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("uMousc")));
        driver.findElement(By.id("L2AGLb")).click();
        driver.switchTo().defaultContent();

        //WebElement searchField = driver.findElement(By.name("q"));  - example 1
        WebElement googleAppsBtn = driver.findElement(By.cssSelector("div#gbwa a"));
        googleAppsBtn.click();

        driver.quit();
    }

    /*

    */

    @Test
    public void openGoogleComInChromeTest_01() throws InterruptedException {
        File file = new File("src/test/resources/geckodriver.exe");
        System.setProperty("webdriver.firefox.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.lv/");
        System.out.println(driver.getTitle());

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("uMousc")));
       // driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.id("W0wltc")).click();
        driver.switchTo().defaultContent();

        WebElement searchField = driver.findElement(By.name("q"));
        WebElement googleAppsBtn = driver.findElement(By.cssSelector("div#gbwa a"));
        searchField.click();
        searchField.sendKeys("Rīga");

      //  Thread.sleep(3000);
       //   searchField.sendKeys(Keys.RETURN);
      //  WebElement resultRow = driver.findElement(By.cssSelector("h3#_UtAcae7cL9SW1fIPhceBgAY_44"));
        //System.out.println(resultRow.getText());
      //  assertTrue(resultRow.isDisplayed(), "Element has not been displayed");
       // assertEquals(resultRow.getText(), "Selenium Webdriver - Selenium Documentation", "Wrong text has been displayed");
        //System.out.println(resultRow.getAttribute("class"));
      //  assertEquals(resultRow.getAttribute("class"), "LC201b", "Wrong attribute text");
    //    driver.quit();
    }

}
