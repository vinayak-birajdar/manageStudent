package com.studentmanagement.service;

import com.studentmanagement.Dao.StudentDaoImpl;
import com.studentmanagement.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class updateService {
    @Autowired
    StudentDaoImpl studentdaoimpl;

    public int updateStudent(StudentDTO obj){

         return studentdaoimpl.updateByRollno(obj);

    }
}
