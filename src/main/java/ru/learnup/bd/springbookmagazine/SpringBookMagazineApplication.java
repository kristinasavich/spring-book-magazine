package ru.learnup.bd.springbookmagazine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.repository.BookRepository;
import ru.learnup.bd.springbookmagazine.dao.service.AuthorService;
import ru.learnup.bd.springbookmagazine.dao.entity.Author;
import ru.learnup.bd.springbookmagazine.dao.repository.AuthorRepository;
import ru.learnup.bd.springbookmagazine.dao.service.BookService;

@SpringBootApplication
public class SpringBookMagazineApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBookMagazineApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookMagazineApplication.class, args);

        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
//        log.info("Author1: {}", authorRepository.findAuthorByFullName("Пушкин"));
//        log.info("Author2: {}", authorRepository.findAllByFullNameContains("у"));
        AuthorService authorService = context.getBean(AuthorService.class);

//        for (Author author : authorService.getAuthors()) {
//            log.info("Authors: {}", author);
//        }

//        log.info("Create Author - {}", authorService.createAuthor(new Author("Онегин")));
        Author pushkin = new Author();
        pushkin.setFullName("Пушкин");
        authorService.createAuthor(pushkin);
        Book book = new Book();
        book.setAuthor(pushkin);
        book.setName("Руслан и Людмила");
        book.setSum(580L);
        book.setNumbPages(180L);
        book.setYearPublishing(1830L);
        BookService bookService = context.getBean(BookService.class);
        log.info("Book create: {}", bookService.createBook(book));
        //получение всех книг одного автора
        BookRepository bookRepository = context.getBean(BookRepository.class);
        log.info("All books {}", bookRepository.findAllByAuthor(pushkin));
    }

}
