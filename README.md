 # 这是一个爬虫项目

## 关于该项目:
该项目使用了spring boot框架，省去了很多底层代码的编写，比如数据库的连接，数据的插入，直接由spring boot 底层操作，而我们只需配置好就可以使用，只需花更多时间关注表层的逻辑设计，其次使用了selenium框架，简单的爬虫，只能爬取静态html页面，无法获取由js加载的数据，这就限制我们的爬取内容的范围，这里使用该框架，模拟用户点击浏览器的操作，以便获取动态产生的资源，同时更能够模拟用户登陆界面，获取登陆后的内容，这也是使用其的一大原因，同时这里也借助了tess4j工具，解决了登陆遇到的验证码问题，最后直接就用Jsoup解析页面     [关于该项目](https://github.com/1291945816/HolidayAssessment/tree/master/Crawler)
## 项目结构
![](https://github.com/1291945816/HolidayAssessment/blob/master/image/Snipaste_2019-08-10_19-53-39.png)
### 数据库的设计
![](https://github.com/1291945816/HolidayAssessment/blob/master/image/Snipaste_2019-08-09_20-24-03.png)

### 爬取效果对比（p1 vs p2）
![](https://github.com/1291945816/HolidayAssessment/blob/master/image/Snipaste_2019-08-10_20-03-16.png)

![](https://github.com/1291945816/HolidayAssessment/blob/master/image/Snipaste_2019-08-10_21-34-44.png)


## 项目前的小试牛刀

### 项目的结构

![](https://github.com/1291945816/HolidayAssessment/blob/master/image/Snipaste_2019-08-06_18-10-54.png)

### 数据库表的设计

![](https://github.com/1291945816/HolidayAssessment/blob/master/image/Snipaste_2019-08-06_18-10-29.png)

### 爬取效果图

![](https://github.com/1291945816/HolidayAssessment/blob/master/image/效果.png)
[关于上述项目获取请点击这里](https://github.com/1291945816/HolidayAssessment/tree/master/testCrawler)




