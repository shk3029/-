package me.js.demojpa3.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository<Post> {

    @Autowired
    EntityManager entityManager;

    @Override
    public void delete(Post entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }

    @Override
    public List<Post> findMyPost() {
        return entityManager.createQuery("SELECT p FROM Post AS p", Post.class)
                .getResultList();

    }
}
