package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author maciek = new Author("Maciek", "");
        Book book1 = new Book("Book Title 1", "12341243");

        maciek.getBooks().add(book1);
        book1.getAuthors().add(maciek);

        authorRepository.save(maciek);
        bookRepository.save(book1);

        Author romek = new Author("Romek", "");
        Book book2 = new Book("Book title 2", "234234");

        romek.getBooks().add(book2);
        book2.getAuthors().add(romek);

        authorRepository.save(romek);
        bookRepository.save(book2);

        System.out.println("Started in bootstarp");
        System.out.println("Number of books in repo: " + bookRepository.count());



    }
}
