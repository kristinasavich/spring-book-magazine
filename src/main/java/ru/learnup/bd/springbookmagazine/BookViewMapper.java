package ru.learnup.bd.springbookmagazine;

import org.springframework.stereotype.Component;
import ru.learnup.bd.springbookmagazine.dao.controller.view.BookView;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.service.AuthorService;
import ru.learnup.bd.springbookmagazine.dao.service.BookService;

@Component

public class BookViewMapper {

    private final AuthorService authorService;
    private final BookService bookService;

    public BookViewMapper(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public BookView mapToView(Book book){
        BookView view = new BookView();
        view.setId(book.getId());
        view.setName(book.getName());
        view.setImageUrl(book.getImageUrl());
        view.setNumbPages(book.getNumbPages());
        view.setYearPublishing(book.getYearPublishing());
        view.setSum(book.getSum());
        view.setAuthor(book.getAuthor().getFullName());
        return view;
    }

    public Book mapFromView(BookView bookView){
        Book book = new Book();
        book.setId(bookView.getId());
        book.setName(bookView.getName());
        book.setImageUrl(bookView.getImageUrl());
        book.setNumbPages(bookView.getNumbPages());
        book.setYearPublishing(bookView.getYearPublishing());
        book.setSum(bookView.getSum());
        book.setAuthor(authorService.getAuthorByName(bookView.getAuthor()));

        return book;
    }
}
