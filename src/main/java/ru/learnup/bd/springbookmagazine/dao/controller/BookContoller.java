package ru.learnup.bd.springbookmagazine.dao.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.service.BookService;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/books")
public class BookContoller {

    private final BookService bookService;


    public BookContoller(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping("/home")
//    public String home(Model model){
//        return "books";
//    }

//    @GetMapping("/catalog")
//    public String shop(Model model){
//            model.addAttribute("books", bookService.getBooks());
//        return "books";
//    }

//    @GetMapping("/home")
//    public String home(Model model) {
//        return "books";
//    }
//

    @GetMapping("/home")
    public String shop(Model model) {
//        Book book = Book.builder()
//                .name("Пиковая дама")
//                .sum(300L)
//                .numbPages(140L)
//                .imageUrl("https://upload.wikimedia.org/wikipedia/ru/c/cd/Постер_к_фильму_«Пиковая_дама»_%281916%29.jpg")
//                .build();
        model.addAttribute(
                "books", bookService.getBooks());
        return "books";
    }

}
