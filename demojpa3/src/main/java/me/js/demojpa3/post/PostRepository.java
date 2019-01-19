package me.js.demojpa3.post;

import me.js.demojpa3.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository<Post>, QuerydslPredicateExecutor<Post> {

}
