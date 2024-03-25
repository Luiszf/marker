package com.luis.biscoin.service;

import com.luis.biscoin.model.Post;
import com.luis.biscoin.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post save(Post post){
        return repository.save(post);
    }

    public List<Post> listALlPosts() {
        return repository.findAll();
    }

    public void deletePost(long id){
        repository.deleteById(id);
    }

    public Optional<Post> findPostById(long id){
        return repository.findById(id);
    }

    public Post updatePost(Post post){
        return repository.save(post);
    }
}

