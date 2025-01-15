package com.studentmanagement.Dao;

import org.springframework.jdbc.core.RowMapper;
import com.studentmanagement.model.StudentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentDTO> {
    @Override
    public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentDTO s1=new StudentDTO();
        s1.setRollNo(rs.getString("rollNo"));
        s1.setName(rs.getString("name"));
        s1.setAge(rs.getString("age"));
        s1.setClassDiv(rs.getString("classDiv"));
        s1.setPhoneNumber(rs.getString("phoneNumber"));
        return s1;
    }
}
