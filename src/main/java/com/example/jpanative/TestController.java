package com.example.jpanative;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController implements InitializingBean {
    private final TestEntityRepository repository;

    public TestController(TestEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    @Transactional(readOnly = true)
    public List<String> names() {
        return repository.findAllByOrderByName().map(TestEntity::getName).toList();
    }

    @Override
    @Transactional
    public void afterPropertiesSet() throws Exception {
        repository.save(new TestEntity("Test"));
    }
}
