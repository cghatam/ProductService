package com.scalar.sample;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Rollback
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @BeforeEach
    public void setUp(){
        bookRepository.deleteAll();
    }

    @Test

    public void testCreateAndFindBook(){
        Author author = new Author("George R.R. Martin");
        authorService.saveAuthor(author);
        Book book = new Book("A Game of Thrones", author);
        bookService.saveBook(book);

        Book retrivedBook = bookService.findAllBooks().get(0);
        assertEquals("A Game of Thrones", retrivedBook.getTitle());
        assertEquals("George R.R. Martin", retrivedBook.getAuthor().getName());
    }

}
