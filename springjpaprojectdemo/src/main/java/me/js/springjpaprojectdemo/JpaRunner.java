package me.js.springjpaprojectdemo;

import javafx.geometry.Pos;
import org.hibernate.Session;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

/*
    @PersistenceContext
    EntityManager entityManager;
*/

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        postRepository.findAll().forEach(System.out::println);

  /*      TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);

        List<Post> postList =query.getResultList();
        postList.forEach(System.out::println);
*/
      /*  Account account = new Account();
        account.setUsername("jongseon3");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring JPA");

        account.addStudy(study);
*/
/*
        Post post = new Post();
        post.setTitle("Spring data jpa 언제");

        Comment comment = new Comment();
        comment.setComment("AB");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("CD");
        post.addComment(comment1);
*/

/*        Session session = entityManager.unwrap(Session.class);
      //  session.save(post);

        Post post = session.get(Post.class, 1l);
        System.out.println(">>>>>>>>>>>>>");
        System.out.println(post.getTitle());

        post.getComments().forEach(c -> {
            System.out.println("-----");
            System.out.println(c.getComment());
        });*/
      /*  session.save(account);
        session.save(study);

        Account js = session.load(Account.class, account.getId());
        js.setUsername("jongseon1");

        System.out.println(">>>>>>>>" + js.getUsername());*/
    }
}
