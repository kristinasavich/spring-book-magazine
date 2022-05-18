package ru.learnup.bd.springbookmagazine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.bd.springbookmagazine.dao.entity.Author;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.entity.Library;
import ru.learnup.bd.springbookmagazine.dao.entity.Product;
import ru.learnup.bd.springbookmagazine.dao.repository.AuthorRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.BookRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.LibraryRepository;
import ru.learnup.bd.springbookmagazine.dao.service.AuthorService;
import ru.learnup.bd.springbookmagazine.dao.service.BookService;
import ru.learnup.bd.springbookmagazine.dao.service.LibraryService;
import ru.learnup.bd.springbookmagazine.dao.service.ProductService;

@Slf4j
@SpringBootApplication
public class SpringBookMagazineApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookMagazineApplication.class, args);

        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
//        log.info("Author1: {}", authorRepository.findAuthorByFullName("Пушкин"));
//        log.info("Author2: {}", authorRepository.findAllByFullNameContains("у"));
        AuthorService authorService = context.getBean(AuthorService.class);

//        for (Author author : authorService.getAuthors()) {
//            log.info("Authors: {}", author);
//        }

//        log.info("Create Author - {}", authorService.createAuthor(new Author("Онегин")));
//        Author pushkin = new Author();
//        pushkin.setFullName("Александр Сергеевич Пушкин");
//        //если автор уже существует, то вернётся актуальный id
//        Author b = authorService.createAuthor(pushkin);
//
//
//        Book book = new Book();
//        book.setAuthor(b);
//        book.setName("Руслан и Людмила");
//        book.setSum(700L);
//        book.setNumbPages(130L);
//        book.setYearPublishing(1836L);
//        book.setImageUrl("https://cv8.litres.ru/pub/c/audiokniga/cover_max1500/43672989-aleksandr-pushkin-ruslan-i-ludmila-43672989.jpg");
//        BookService bookService = context.getBean(BookService.class);
//        bookService.createBook(book);
//        BookRepository bookRepository = context.getBean(BookRepository.class);
//        LibraryService libraryService = context.getBean(LibraryService.class);
//        Library f = new Library();
//        f.setLostBook(15L);
//        f.setBook(bookRepository.getById(1L));
//        libraryService.addBookInLibrary(f);
    }
}
