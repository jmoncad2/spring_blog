package com.codeup.controllers;


import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    private final PostSvc postDao;

    @Autowired
    public PostsController(PostSvc postDao){
        this.postDao = postDao;
    }

    @GetMapping("posts")
    public String viewAll(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("posts/create")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String savePost(@ModelAttribute Post post) {
        System.out.println(post.getTitle());
        return "posts/create";
    }

    @PostMapping("posts/{id}/edit")
    public String editPost() {

    }
}
