package com.kexie.Course.dao;

import com.kexie.Course.pojo.courseItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemDao extends JpaRepository<courseItem,Integer> {

}
