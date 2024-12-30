package com.post.Controller;

import com.post.DTO.PostDTO;
import com.post.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Api/v1/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8080/Api/v1/post/savepost
    @PostMapping("/savepost")
    public ResponseEntity<PostDTO> savepost(@RequestBody PostDTO postDTO){
        PostDTO savepost = postService.savepost(postDTO);
        return new ResponseEntity<>(savepost, HttpStatus.CREATED);
    }

    //http://localhost:8080/Api/v1/post/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getpostdetailsbyid(@PathVariable("id") String postid){
        PostDTO getpostdetailsbyid = postService.getpostdetailsbyid(postid);
        return new ResponseEntity<>(getpostdetailsbyid, HttpStatus.OK);
    }


}
