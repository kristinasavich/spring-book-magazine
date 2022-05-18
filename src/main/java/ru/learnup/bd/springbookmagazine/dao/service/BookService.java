package ru.learnup.bd.springbookmagazine.dao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.repository.BookRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.LibraryRepository;

import java.util.List;

@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Cacheable(value = "books", key = "#book.name")
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }


    @CacheEvict(value = "books")
    public void deleteBookById(Long id) {
        log.info("delete book: {}", bookRepository.getById(id));
        bookRepository.delete(bookRepository.getById(id));
    }


    @CachePut(value = "book", key = "#book")
    public Book update(Book book){
        return bookRepository.save(book);
    }
}
