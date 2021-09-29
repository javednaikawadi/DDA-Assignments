package com.dda.bookservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dda.bookservice.entity.BookEntity;
import com.dda.bookservice.exception.RecordNotFoundException;
import com.dda.bookservice.service.BookService;
 
@RestController 
@RefreshScope
@RequestMapping("/bookmaster")
public class BookServiceController 
{
    @Value("${fiction.discount}")
    private int fictiondiscount;

    @Value("${comic.discount}")
    private int comicdiscount;
    
	private static final Logger log = LogManager.getLogger(BookServiceController.class);

    @Autowired
    BookService service;
 
    //READ ALL
    @RequestMapping(method = RequestMethod.GET,value ="/getbookslist",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookEntity>> getAllBooks() {
    	log.debug("In getBookList");
        List<BookEntity> list = service.getAllBooks();
        log.debug("Exit from getBookList");
        return new ResponseEntity<List<BookEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    //READ BY ID
    @RequestMapping(method = RequestMethod.GET,value = "/getbookbyid/{bookid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookEntity> getBookById(@PathVariable("bookid") Long id) throws RecordNotFoundException {
        BookEntity entity = service.getBookByBookId(id);
        return new ResponseEntity<BookEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    //INSERT/UPDATE
    @RequestMapping(method = RequestMethod.POST,value = "/addbook",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody BookEntity book) throws RecordNotFoundException{
        // make sure to check whether the new person does not already exist
        BookEntity updated = service.createOrUpdateBookDetails(book);
        //return ResponseEntity.ok(personService.save(person));
        return new ResponseEntity<BookEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    //DELETE BY ID
    @DeleteMapping("/deletebookbyid/{bookid}")
    public HttpStatus deleteBookById(@PathVariable("bookid") Long id) throws RecordNotFoundException {
        service.deleteBookById(id);
        return HttpStatus.OK;
    }
    
    //DELETE ALL
    @DeleteMapping("/deletebooks")
    public HttpStatus deleteBooks() throws RecordNotFoundException {
        service.deleteBooks();
        return HttpStatus.OK;
    }
    
    //Checkout API
    @RequestMapping(method = RequestMethod.POST,value ="/checkout/{noofbooks}/{promocode}/{promoamount}/{totalamount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Long checkout(@PathVariable("noofbooks") Long noofbooks,@PathVariable("promocode") String promocode,
    		                   @PathVariable("promoamount") Long promoamount,@PathVariable("totalamount") Long totalamount) throws RecordNotFoundException {
        log.debug("fictionDiscount="+fictiondiscount);
        log.debug("comicDiscount="+comicdiscount);
    	Long finalamount;
    	if(promocode.equals("fic"))
    		promoamount = promoamount *fictiondiscount/100;
    	else
    		promoamount = promoamount *comicdiscount/100;
    	
    	finalamount = totalamount - promoamount;
    	
        return finalamount;
    }
 
}