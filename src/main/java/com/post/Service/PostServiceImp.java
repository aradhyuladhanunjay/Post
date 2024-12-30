package com.post.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.post.DTO.PostDTO;
import com.post.Entity.Post;
import com.post.Exception.Resourcenotfound;
import com.post.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDTO getpostdetailsbyid(String id) {
        Post postbyid = postRepository.findById(id).orElseThrow(() -> new Resourcenotfound("this "+id+" not found in the records."));
        return entitytoDTO(postbyid);
    }

    @Override
    public PostDTO savepost(PostDTO postDTO) {

        Post post = DTOtoentity(postDTO);
        post.setId(UUID.randomUUID().toString());
        Post savedpost = postRepository.save(post);

        return entitytoDTO(savedpost);
    }



    public PostDTO entitytoDTO(Post post){
        PostDTO postDTO=new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setName(post.getName());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        return postDTO;
    }

    public Post DTOtoentity(PostDTO postDTO){
        Post post=new Post();
        post.setDescription(postDTO.getDescription());
//        post.setId(postDTO.getId());
        post.setName(postDTO.getName());
        post.setContent(postDTO.getContent());

        return post;
    }
}
