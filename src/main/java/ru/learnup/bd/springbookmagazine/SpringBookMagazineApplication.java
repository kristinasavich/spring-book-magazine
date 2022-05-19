package ru.learnup.bd.springbookmagazine;

import com.google.gson.Gson;
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

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringBookMagazineApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookMagazineApplication.class, args);

        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
//        log.info("Author1: {}", authorRepository.findAuthorByFullName("??????"));
//        log.info("Author2: {}", authorRepository.findAllByFullNameContains("?"));
        AuthorService authorService = context.getBean(AuthorService.class);

//        for (Author author : authorService.getAuthors()) {
//            log.info("Authors: {}", author);
//        }

//        log.info("Create Author - {}", authorService.createAuthor(new Author("??????")));
        Author pushkin = new Author();
//        pushkin.setFullName("Aleksandr Sergeyevich Pushkin");
        //???? ????? ??? ??????????, ?? ???????? ?????????? id
        Author b = authorService.createAuthor(pushkin);
//
//
        Book book = new Book();
        book.setAuthor(b);
        book.setName("??????????");
        book.setSum(350L);
        book.setNumbPages(130L);
        book.setYearPublishing(1836L);
        book.setImageUrl("https://s1.livelib.ru/boocover/1000431488/200/d378/boocover.jpg");
        BookService bookService = context.getBean(BookService.class);
//        bookService.createBook(book);
        BookRepository bookRepository = context.getBean(BookRepository.class);
//        List<Book> books1 = bookService.getBooks();
//        List<Book> books = bookRepository.findAll();

//        LibraryService libraryService = context.getBean(LibraryService.class);
//        Library f = new Library();
//        f.setLostBook(15L);
//        f.setBook(bookRepository.getById(1L));
//        libraryService.addBookInLibrary(f);

        Gson gson = new Gson();
        Book book1 = Book.builder()
                .name("Pikovaya dama")
                .author(b)
                .sum(300L)
                .numbPages(140L)
                .imageUrl("https://upload.wikimedia.org/wikipedia/ru/c/cd/??????_?_??????_«???????_????»_%281916%29.jpg")
                .build();
//        bookService.createBook(book1);
        String json = gson.toJson(book1);
        log.info("{}", json);
        Book serial = gson.fromJson(json, Book.class);
        log.info("{}", serial);

    }
}
