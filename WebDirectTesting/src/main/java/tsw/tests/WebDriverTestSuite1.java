package tsw.tests;
import junit.framework.Test;
import junit.framework.TestSuite;

public class WebDriverTestSuite1 {

  public static Test suite() {
    TestSuite suite = new TestSuite();
//    suite.addTestSuite(WebDriver1.class);
    suite.addTestSuite(WebDriver2.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
