package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

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
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        driver.quit();
    }

}
