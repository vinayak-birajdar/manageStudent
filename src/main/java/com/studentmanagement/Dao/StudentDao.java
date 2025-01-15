package com.studentmanagement.Dao;

import com.studentmanagement.model.StudentDTO;

import java.util.List;

public interface StudentDao {

    public int insert(StudentDTO student);
    boolean deletebyName(String name);

    public List<StudentDTO> displayallstudent();
    public List<StudentDTO> searcbyname(String name);
    public int updateByRollno(StudentDTO dto);

}
