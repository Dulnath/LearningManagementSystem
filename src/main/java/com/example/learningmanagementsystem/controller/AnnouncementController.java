package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Announcement;
import com.example.learningmanagementsystem.model.Subject;
import com.example.learningmanagementsystem.repository.AnnouncementRepository;
import com.example.learningmanagementsystem.services.SequenceGeneratorService;
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

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @RequestMapping(value = "/saveAnnouncement", method = RequestMethod.POST)
    public String saveAnnouncement(@ModelAttribute("announcement") Announcement ancmnt){
        ancmnt.setId(sequenceGeneratorService.generateSequence(Announcement.SEQUENCE_NAME));
        announcementRepository.save(ancmnt);
        return "redirect:/allAnnouncements";
    }

    @RequestMapping(value = "/saveExistingAnnouncement", method = RequestMethod.POST)
    public String saveExistingAnnouncement(@ModelAttribute("announcement") Announcement ancmnt){
        System.out.println("Working");
        announcementRepository.save(ancmnt);
        return "editannouncement";
    }

    @RequestMapping(value="/editAnnouncement/{id}")
    public ModelAndView showEditAnnouncementPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editannouncement");
        Optional<Announcement> ancmnt = announcementRepository.findById((int)id);
        mav.addObject("announcement", ancmnt);
        return mav;

    }
    @GetMapping("/allAnnouncements")
    public String getStudents(Model model){
        List<Announcement>  listannouncement = announcementRepository.findAll();
        model.addAttribute("listannouncement",listannouncement);
        return "allannouncements";
    }

    @GetMapping("/oneAnnouncement/{id}")
    public ModelAndView showOneSubjectPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("subjectsone");
        Optional<Announcement> announcement = announcementRepository.findById((int)id);
        mav.addObject("announcement", announcement);
        return mav;

    }

    @GetMapping("/newAnnouncement")
    public String newAnnouncementPage(Model model){
        model.addAttribute("announcement",new Announcement());
        return "newannouncement";
    }
    @RequestMapping("/deleteAnnouncement/{id}")
    public String deleteAnnouncement(@PathVariable long id){
        announcementRepository.deleteById((int)id);
        return "redirect:/allAnnouncements";
    }

}

