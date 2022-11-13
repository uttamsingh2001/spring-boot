package com.employeejpa.employeejpa.controller;


import com.employeejpa.employeejpa.model.EmployeeRequest;
import com.employeejpa.employeejpa.model.Post;
import com.employeejpa.employeejpa.model.PostResponse;
import com.employeejpa.employeejpa.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class PostController {


    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping (path = "/posts",produces=MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<PostResponse> createPost(@RequestBody Post post){

        PostResponse postResponse=postService.createPost(post);


        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);


    }

    @GetMapping(value = "/posts",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse[]>  getAllPosts()
    {
        PostResponse[] postResponses = postService.getAllPosts();
        return new ResponseEntity<>(postResponses,HttpStatus.OK);
    }


    @GetMapping(value = "/posts/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse>getPost(@PathVariable Long id){
        PostResponse postResponse =postService.getPost(id);
        return ResponseEntity.ok(postResponse);
    }


    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<Void> deletePosts(@PathVariable Long id) {

        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long id, @RequestBody PostResponse bookResponse) {
        PostResponse postResponse = postService.updatePost(id, bookResponse);
        log.info("employee update successfully.......");
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }



}
