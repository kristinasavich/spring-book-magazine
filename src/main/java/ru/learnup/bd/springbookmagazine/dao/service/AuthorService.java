package ru.learnup.bd.springbookmagazine.dao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.learnup.bd.springbookmagazine.dao.entity.Author;
import ru.learnup.bd.springbookmagazine.dao.repository.AuthorRepository;

import java.util.List;

@Slf4j
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Cacheable(value = "author", key = "#author.fullName")
    public Author createAuthor(Author author){
        log.info("create author: {}", author);
        return authorRepository.save(author);

    }

    @Cacheable(value = "author")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorByName(String name){
        return authorRepository.findAuthorByFullName(name);
    }

    public Author getAuthorById(Long id){
        return authorRepository.getById(id);
    }

}
