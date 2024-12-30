package com.post.Service;

import com.post.DTO.PostDTO;

public interface PostService {

    public PostDTO savepost(PostDTO postDTO);

    public PostDTO getpostdetailsbyid(String id);
}
