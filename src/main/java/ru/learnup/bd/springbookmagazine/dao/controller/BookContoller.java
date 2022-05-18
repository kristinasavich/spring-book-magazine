package ru.learnup.bd.springbookmagazine.dao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.learnup.bd.springbookmagazine.dao.service.BookService;

@Controller
@RequestMapping("/books")
public class BookContoller {

    private BookService bookService;

    public BookContoller(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String home(Model model){
        return "books";
    }

    @GetMapping("/catalog")
    public String shop(Model model){
        model.addAttribute("books", bookService.getBooks());
        return "books";
    }

//    @GetMapping("/home")
//    public String home(Model model) {
//        return "books";
//    }
//
//    @GetMapping("/catalog")
//    public String shop(Model model) {
//        Lala lala = Lala.builder()
//                .count(1L)
//                .description("Olol")
//                .name("Book")
//                .price(100L)
//                .imageUrl("https://cdn-icons-png.flaticon.com/512/4/4259.png")
//                .build();
//        model.addAttribute(
//                "lala",
//                List.of(lala, lala, lala, lala, lala, lala));
//        return "books";
//    }
}
