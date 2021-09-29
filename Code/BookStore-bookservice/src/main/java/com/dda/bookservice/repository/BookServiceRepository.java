package com.dda.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dda.bookservice.entity.BookEntity;
 
@Repository
public interface BookServiceRepository 
        extends JpaRepository<BookEntity, Long> {
 }