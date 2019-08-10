package cn.kexie.selectedCourse.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据验证码破解后  顺便获取带Html
 */
@Component
public class DownLoadHtml {
    //涉及隐私
    private static final String USER_NAME = "xxxxx";
    private static final String PASSWORD ="xxxxx";
    private static final String URL = "http://bkjw.guet.edu.cn/?mCode=000708";

    /**
     *
     *
     * @return  Html数据(含有所需数据的)
     */

    public static List<String> doGetHtml(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        List<String> pageHtml = new ArrayList<String>();
        //输入用户名以及密码
        driver.findElement(By.id("textfield-1013-bodyEl")).findElement(By.id("textfield-1013-inputEl")).sendKeys(USER_NAME);
        driver.findElement(By.id("textfield-1014-bodyEl")).findElement(By.id("textfield-1014-inputEl")).sendKeys(PASSWORD);

        //截取全屏
        //截取全屏 并截取至验证码部分
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(src);
            image = image.getSubimage(1037, 516, 58, 16);
            ImageIO.write(image, "png", new File("D:\\javaCode\\kexieHolidayAssessment\\src\\main\\resources\\Image\\screen.png"));
            String s = IdentificationCode.process();
            //输入验证码
            driver.findElement(By.id("CheckCode-inputEl")).sendKeys(s);
            Thread.sleep(4000);

            //关闭公告窗口
            driver.findElement(By.cssSelector("#tool-1043")).click();
            Thread.sleep(2000);

            //选择  已选课程
            driver.findElement(By.id("treeview-1014-record-bstuk070")).click();
            Thread.sleep(2000);

            //点击下拉
            driver.findElement(By.id("ext-gen1193")).click();
            Thread.sleep(2000);

            List<WebElement> eles = driver.findElements(By.cssSelector("[class=x-list-plain]>li"));

            //选择2018-2019学期
            eles.get(3).click();
            Thread.sleep(3000);

            //点击查询
            driver.findElement(By.id("button-1050-btnIconEl")).click();
            Thread.sleep(2000);

            pageHtml.add(driver.getPageSource());

            //切换页面  再次获取
            driver.findElement(By.id("ext-gen1193")).click();
            Thread.sleep(3000);


            eles.get(2).click();

            Thread.sleep(3000);
            //点击查询
            driver.findElement(By.id("button-1050-btnIconEl")).click();
            Thread.sleep(2000);
            pageHtml.add(driver.getPageSource());

            //切换页面  再次获取
            driver.findElement(By.id("ext-gen1193")).click();
            Thread.sleep(3000);

            eles.get(1).click();

            Thread.sleep(3000);
            //点击查询
            driver.findElement(By.id("button-1050-btnIconEl")).click();
            Thread.sleep(2000);
            pageHtml.add(driver.getPageSource());
            driver.quit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    return pageHtml;
    }





}
