package com.studentmanagement.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.studentmanagement.model.StudentDTO;

import java.sql.Types;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbctemplate;

    @Override
    public int insert(StudentDTO student){
        String sql="insert into  student_data (rollNo,name,age,classDiv,phoneNumber) values (?,?,?,?,?)";
        Object[] args={student.getRollNo(),student.getName(),student.getAge(),student.getClassDiv(),student.getPhoneNumber()};
        int rowinserted=jdbctemplate.update(sql,args);
        return rowinserted;
    }

    @Override
    public boolean deletebyName(String name) {

        String sql = "delete from student_data where name=?";
        int rowupdate=jdbctemplate.update(sql, name);
        if(rowupdate>=1) {
            return true;
        }
            return false;
    }

    @Override
    public List<StudentDTO> displayallstudent(){
        String sql="select * from student_data";

        List<StudentDTO> list=jdbctemplate.query(sql,new ResultSetExtractor());
        return list;
    }
    @Override
    public List<StudentDTO> searcbyname(String name){
        String sql="select * from student_data where name= ?";
        Object[] args={name};
        List<StudentDTO> list=jdbctemplate.query(sql,args,new StudentRowMapper());
        return list;
    }
    @Override
    public int updateByRollno(StudentDTO obj){

        String sql = "update student_data set name=?,age=?,classDiv=?,phoneNumber=? where rollNo=?";
        Object[] args={obj.getName(),obj.getAge(),obj.getClassDiv(),obj.getPhoneNumber(),obj.getRollNo()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        int rowupdate = jdbctemplate.update(sql, args, argTypes);
        return rowupdate;


    }

}
