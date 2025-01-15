package com.studentmanagement.controller;

import com.studentmanagement.model.StudentDTO;
import com.studentmanagement.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AddStudent {
    @Autowired
    InsertService insertservice;

    @GetMapping("/addStudent")
    public String showAddStudentForm() {
        return "form";
    }

    @PostMapping("/insertStudent")
    @ResponseBody
    public ResponseEntity<Map<String, String>> insertStudent(@RequestBody StudentDTO student) {

        int result=insertservice.insertstudent(student);

        if(result!=0) {
            Map<String, String> response = new HashMap<>();
            response.put("message", result + " rows updated successfully..");
            response.put("status", "success");

            return ResponseEntity.ok(response);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", " failed to insert..");
        response.put("status", "failure");
        return ResponseEntity.ok(response);
    }
}
