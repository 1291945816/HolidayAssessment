package cn.kexie.selectedCourse.pojo;


import javax.persistence.*;

//声明这是一个数据库表的实体
@Entity
@Table(name = "selectedcourse")

public class SCourseItem {
    //声明主键以及自增类型
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //学号
    @Column(name = "stuID")
    private String stuID;
    //课程代码
    @Column(name = "courseCode")
    private String courseCode;
    //课程号
    @Column(name="courseID")
    private String courseID;
    //课程名称
    @Column(name="courseName")
    private String courseName;
    //课程性质
    @Column(name = "courseNature")
    private String courseNature;
    //学分
    @Column(name = "credit")
    private Double credit;
    //课程类别
    @Column(name = "coucategory")
    private String coucategory;
    //选课时间
    @Column(name = "selectedDate")
    private String selectedDate;
    //描述
    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNature() {
        return courseNature;
    }

    public void setCourseNature(String courseNature) {
        this.courseNature = courseNature;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getCoucategory() {
        return coucategory;
    }

    public void setCoucategory(String coucategory) {
        this.coucategory = coucategory;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SCourseItem{" +
                "id=" + id +
                ", stuID='" + stuID + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseNature='" + courseNature + '\'' +
                ", credit=" + credit +
                ", coucategory='" + coucategory + '\'' +
                ", selectedDate='" + selectedDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
