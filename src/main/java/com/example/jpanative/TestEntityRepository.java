package com.example.jpanative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
    Stream<TestEntity> findAllByOrderByName();
}
