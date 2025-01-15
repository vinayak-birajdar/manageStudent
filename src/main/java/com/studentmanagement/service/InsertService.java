package com.studentmanagement.service;

import com.studentmanagement.Dao.StudentDaoImpl;
import com.studentmanagement.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertService {
    @Autowired
    private StudentDaoImpl studentdaoimpl;

    public int insertstudent(StudentDTO student) {
        return studentdaoimpl.insert(student);

    }
}
