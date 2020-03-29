package com.example.demo.controller.api;

import com.example.demo.service.posts.PostsService;
import com.example.demo.service.posts.form.PostsSaveForm;
import com.example.demo.service.posts.vo.PostsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Api.API_V1_URI)
@Slf4j
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/posts/{id}")
    public PostsVo findById(@PathVariable Long id) {
        return PostsVo.build(postsService.getById(id));
    }

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveForm form) {
        return postsService.save(form);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveForm form) {
        return postsService.update(id, form);
    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
