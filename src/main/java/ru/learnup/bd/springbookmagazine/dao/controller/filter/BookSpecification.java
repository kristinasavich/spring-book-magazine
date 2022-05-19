package ru.learnup.bd.springbookmagazine.dao.controller.filter;

import org.springframework.data.jpa.domain.Specification;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;

import javax.persistence.criteria.Predicate;

public class BookSpecification {

    public static Specification<Book> byFilter(BookFilter filter) {

        return (root, q, cb) -> {

            Predicate predicate = cb.isNotNull(root.get("id"));


            if (filter.getName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("text"), "%" + filter.getName() + "%"));
            }

            if (filter.getAuthor() != null) {
                predicate = cb.and(cb.like(root.get("title"), "%" + filter.getAuthor() + "%"));
            }

            return predicate;
        };
    }
}
