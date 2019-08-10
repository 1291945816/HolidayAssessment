package cn.kexie.selectedCourse.impl;

import cn.kexie.selectedCourse.Service.SelectedCourseService;
import cn.kexie.selectedCourse.dao.ItemRespo;
import cn.kexie.selectedCourse.pojo.SCourseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//由spring boot创建它的实例
@Component
public class ServiceImpl implements SelectedCourseService {
    //自动注入
    @Autowired
    private ItemRespo itemRespo;
    //设计数据库的插入  搞成事务型
    @Transactional
    @Override
    public void save(SCourseItem item) {
        this.itemRespo.save(item);

    }
}
