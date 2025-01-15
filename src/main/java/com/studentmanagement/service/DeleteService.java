package com.studentmanagement.service;

import com.studentmanagement.Dao.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
    @Autowired
    private StudentDaoImpl studentdaoimpl;

    public boolean deleteservice(String name) {

      return studentdaoimpl.deletebyName(name);

    }
}

