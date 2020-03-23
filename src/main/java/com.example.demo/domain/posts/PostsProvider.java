package com.example.demo.domain.posts;

import com.example.demo.domain.posts.entity.Posts;
import com.example.demo.domain.posts.repository.PostsRepository;
import com.example.demo.infrastructure.spring.annotation.Provider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Provider
@RequiredArgsConstructor
@Slf4j
public class PostsProvider {

    private PostsRepository postsRepository;

    public Optional<Posts> findById(Long id) {
        return postsRepository.findById(id);
    }

    public Posts getById(Long id) {
        return findById(id)
                .orElseThrow(() -> {
                    log.error("entity not found : posts=" + id);
                    return new IllegalArgumentException("해당 사용자가 없습니다. id=" + id);
                });
    }

    public Posts save(Posts posts) {
        return postsRepository.save(posts);
    }

}
