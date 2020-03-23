package com.example.demo.domain.posts.entity;

import com.example.demo.domain.BaseEntity;
import com.example.demo.service.posts.form.PostsSaveForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Long update(PostsSaveForm form) {
        this.title = form.getTitle();
        this.content = form.getContent();
        this.author = form.getAuthor();
        return this.id;
    }
}
