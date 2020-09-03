package ru.mycompany.classiccrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mycompany.classiccrud.domain.Book;
import ru.mycompany.classiccrud.repostory.BookRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    private final BookRepository repository;

    public Main(BookRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void init() {
        repository.save(new Book("Pushkin"));
        repository.save(new Book("Lermontov"));
    }

}
