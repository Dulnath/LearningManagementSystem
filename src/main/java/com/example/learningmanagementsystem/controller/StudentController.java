package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Student;
import com.example.learningmanagementsystem.repository.StudentRepository;
import com.example.learningmanagementsystem.services.SequenceGeneratorService;
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

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std){
        std.setId(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
        studentRepository.save(std);
        return "redirect:/allStudents";
    }

    @RequestMapping(value = "/saveExistingStudent", method = RequestMethod.POST)
    public String saveExistingStudent(@ModelAttribute("student") Student std){
        System.out.println("Working");
        studentRepository.save(std);
        return "editstudent";
    }

    @RequestMapping(value="/editStudent/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editstudent");
        Optional<Student> std = studentRepository.findById((int)id);
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
    public String deleteStudent(@PathVariable long id){
        studentRepository.deleteById((int)id);
        return "redirect:/allStudents";
    }

}