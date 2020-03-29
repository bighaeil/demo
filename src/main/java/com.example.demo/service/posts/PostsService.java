package com.example.demo.service.posts;

import com.example.demo.domain.posts.PostsProvider;
import com.example.demo.domain.posts.entity.Posts;
import com.example.demo.service.posts.form.PostsSaveForm;
import com.example.demo.service.posts.vo.PostsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class PostsService {

    private final PostsProvider postsProvider;

    public Page<PostsVo> search(Pageable pageable) {
        return postsProvider.search(pageable)
                .map(PostsVo::build);
    }

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

    @Transactional
    public void delete(Long id) {
        Posts posts = postsProvider.getById(id);
        postsProvider.delete(posts);
    }
}
