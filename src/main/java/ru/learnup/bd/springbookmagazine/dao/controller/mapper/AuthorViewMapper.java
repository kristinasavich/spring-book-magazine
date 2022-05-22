package ru.learnup.bd.springbookmagazine.dao.controller.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.bd.springbookmagazine.dao.controller.view.AuthorView;
import ru.learnup.bd.springbookmagazine.dao.entity.Author;

@Component
public class AuthorViewMapper {

    public AuthorView mapToView(Author author){
        AuthorView authorView = new AuthorView();
        authorView.setBook(author.getBook());
        authorView.setId(author.getId());
        authorView.setFullName(author.getFullName());
        return authorView;
    }

    public Author mapFromView(AuthorView authorView){
        Author author = new Author();
        author.setFullName(author.getFullName());
        author.setBook(author.getBook());
        author.setFullName(author.getFullName());
        return author;
    }
}
