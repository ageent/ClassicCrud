package ru.mycompany.classiccrud.repostory;

import org.springframework.data.repository.CrudRepository;
import ru.mycompany.classiccrud.domain.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();
}
