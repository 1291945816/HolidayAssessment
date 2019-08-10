package com.kexie.Course.Task;

import com.kexie.Course.pojo.courseItem;
import com.kexie.Course.service.courseService;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class getItem {
    @Autowired
    private courseService service;
    //@Autowired
    //private courseItem item;
    
    

    //涉及隐私
    private String username = "xxxx";
    private String passwd="xxxx";
    private final String URL="http://172.16.1.99/student/public/login.asp";

    @Autowired
    public void proccess(){
        String html = getHtml(URL);
        parseHtml(html);
        System.out.println("课表下载完成......");
    }

    private void parseHtml(String html){

        Document doc = Jsoup.parse(html);
       Element eles = doc.select("table").first();
       Elements eles01=eles.select("tr");
       for(int i = 1;i < 6;i++){
           courseItem item = new courseItem();
           Element e = eles01.get(i);
           Elements eles02 = e.select("td");
           item.setMonday(eles02.get(0).text());
           item.setTuesday(eles02.get(1).text());
           item.setWednesday(eles02.get(2).text());
           item.setThursday(eles02.get(3).text());
           item.setFriday(eles02.get(4).text());
           item.setSaturday(eles02.get(5).text());
           item.setSunday(eles02.get(6).text());
           this.service.save(item);
       }






    }
    /*
    *
    * @param url  解析的网址
    *
     */
    private String getHtml(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //通过标签  输入用户名以及密码
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("passwd")).sendKeys(passwd);
        driver.findElement(By.name("login")).click();
        //找到相应的元素  其后便调入嵌入在里面的表单
        WebElement xf = driver.findElement(By.cssSelector("frame[name=contents]"));

        //跳到内嵌的表单
        driver.switchTo().frame(xf);

        System.out.println(driver.getPageSource());
        driver.findElement(By.linkText("课　　表")).click();
        //跳出来
        driver.switchTo().defaultContent();

        WebElement af = driver.findElement(By.cssSelector("frame[name=main]"));
        driver.switchTo().frame(af);
        WebElement el = driver.findElement(By.cssSelector("select[name=term]"));

        //下拉框的选择
        Select sel = new Select(el);
        sel.selectByIndex(1);
        driver.findElement(By.cssSelector("input[type = submit]")).click();
        driver.switchTo().defaultContent();
        WebElement bf = driver.findElement(By.cssSelector("frame[name=main]"));
        driver.switchTo().frame(bf);
        String html = driver.getPageSource();
        driver.close();
        return html;
    }


}
