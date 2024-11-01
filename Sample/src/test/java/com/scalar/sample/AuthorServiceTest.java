package com.scalar.sample;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Rollback
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @BeforeEach
    public void setup(){
        authorService.deleteAll();
    }

    @Test
    public void testCreateAndFindAuthor(){
        Author author = new Author("J.K. Rowling");
        authorService.saveAuthor(author);

        List<Author> authors = authorService.findAllAuthors();
        assertEquals(1, authors.size());
        assertEquals("J.K. Rowling", authors.get(0).getName());
    }

    @Test
    public void testAuthorAndPaging(){
        authorService.saveAuthor(new Author("Author 1"));
        authorService.saveAuthor(new Author("Author 2"));
        authorService.saveAuthor(new Author("Author 3"));

        Pageable pageable = PageRequest.of(0,2);
        Page<Author> page = authorService.findAllAuthors(pageable);

        assertEquals(2, page.getSize());
        assertEquals(3, page.getTotalElements());

    }

}
