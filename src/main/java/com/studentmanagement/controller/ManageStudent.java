package com.studentmanagement.controller;

import com.studentmanagement.service.DeleteService;
import com.studentmanagement.service.DisplayAll;
import com.studentmanagement.service.SearchService;
import com.studentmanagement.service.updateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.studentmanagement.model.StudentDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManageStudent {
    @Autowired
    DisplayAll displayall;
    @Autowired
    DeleteService deleteservice;
    @Autowired
    SearchService searchservice;
    @Autowired
    updateService updateservice;


    @GetMapping("/manageStudent")
    public String manageStudent() {
        return "managestudents";

    }

    @GetMapping("/displayAll")
    public String displayall(Model model) {
        model.addAttribute("studentss", displayall.displayService());
        return "displayall";
    }

    @GetMapping("/searchStudent")
    public String serchbyname(@RequestParam("name") String name, Model model) {
        List<StudentDTO> l1 = searchservice.searchStudent(name);
        model.addAttribute("studentss", l1);

        return "displayall";

    }


    @PostMapping("/updateStudent")
    @ResponseBody
    public ResponseEntity<Map<String, String>> updateStudent(@RequestBody StudentDTO student) {
        int result=updateservice.updateStudent(student);
        if(result>0) {
            Map<String, String> response = new HashMap<>();
            response.put("message", student.getName() + " updated successfully..");
            response.put("status", "success");

            return ResponseEntity.ok(response);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", student.getName() + " failed to update..");
        response.put("status", "failure");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/deleteStudent")
    @ResponseBody
    public ResponseEntity<Map<String, String>> deleteStudent(@RequestBody StudentDTO student) {

        boolean result = deleteservice.deleteservice(student.getName());

        if (result != false) {
            Map<String, String> response = new HashMap<>();
            response.put("message", student.getName() + " updated successfully..");
            response.put("status", "success");

            return ResponseEntity.ok(response);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", student.getName() + " failed to delete..");
        response.put("status", "failure");
        return ResponseEntity.ok(response);
    }


}
