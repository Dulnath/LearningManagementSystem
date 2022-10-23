package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.model.Student;
import com.example.learningmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student abc){
        studentRepository.save(abc);
        return "redirect:/allstudents";
    }

    @RequestMapping(value="/editStudent/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("newstudent");
        Optional<Student> std = studentRepository.findById(id);
        mav.addObject("student", std);
        return mav;

    }
    @GetMapping("/allStudents")
    public String getStudents(Model model){
        List<Student>  liststudent = studentRepository.findAll();
        model.addAttribute("liststudent",liststudent);
        return "allstudents";
    }

    @GetMapping("/newStudent")
    public String newStudentPage(Model model){
        model.addAttribute("student",new Student());
        return "newstudent";
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentRepository.deleteById(id);
        return "redirect:/allStudents";
    }

}