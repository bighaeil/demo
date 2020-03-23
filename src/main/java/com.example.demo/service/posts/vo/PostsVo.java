package com.example.demo.service.posts.vo;

import com.example.demo.domain.posts.entity.Posts;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class PostsVo {
    Long id;
    String title;
    String content;
    String author;

    public static PostsVo build(Posts entity) {
        return new PostsVo()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setContent(entity.getContent())
                .setAuthor(entity.getAuthor());
    }
}
