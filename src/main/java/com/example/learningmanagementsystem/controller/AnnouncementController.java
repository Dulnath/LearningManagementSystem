package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Announcement;

import com.example.learningmanagementsystem.repository.AnnouncementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AnnouncementController {
    @Autowired
    private AnnouncementRepository announcementRepository;


    @RequestMapping(value = "/addAnnouncement", method = RequestMethod.POST)
    public String saveAnnouncement(@ModelAttribute("announcement") Announcement anncmnt){
        announcementRepository.save(anncmnt);
        return "redirect:/allannouncements";
    }

    @RequestMapping(value="/editAnnouncement/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("newannouncement");
        Optional<Announcement> anncmnt = announcementRepository.findById(id);
        mav.addObject("announcement", anncmnt);
        return mav;

    }
    @GetMapping("/allAnnouncements")
    public String getAnnouncements(Model model){
        List<Announcement>  listsannouncements = announcementRepository.findAll();
        model.addAttribute("listannouncement",listsannouncements);
        return "allannouncements";
    }

    @GetMapping("/newAnnouncement")
    public String newAnnouncementPage(Model model){
        model.addAttribute("announcement",new Announcement());
        return "newannouncement";
    }
    /*
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        announcementRepository.deleteById(id);
        return "redirect:/allAnnouncements";
    }*/

}