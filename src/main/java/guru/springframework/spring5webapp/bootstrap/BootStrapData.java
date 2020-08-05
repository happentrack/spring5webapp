package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domiain.Author;
import guru.springframework.spring5webapp.domiain.Book;
import guru.springframework.spring5webapp.domiain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        TestBookAndAuthor();
        TestPublisher();

    }

    private void TestBookAndAuthor() {
        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");


        Publisher publisher = new Publisher("SFG Publishing");
        publisher.setAddressLine1("123 Main Street");
        publisher.setCity("San Diego");
        publisher.setZip("92127");
        publisher.setCountry("USA");
        publisherRepository.save(publisher);
        System.out.println("Number of publisher = " + publisherRepository.count());


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        System.out.println("Number of Books   = " + bookRepository.count());
        System.out.println("Number of Authors = " + authorRepository.count());

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        publisherRepository.save(publisher);

        System.out.println("Number of publisher = " + publisherRepository.count());

        Author rod = new Author("Rob", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books   = " + bookRepository.count());
        System.out.println("Number of Authors = " + authorRepository.count());
        System.out.println("Number of publisher = " + publisherRepository.count());
    }

    private void TestPublisher(){
        Publisher publisher = new Publisher("Publisher One");
        publisherRepository.save(publisher);

        System.out.println("Number of publisher = " + publisherRepository.count());
    }
}

        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        publisherRepository.save(publisher);
        bookRepository.save(noEJB);

        System.out.println("Number of Books   = " + bookRepository.count());
        System.out.println("Number of Authors = " + authorRepository.count());
        System.out.println("Number of publisher = " + publisherRepository.count());
    }

    private void TestPublisher(){
        Publisher publisher = new Publisher("Publisher One");
        publisherRepository.save(publisher);

        System.out.println("Number of publisher = " + publisherRepository.count());
    }
}
