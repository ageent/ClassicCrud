package ru.mycompany.classiccrud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mycompany.classiccrud.domain.Book;
import ru.mycompany.classiccrud.repostory.BookRepository;

import java.util.List;

@Controller
public class PersonController {

    private final BookRepository repository;

    @Autowired
    public PersonController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = repository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        Book book = repository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveBook(@RequestParam("name") String name) {
        Book book = new Book(name);
        repository.save(book);
        return "list";
    }
}
