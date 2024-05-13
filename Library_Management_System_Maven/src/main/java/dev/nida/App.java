package dev.nida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();


//        // Author Adding
//        Author author = new Author();
//        author.setName("Cal Newport");
//        author.setBirthDate(LocalDate.of(1982, 6, 23));
//        author.setCountry("USA");
//        entityManager.persist(author);
//
//        // Publisher Adding
//        Publisher publisher = new Publisher();
//        publisher.setName("Grand Central Publishing");
//        publisher.setAddress("USA");
//        publisher.setEstablishmentYear(LocalDate.of(2016,1, 5));
//        entityManager.persist(publisher);
//
//        // Book Adding
//        Book book = new Book();
//        book.setName("Deep Work: Rules for Focused Success in a Distracted World");
//        book.setAuthor(author);
//        book.setPublisher(publisher);
//        book.setStock(25);
//        book.setPublicationYear(LocalDate.of(2016, 1,5));
//        entityManager.persist(book);
//
//        // Category Adding
//        Category categoryFiction = new Category();
//        categoryFiction.setName("Self-Help");
//        categoryFiction.setDescription("One of the most valuable skills in our economy is becoming increasingly rare." +
//                "If you master this skill, you'll achieve extraordinary results." +
//                "Deep Work is an indispensable guide to anyone seeking focused success in a distracted world.");
//
//        List<Book> bookList = new ArrayList<>();
//        bookList.add(book);
//        categoryFiction.setBookList(bookList);
//        entityManager.persist(categoryFiction);
//
//        // BookBorrowing Adding
//        BookBorrowing borrowing = new BookBorrowing();
//        borrowing.setBorrowerName("Nida");
//        borrowing.setBorrowingDate(LocalDate.of(2024, 5, 1));
//        borrowing.setReturnDate(LocalDate.of(2024, 5, 7));
//        borrowing.setBook(book);
//        entityManager.persist(borrowing);
//
//        Category category = new Category();
//        category.setName("Self-Help");
//        category.setDescription("The self-help book genre contains nonfiction books written with the intention of instructing the reader on how to solve a problem or improve an area of their life or providing other guidance.");
//        entityManager.persist(category);
//
//        Book book2 = entityManager.find(Book.class,1);
//        List<Category>categoryList=new ArrayList<>();
//        categoryList.add(category);
//        book2.setCategoryList(categoryList);

        transaction.commit();

    }
}