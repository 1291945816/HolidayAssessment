package cn.kexie.selectedCourse.dao;

import cn.kexie.selectedCourse.pojo.SCourseItem;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa  数据库的一个抽象
public interface ItemRespo extends JpaRepository<SCourseItem,Integer> {
}
