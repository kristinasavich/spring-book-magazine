package ru.learnup.bd.springbookmagazine.dao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.learnup.bd.springbookmagazine.dao.controller.filter.BookFilter;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.repository.BookRepository;

import java.util.List;

import static ru.learnup.bd.springbookmagazine.dao.controller.filter.BookSpecification.byFilter;

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
        log.info("create book: {}", book);

        return bookRepository.save(book);
    }

    public List<Book> getBooksBy(BookFilter filter){
        Specification<Book> specification = Specification.where(byFilter(filter));
        return bookRepository.findAll(specification);
    }

    public Book getBookById(Long id){
        return bookRepository.getById(id);
    }


    @CacheEvict(value = "books")
    public Boolean deleteBookById(Long id) {
        log.info("delete book: {}", bookRepository.getById(id));
        bookRepository.delete(bookRepository.getById(id));
        return true;
    }


    @CachePut(value = "book", key = "#book")
    public Book update(Book book){
        return bookRepository.save(book);
    }
}
