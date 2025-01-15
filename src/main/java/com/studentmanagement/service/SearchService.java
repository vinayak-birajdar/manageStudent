package com.studentmanagement.service;

import com.studentmanagement.Dao.StudentDaoImpl;
import com.studentmanagement.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchService {
    @Autowired
    StudentDaoImpl studentdaoimpl;
    public List<StudentDTO> searchStudent(String name){
        return studentdaoimpl.searcbyname(name);
    }
}
