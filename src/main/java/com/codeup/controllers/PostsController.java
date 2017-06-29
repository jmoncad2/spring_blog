package com.codeup.controllers;


import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    private final PostSvc postDao;
    private final UsersRepository usersDao;

    @Autowired
    public PostsController(PostSvc postDao, UsersRepository usersDao){
        this.usersDao = usersDao;
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
    public String savePost
            (@RequestParam(name = "title") String title,
             @RequestParam(name = "body") String body,
             Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = new Post();
        post.setOwner(user);
        post.setTitle(title);
        post.setBody(body);
        model.addAttribute("post", post);
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePosts(@RequestParam(name = "id") String id , Model model) {
        postDao.deletePost(Long.parseLong(id));
        model.addAttribute("msg", "your post was deleted correctly");
        return "redirect:/posts";
    }
}
