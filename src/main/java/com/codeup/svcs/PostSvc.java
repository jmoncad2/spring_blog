package com.codeup.svcs;


import com.codeup.models.Post;
import com.codeup.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PostSvc")
public class PostSvc {
    private final PostRepository postDao;

    @Autowired
    public PostSvc(PostRepository postDao) {
        this.postDao = postDao;
    }

    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public Post save(Post post) {
        return postDao.save(post);
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }
}
