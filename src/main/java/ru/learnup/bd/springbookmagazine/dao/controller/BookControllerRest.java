package ru.learnup.bd.springbookmagazine.dao.controller;

import org.springframework.web.bind.annotation.*;
import ru.learnup.bd.springbookmagazine.BookViewMapper;
import ru.learnup.bd.springbookmagazine.dao.controller.filter.BookFilter;
import ru.learnup.bd.springbookmagazine.dao.controller.view.BookView;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.service.BookService;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/book")

public class BookControllerRest {
    private final BookService bookService;
    private final BookViewMapper mapper;

    public BookControllerRest(BookService bookService, BookViewMapper mapper){
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<BookView> getBooks(
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "name", required = false) String name
    ){
        return bookService.getBooksBy(new BookFilter(author, name))
                .stream()
                .map(mapper::mapToView)
                .collect(Collectors.toList());
    }


    @GetMapping("/{postId}")
    public BookView getBook(@PathVariable("postId") Long bookId){
        return mapper.mapToView(bookService.getBookById(bookId));
    }

    @PostMapping
    public BookView createBook(@RequestBody BookView body){
        if(body.getId() != null){
            throw new EntityExistsException("Book exists!");
        }
        Book book = mapper.mapFromView(body);
        Book serviceBook = bookService.createBook(book);
        return mapper.mapToView(serviceBook);
    }

    @DeleteMapping("/{bookId}")
    public Boolean deleteBook(@PathVariable("bookId") Long bookId) {
        return bookService.deleteBookById(bookId);
    }
}
