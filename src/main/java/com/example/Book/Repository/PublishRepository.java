package com.example.Book.Repository;

import com.example.Book.Entity.Publish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublishRepository extends JpaRepository<Publish,Integer> {

}
