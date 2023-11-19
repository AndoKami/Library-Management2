import Configuration.DbConfiguration;
import Model.Author;
import Model.Book;
import Model.Subscriber;
import Repository.Operations.AuthorCrudOperations;
import Repository.Operations.BookCrudOperations;
import Repository.Operations.SubscriberCrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbConfiguration connectionManager = new DbConfiguration();

        try (Connection connection = connectionManager.Connect()) {
            SubscriberCrudOperations subscriberCrudOperations = new SubscriberCrudOperations();
            if (connection != null) {
                List<Subscriber> allSubscribers;
                allSubscribers = subscriberCrudOperations.findAll();
                System.out.println("All Subscribers:");
                for (Subscriber subscriber : allSubscribers) {
                    System.out.println(subscriber.toString());
                }

                Subscriber newSubscriber = new Subscriber("1", "Ando", "M");
                Subscriber createdSubscriber = subscriberCrudOperations.save(newSubscriber);
                if (createdSubscriber != null) {
                    System.out.println("New subscriber created: " + createdSubscriber);
                } else {
                    System.out.println("Failed to create a new subscriber.");
                }

                Subscriber subscriberToDelete = new Subscriber();
                subscriberToDelete.setName("Ando");
                Subscriber deletedSubscriber = subscriberCrudOperations.delete(subscriberToDelete);
                if (deletedSubscriber != null) {
                    System.out.println("Subscriber deleted: " + deletedSubscriber);
                } else {
                    System.out.println("Failed to delete the subscriber.");
                }
            } else {
                System.out.println("Failed to establish a connection.");
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while fetching subscribers: " + e.getMessage());
            System.out.println("Failed to retrieve subscribers. Please try again later.");
        }

        try (Connection connection = connectionManager.Connect()) {
            AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
            if (connection != null) {

                List<Author> allAuthors = authorCrudOperations.findAll();
                System.out.println("All authors:");
                for (Author author : allAuthors) {
                    System.out.println(author.toString());
                }

                Author author = new Author("1", "Ando", "M");
                Author createdAuthor = authorCrudOperations.save(author);
                if (createdAuthor != null) {
                    System.out.println("New author created: " + createdAuthor);
                } else {
                    System.out.println("Failed to create a new author.");
                }

                Author authorToDelete = new Author();
                authorToDelete.setName("Ando");
                Author deletedAuthor = authorCrudOperations.delete(authorToDelete);
                if (deletedAuthor != null) {
                    System.out.println("author deleted: " + deletedAuthor);
                } else {
                    System.out.println("Failed to delete the author.");
                }
            } else {
                System.out.println("Failed to establish a connection.");
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while fetching author " + e.getMessage());
            System.out.println("Failed to retrieve author. Please try again later.");
        }

        try (Connection connection = connectionManager.Connect()) {
            BookCrudOperations bookCrudOperations = new BookCrudOperations();
            if (connection != null) {

                List<Book> allBooks = bookCrudOperations.findAll();
                System.out.println("All books:");
                for (Book book : allBooks) {
                    System.out.println(book.toString());
                }

                Book Book = new Book("001",1, "Sample Book", 242 , Model.Book.Topic.Other, null, Model.Book.Status.available);
                Book createdBook = bookCrudOperations.save(Book);
                if (createdBook != null) {
                    System.out.println("New book created: " + createdBook);
                } else {
                    System.out.println("Failed to create a new book.");
                }
                Book bookToDelete = new Book();
                bookToDelete.setBookName("Sample Book");
                Book deletedBook = bookCrudOperations.delete(bookToDelete);
                if (deletedBook != null) {
                    System.out.println("book deleted: " + deletedBook);
                } else {
                    System.out.println("Failed to delete the book.");
                }
            } else {
                System.out.println("Failed to establish a connection.");
            }

        } catch (SQLException e) {
            System.err.println("An error occurred while fetching author " + e.getMessage());
            System.out.println("Failed to retrieve author. Please try again later.");
        }


    }

}
