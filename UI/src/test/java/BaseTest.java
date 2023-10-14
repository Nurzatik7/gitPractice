import org.digital.driver.Driver;
import org.digital.pages.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

   public  WebDriver driver;
   public TextBoxPage textBoxPage;


    @BeforeClass (alwaysRun = true)
    public void setUpBrowser(){
        driver = Driver.getDriver();
        textBoxPage = new TextBoxPage();

    }
//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        Driver.closeDriver();
//    }
}
