package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.DiscussionForum;
import com.example.learningmanagementsystem.model.Student;
import com.example.learningmanagementsystem.repository.DiscussionForumRepository;
import com.example.learningmanagementsystem.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class DiscussionForumController {

    @Autowired
    private DiscussionForumRepository discussionForumRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    // Functionality of save button
    @RequestMapping (value="/saveComment", method=RequestMethod.POST)
    public String saveComment(@ModelAttribute("comment") DiscussionForum df){
        df.setId(sequenceGeneratorService.generateSequence(DiscussionForum.SEQUENCE_NAME));
        discussionForumRepository.save(df);
        return "redirect:/allComments";
    }

    // Save updated content
    @RequestMapping(value = "/saveExistingComment", method = RequestMethod.POST)
    public String saveExistingStudent(@ModelAttribute("df") DiscussionForum df){
        System.out.println("Working");
        discussionForumRepository.save(df);
        return "editComment";
    }

    // Add comment route
    @GetMapping("/addComment")
    public String addComment(Model model){
        model.addAttribute("comment",new DiscussionForum());
        return "addComment";
    }

    // Get all comments
    @GetMapping("/allComments")
    public String getComments(Model model){
        List<DiscussionForum>  listForum = discussionForumRepository.findAll();
        model.addAttribute("listForum",listForum);
        return "discussionForum";
    }

    // Delete comment
    @RequestMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable long id){
        discussionForumRepository.deleteById((int)id);
        return "redirect:/allComments";
    }

    //Edit comment
    @RequestMapping(value="/editComment/{id}")
    public ModelAndView showEditCommentPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editComment");
        Optional<DiscussionForum> df = discussionForumRepository.findById((int)id);
        mav.addObject("df", df);
        return mav;
    }
}
