package com.luis.biscoin.repository;

import com.luis.biscoin.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
