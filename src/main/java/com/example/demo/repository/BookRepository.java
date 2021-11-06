package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookData;

@Repository
public interface BookRepository extends JpaRepository<BookData, Integer>  {

}
