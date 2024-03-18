package com.luis.biscoin.controller;

import com.luis.biscoin.model.Post;
import com.luis.biscoin.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/post")
public class PostController {


    @Autowired
    PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> listAllPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listALlPosts());
    }
    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(post));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> findPostById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findPostById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePostById(@PathVariable long id){
        service.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
