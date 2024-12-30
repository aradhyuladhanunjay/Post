package com.post.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String name;

    private String description;

    private String content;


}
