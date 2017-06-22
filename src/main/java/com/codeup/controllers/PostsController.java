package com.codeup.controllers;


import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    private final PostSvc postDao;

    @Autowired
    public PostsController(PostSvc postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {
        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable Long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPostF(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect/posts/" + post.getId();
    }

    @PostMapping("/post/i{id}/delete")
    public String deletePosts(@ModelAttribute Post post, Model model) {
        postDao.deletePost(post.getId());
        model.addAttribute("msg", "your post was deleted correctly");
        return "return view";
    }
}
