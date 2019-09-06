package cn.kexie.selectedCourse.TaskMain;

import cn.kexie.selectedCourse.Utils.DownLoadHtml;
import cn.kexie.selectedCourse.Utils.IdentificationCode;
import cn.kexie.selectedCourse.dao.ItemRespo;
import cn.kexie.selectedCourse.pojo.SCourseItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


//由
@Component
public class GetItem {

    //自己注入dao
    @Autowired
    private ItemRespo itemRespo;


    @Autowired
    public void Task(){
        try {
            List<String>  pageHtml = DownLoadHtml.doGetHtml();
           //解析页面保存并获取的数据存入数据库中
            this.parse01(pageHtml.get(0));
            this.parse01(pageHtml.get(1));
            this.parse01(pageHtml.get(2));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void parse01(String html){



       Document doc =  Jsoup.parse(html);
       Elements elements = doc.select("tbody#gridview-1063-body>tr");
       for(Element ele:elements){
           //每一行是一个元素
           SCourseItem sCourseItem = new SCourseItem();

           //得到一行  并将其存入数据库中
           Elements elements1 = ele.select("td");
           sCourseItem.setStuID(elements1.get(1).text());
           sCourseItem.setCourseCode(elements1.get(2).text());
           sCourseItem.setCourseID(elements1.get(3).text());
           sCourseItem.setCourseName(elements1.get(4).text());
           sCourseItem.setCourseNature(elements1.get(5).text());
           sCourseItem.setCredit(Double.valueOf(elements1.get(6).text()));
           sCourseItem.setCoucategory(elements1.get(7).text());
           sCourseItem.setSelectedDate(elements1.get(8).text());
           sCourseItem.setDescription(elements1.get(9).text());
           itemRespo.save(sCourseItem);

    }






    }


}
