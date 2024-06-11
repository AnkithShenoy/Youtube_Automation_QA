package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;


public class TestCases {
    ChromeDriver driver;

 
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

       

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }


    @Test
    public void testCase01() throws InterruptedException{
    driver.get("https://flipkart.com/");
    Thread.sleep(2000);
    WebElement Searchbox = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));
    Searchbox.sendKeys("Washing Machine");
    Searchbox.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]")).click();
    Thread.sleep(2000);

    List<WebElement> elementsWithRatingLessThanEqual4 = driver.findElements(By.xpath("//div[@class='XQDdHH']"));
    int count=0;
    for(WebElement ratingElement:elementsWithRatingLessThanEqual4 ){
    Thread.sleep(2000);
    float rating = Float.parseFloat(ratingElement.findElement(By.xpath("//div[@class='XQDdHH']")).getText());

    if(rating<=4.0){
      count++;
    }
    }
    System.out.println("count of ratings less than 4 : " + count);
    Thread.sleep(2000);
    System.out.println("End Test case: testCase01");
  }

  @Test
  public void testCase02() throws InterruptedException{
  driver.get("https://flipkart.com/");
  Thread.sleep(2000);
  WebElement Searchbox = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));
  Searchbox.sendKeys("iphone");
  Searchbox.sendKeys(Keys.ENTER);
  Thread.sleep(2000);
  List<WebElement> discount_list = driver.findElements(By.xpath("//div[@class='UkUFwK']/span"));
  Thread.sleep(2000);
  for (WebElement item : discount_list) {
      String discount_string = item.getText();
      int discount_int = Integer.parseInt(discount_string.replaceAll("[^0-9]", "")); 
      if (discount_int > 17) {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        for (WebElement e : elements) {
            System.out.println(e.getText()+ discount_string);
        }
      } 
      else {
          continue;
        }
    }
  }

  @Test
  public void testCase03() throws InterruptedException{
  driver.get("https://flipkart.com/");
  Thread.sleep(2000);
  WebElement Searchbox = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));
  Searchbox.sendKeys("Coffee Mug");
  Searchbox.sendKeys(Keys.ENTER);
  Thread.sleep(2000);
  WebElement checkbox=driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[1]/div/div/div/section[5]/div[2]/div/div[1]/div/label/div[2]"));
  checkbox.click();
  Thread.sleep(2000);
  List<WebElement> title = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
        for(int i=0;i<title.size();i++){
            System.out.println(title.get(i).getText());
            
        }


  }
    @AfterTest
    public void endTest()
    {
        // driver.close();
        driver.quit();

    }
}