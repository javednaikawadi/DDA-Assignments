package com.dda.bookservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dda.bookservice.entity.BookEntity;
import com.dda.bookservice.exception.RecordNotFoundException;
import com.dda.bookservice.repository.BookServiceRepository;

 
@Service
public class BookService {
	
	private static final Logger log = LogManager.getLogger(BookService.class);
     
    @Autowired
    BookServiceRepository repository;
     
    public List<BookEntity> getAllBooks()
    {
        List<BookEntity> bookList = repository.findAll();
         
        if(bookList.size() > 0) {
            return bookList;
        } else {
            return new ArrayList<BookEntity>();
        }
    }
     
    public BookEntity getBookByBookId(Long id) throws RecordNotFoundException 
    {
        Optional<BookEntity> book = repository.findById(id);
         
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new RecordNotFoundException("No book record exist for given book id");
        }
    }
     
    public BookEntity createOrUpdateBookDetails(BookEntity entity) throws RecordNotFoundException 
    {
    	//log.debug("In entity="+entity.getBookId());
        Optional<BookEntity> book = repository.findById(entity.getBookId());
         
        if(book.isPresent()){
            BookEntity newItemEntity = book.get();
            newItemEntity.setBookId(entity.getBookId());
            newItemEntity.setBookName(entity.getBookName());
            newItemEntity.setBookDesc(entity.getBookDesc());
            newItemEntity.setBookType(entity.getBookType());
            newItemEntity.setBookAuthor(entity.getBookAuthor());
            newItemEntity.setBookPrice(entity.getBookPrice());
            newItemEntity.setISBN(entity.getISBN());
 
            newItemEntity = repository.save(newItemEntity);
            return newItemEntity;
        } 
        else{
            entity = repository.save(entity);
            return entity;
        }
    } 
     
    public void deleteBookById(Long id) throws RecordNotFoundException 
    {
        Optional<BookEntity> book = repository.findById(id);
         
        if(book.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No book record exist for given bookid");
        }
    } 
    
    public void deleteBooks()
    {
        List<BookEntity> books = repository.findAll();
        
        for (BookEntity book : books) {
        	repository.deleteById(book.getBookId());
        }
    } 
}