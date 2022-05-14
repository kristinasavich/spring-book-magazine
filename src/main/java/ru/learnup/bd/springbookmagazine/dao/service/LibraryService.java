package ru.learnup.bd.springbookmagazine.dao.service;

import ru.learnup.bd.springbookmagazine.dao.entity.Library;
import ru.learnup.bd.springbookmagazine.dao.repository.LibraryRepository;

import java.util.List;

public class LibraryService {

    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getLibraryAll(){
        return libraryRepository.findAll();
    }

    public Library createLibrary(Library library){
        return libraryRepository.save(library);
    }

    public Library getLibraryById(Long id){
        return libraryRepository.getById(id);
    }
}
