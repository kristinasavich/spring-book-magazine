package ru.learnup.bd.springbookmagazine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.bd.springbookmagazine.dao.*;

@SpringBootApplication
public class SpringBookMagazineApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBookMagazineApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookMagazineApplication.class, args);

//        BooksMagazineDao bookMagDao = context.getBean(BooksMagazineDao.class);
//		Author author = context.getBean(Author.class);
//		author.setName("Пушкин");

//		bookMagDao.addBook(new Book(new Author("Александр", "Блок"), "Незнакомка", 3));
//		bookMagDao.showBookName();
//		log.info("{}", bookMagDao.findByNameBook("Александр Блок"));
//        OrderDao orderDao = context.getBean(OrderDao.class);
//        orderDao.getOrder(1);
    }

}
