package ru.learnup.bd.springbookmagazine.dao.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.learnup.bd.springbookmagazine.dao.controller.mapper.AuthorViewMapper;
import ru.learnup.bd.springbookmagazine.dao.controller.view.AuthorView;
import ru.learnup.bd.springbookmagazine.dao.entity.Author;
import ru.learnup.bd.springbookmagazine.dao.repository.AuthorRepository;
import ru.learnup.bd.springbookmagazine.dao.service.AuthorService;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("(/api/v1/author)")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorViewMapper authorViewMapper;
    private final AuthorService authorService;

    public AuthorController(AuthorRepository authorRepository, AuthorViewMapper authorViewMapper, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorViewMapper = authorViewMapper;
        this.authorService = authorService;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public List<AuthorView> getAuthor(){
        return authorRepository.findAll().stream()
                .map(authorViewMapper::mapToView)
                .collect(Collectors.toList());
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public AuthorView createBook(@RequestBody AuthorView body) {
        if (body.getId() != 0) {
            throw new EntityExistsException("Author exists!");
        }
        Author author = authorViewMapper.mapFromView(body);
        Author serviceAuthor = authorService.createAuthor(author);
        return authorViewMapper.mapToView(serviceAuthor);
    }
}
