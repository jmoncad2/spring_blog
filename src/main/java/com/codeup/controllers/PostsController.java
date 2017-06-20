package com.codeup.controllers;


import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostsController {

    @GetMapping("posts")
    public String viewAll(Model model) {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("test post again", "here is the dummy body"));
        posts.add(new Post("yet another post", "more dummy text"));

        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post = new Post("test post", "this is my first test blog post");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showPostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "create a new post";
    }
}
