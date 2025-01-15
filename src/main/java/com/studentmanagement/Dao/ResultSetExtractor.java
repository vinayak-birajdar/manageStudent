package com.studentmanagement.Dao;

import org.springframework.dao.DataAccessException;
import com.studentmanagement.model.StudentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetExtractor implements org.springframework.jdbc.core.ResultSetExtractor<List<StudentDTO>> {
    @Override
    public List<StudentDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<StudentDTO> l1 = new ArrayList<>();
        while (rs.next()) {
            StudentDTO s1 = new StudentDTO();
            s1.setRollNo(rs.getString("rollNo"));
            s1.setName(rs.getString("name"));
            s1.setAge(rs.getString("age"));
            s1.setClassDiv(rs.getString("classDiv"));
            s1.setPhoneNumber(rs.getString("phoneNumber"));
            l1.add(s1);
        }
        return l1;
    }
}
