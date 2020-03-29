package com.example.demo.service.posts.vo;

import com.example.demo.domain.posts.entity.Posts;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime modifiedAt;

    public static PostsVo build(Posts entity) {
        return new PostsVo()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setContent(entity.getContent())
                .setAuthor(Objects.nonNull(entity.getAuthor()) ? entity.getAuthor() : "")
                .setModifiedAt(entity.getModifiedAt());
    }

    public static List<PostsVo> build(List<Posts> entities) {
        return entities.stream()
                .filter(Objects::nonNull)
                .map(PostsVo::build)
                .collect(Collectors.toList());
    }
}
