package tsw.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriver2 extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://tsws4s.com/tsw7";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWebDriver2() throws Exception {
	    driver.get(baseUrl + "/login");
	    driver.findElement(By.name("j_username")).clear();
	    driver.findElement(By.name("j_username")).sendKeys("tim@simplyt3s.com");
	    driver.findElement(By.name("j_password")).clear();
	    driver.findElement(By.name("j_password")).sendKeys("deb");
	    driver.findElement(By.cssSelector("input.submit.right")).click();
	    driver.findElement(By.xpath("(//img[@alt='tools'])[2]")).click();
	    driver.findElement(By.cssSelector("img.icon")).click();
	    driver.findElement(By.xpath("//img[@alt='Edit']")).click();
    driver.get(baseUrl + "/indexLeague");
    driver.findElement(By.xpath("(//img[@alt='tools'])[2]")).click();
    driver.findElement(By.name("new")).click();
    driver.findElement(By.id("program_programName")).clear();
    driver.findElement(By.id("program_programName")).sendKeys("LeagueName1");
    new Select(driver.findElement(By.id("itemSelected1"))).selectByVisibleText("Men");
    driver.findElement(By.cssSelector("img.ui-datepicker-trigger")).click();
    driver.findElement(By.linkText("14")).click();
    new Select(driver.findElement(By.id("itemSelected11"))).selectByVisibleText("$ 95.00 - Daytime");
    driver.findElement(By.xpath("(//img[@alt='...'])[2]")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
    driver.findElement(By.linkText("13")).click();
    driver.findElement(By.id("program_publishYn")).click();
    driver.findElement(By.linkText("Coordinator")).click();
    new Select(driver.findElement(By.id("itemSelectedsport4"))).selectByVisibleText("Baseball");
    driver.findElement(By.id("program_gamesPerTeam")).clear();
    driver.findElement(By.id("program_gamesPerTeam")).sendKeys("12");
    new Select(driver.findElement(By.id("program_gameMins"))).selectByVisibleText("60 Mins");
    new Select(driver.findElement(By.id("itemSelected8"))).selectByVisibleText("Highland Field");
    driver.findElement(By.id("save")).click();
    driver.get(baseUrl + "/indexLeague");
    driver.findElement(By.xpath("(//img[@alt='tools'])[2]")).click();
    driver.findElement(By.name("new")).click();
    driver.findElement(By.id("program_programName")).clear();
    driver.findElement(By.id("program_programName")).sendKeys("LeagueName2");
    new Select(driver.findElement(By.id("itemSelected1"))).selectByVisibleText("Men");
    driver.findElement(By.cssSelector("img.ui-datepicker-trigger")).click();
    driver.findElement(By.linkText("14")).click();
    new Select(driver.findElement(By.id("itemSelected11"))).selectByVisibleText("$ 95.00 - Daytime");
    driver.findElement(By.xpath("(//img[@alt='...'])[2]")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
    driver.findElement(By.linkText("13")).click();
    driver.findElement(By.id("program_publishYn")).click();
    driver.findElement(By.linkText("Coordinator")).click();
    new Select(driver.findElement(By.id("itemSelectedsport4"))).selectByVisibleText("Baseball");
    driver.findElement(By.id("program_gamesPerTeam")).clear();
    driver.findElement(By.id("program_gamesPerTeam")).sendKeys("12");
    new Select(driver.findElement(By.id("program_gameMins"))).selectByVisibleText("60 Mins");
    new Select(driver.findElement(By.id("itemSelected8"))).selectByVisibleText("Highland Field");
    driver.findElement(By.id("save")).click();
    driver.get(baseUrl + "/indexLeague");
    driver.findElement(By.xpath("(//img[@alt='tools'])[2]")).click();
    driver.findElement(By.name("new")).click();
    driver.findElement(By.id("program_programName")).clear();
    driver.findElement(By.id("program_programName")).sendKeys("LeagueName3");
    new Select(driver.findElement(By.id("itemSelected1"))).selectByVisibleText("Men");
    driver.findElement(By.cssSelector("img.ui-datepicker-trigger")).click();
    driver.findElement(By.linkText("14")).click();
    new Select(driver.findElement(By.id("itemSelected11"))).selectByVisibleText("$ 95.00 - Daytime");
    driver.findElement(By.xpath("(//img[@alt='...'])[2]")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
    driver.findElement(By.linkText("13")).click();
    driver.findElement(By.id("program_publishYn")).click();
    driver.findElement(By.linkText("Coordinator")).click();
    new Select(driver.findElement(By.id("itemSelectedsport4"))).selectByVisibleText("Baseball");
    driver.findElement(By.id("program_gamesPerTeam")).clear();
    driver.findElement(By.id("program_gamesPerTeam")).sendKeys("12");
    new Select(driver.findElement(By.id("program_gameMins"))).selectByVisibleText("60 Mins");
    new Select(driver.findElement(By.id("itemSelected8"))).selectByVisibleText("Highland Field");
    driver.findElement(By.id("save")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
