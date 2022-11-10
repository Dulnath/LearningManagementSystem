package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.model.Student;
import com.example.learningmanagementsystem.model.Teacher;
import com.example.learningmanagementsystem.repository.StudentRepository;
import com.example.learningmanagementsystem.repository.TeacherRepository;
import com.example.learningmanagementsystem.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping(value = "/saveTeacher", method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("teacher") Teacher tch){
        teacherRepository.save(tch);
        return "redirect:/allTeachers";
    }


    @RequestMapping(value="/editTeacher/{id}")
    public ModelAndView showEditTeacherPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("editteacher");
        Optional<Teacher> tch = teacherRepository.findById(id);
        mav.addObject("teacher", tch);
        return mav;

    }
    @GetMapping("/allTeachers")
    public String getTeachers(Model model){
        List<Teacher>  listteacher = teacherRepository.findAll();
        model.addAttribute("listteacher",listteacher);
        return "allteachers";
    }

    @GetMapping("/newTeacher")
    public String newTeacherPage(Model model){
        model.addAttribute("teacher",new Teacher());
        return "newteacher";
    }
    @RequestMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable String id){
        teacherRepository.deleteById(id);
        return "redirect:/allTeachers";
    }

}