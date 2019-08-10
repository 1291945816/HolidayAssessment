package com.kexie.Course.impl;

import com.kexie.Course.dao.ItemDao;
import com.kexie.Course.pojo.courseItem;
import com.kexie.Course.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//业务逻辑上的

@Service
public class serviceImpl implements courseService {
    //从容器中自动注入dao
    @Autowired
    private ItemDao itemDao;

    @Override
    @Transactional
    public void save(courseItem item) {
        this.itemDao.save(item);
    }
}
