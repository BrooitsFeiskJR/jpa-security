package com.tontech.Spring.Security.JPA.repository;

import com.tontech.Spring.Security.JPA.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
