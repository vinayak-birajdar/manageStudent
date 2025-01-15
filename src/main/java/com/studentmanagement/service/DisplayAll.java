package com.studentmanagement.service;

import com.studentmanagement.Dao.StudentDaoImpl;
import com.studentmanagement.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayAll {

    @Autowired
    StudentDaoImpl studentdaoimpl;

    public List<StudentDTO> displayService(){
        List<StudentDTO> list=studentdaoimpl.displayallstudent();
        return list;
    }

}
