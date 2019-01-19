package me.js.demojpa3.post;

import javax.persistence.Entity;
import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete(Post entity);

}
