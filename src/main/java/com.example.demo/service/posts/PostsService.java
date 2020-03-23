package com.example.demo.service.posts;

import com.example.demo.domain.posts.PostsProvider;
import com.example.demo.domain.posts.entity.Posts;
import com.example.demo.service.posts.form.PostsSaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PostsService {

    private final PostsProvider postsProvider;

    public Posts getById(Long id) {
        return postsProvider.getById(id);
    }

    @Transactional
    public Long save(PostsSaveForm form) {
        return postsProvider.save(form.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveForm form) {
        Posts posts = postsProvider.getById(id);
        return posts.update(form);
    }
}