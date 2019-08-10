package cn.kexie.selectedCourse.Service;


import cn.kexie.selectedCourse.pojo.SCourseItem;
import org.springframework.stereotype.Service;


//逻辑上的操作
@Service
public interface SelectedCourseService {
    public void save(SCourseItem item);
}
