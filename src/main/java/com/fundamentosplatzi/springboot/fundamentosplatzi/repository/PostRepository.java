package com.fundamentosplatzi.springboot.fundamentosplatzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  
}
