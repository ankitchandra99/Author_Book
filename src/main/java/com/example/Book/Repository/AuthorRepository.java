package com.example.Book.Repository;

import com.example.Book.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository  extends JpaRepository<Author,Integer> {
    @Query("SELECT COUNT(p) FROM Publish p WHERE p.author = :author AND p.yearOfPublication = :year")

   // @Query("SELECT a.name, a.age FROM Author a WHERE a.authorId = (SELECT b.author.authorId FROM Book b GROUP BY b.author.authorId ORDER BY SUM(b.pages) DESC LIMIT 1)")
    //List<Object[]> findAuthorsWithMaxPagesWritten();
    Integer countByBooksAuthorAndYearOfPublication(@Param("author") Author author, @Param("year") Integer year);


}
