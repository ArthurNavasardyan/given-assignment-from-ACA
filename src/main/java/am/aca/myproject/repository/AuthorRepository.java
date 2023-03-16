package am.aca.myproject.repository;

import am.aca.myproject.entity.song.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findByAuthorName(String authorName);

    Optional<Author> findById(Long authorId);


    List<Author> findAll();


    Author save(Author author);


}
