package com.cybr406.dbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class PostController
{
    @Autowired
    PostRepository postRepository;

    @PostMapping("/posts")
    public ResponseEntity<Post> demo(@RequestBody Post post)
    {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public Page<Post> getPosts(Pageable pageable)
    {
       return postRepository.findAll(pageable);
    }


}
