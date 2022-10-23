package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.DiscussionForum;
import com.example.learningmanagementsystem.repository.DiscussionForumRepository;
import com.example.learningmanagementsystem.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DiscussionForumController {

    @Autowired
    private DiscussionForumRepository discussionForumRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;



    // Functionality of save button
    @RequestMapping (value="/saveComment", method=RequestMethod.POST)
    public String saveComment(@ModelAttribute("discussionForum") DiscussionForum df){
        df.setId(sequenceGeneratorService.generateSequence(DiscussionForum.SEQUENCE_NAME));
        discussionForumRepository.save(df);
        return "redirect:/allComments";
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
}
