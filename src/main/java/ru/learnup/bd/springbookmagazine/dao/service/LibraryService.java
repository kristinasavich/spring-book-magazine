package ru.learnup.bd.springbookmagazine.dao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.learnup.bd.springbookmagazine.dao.entity.Library;
import ru.learnup.bd.springbookmagazine.dao.repository.LibraryRepository;

import java.util.List;

@Slf4j
@Service
public class LibraryService {

    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getLibraryAll(){
        return libraryRepository.findAll();
    }

    @Cacheable(value = "library")
    public Library addBookInLibrary(Library library){
        log.info("add library: {}");
        return libraryRepository.save(library);
    }

    public Library getBookInLibraryById(Long id){
        return libraryRepository.getById(id);
    }

    @CacheEvict(value = "library")
    public void deleteBookIdLibrary(Long id){
        log.info("delete book in library");
        libraryRepository.delete(libraryRepository.getById(id));
    }

    @CachePut(value = "library", key = "#library.lost_book")
    public Library update(Library library){
        return libraryRepository.save(library);
    }
}
