package com.dda.testbookservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.dda.bookservice.entity.BookEntity;
import com.dda.bookservice.repository.BookServiceRepository;
import com.dda.bookservice.service.BookService;

@SpringBootTest(classes = BookService.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryTests {
	
	@Autowired
    private BookServiceRepository bookRepository;

    // JUnit test for saveEmployee

    
    @Test
    @Order(1)
    public void getEmployeeTest(){

        BookEntity employee = bookRepository.findById(1L).get();

        Assertions.assertTrue(employee.getBookId() > 0);

    }
    
    @Test
    @Order(2)
    public void getListOfEmployeesTest(){

        List<BookEntity> employees = bookRepository.findAll();

        assertThat(employees.size()).isGreaterThan(0);

    }


}
