package Repository.Operations;

import Configuration.DbConfiguration;
import Model.Book;
import Repository.CrudOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {
    DbConfiguration connection = new DbConfiguration();

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getString("id"));
                    book.setBookName(resultSet.getString("book_name"));
                    book.setTopic(Book.Topic.valueOf(resultSet.getString("topic")));
                    book.setPageNumbers(resultSet.getInt("page_numbers"));
                    book.setReleaseDate(resultSet.getDate("release_date"));
                    book.setAuthorId(resultSet.getInt("author_id"));
                    book.setStatus(Book.Status.valueOf(resultSet.getString("status")));

                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        String sql = "INSERT INTO book(id,book_name,topic,page_numbers,release_date,author_id,status) VALUES (?,?,?,?,?,?)";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            for (Book book : toSave) {
                preparedStatement.setString(1, book.getId());
                preparedStatement.setString(2, book.getBookName());
                preparedStatement.setString(3, String.valueOf(book.getTopic()));
                preparedStatement.setInt(4, book.getPageNumbers());
                preparedStatement.setDate(5, book.getReleaseDate());
                preparedStatement.setInt(6, book.getAuthorId());
                preparedStatement.setString(7,String.valueOf(book.getStatus()));

                preparedStatement.executeQuery();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Book save(Book toSave) {
        String sql = "INSERT INTO book(id,book_name,topic,page_numbers,release_date,author_id,status) VALUES (?,?,?,?,?,?)";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, toSave.getId());
            preparedStatement.setString(2, toSave.getBookName());
            preparedStatement.setString(3, String.valueOf(toSave.getTopic()));
            preparedStatement.setInt(4, toSave.getPageNumbers());
            preparedStatement.setDate(5, toSave.getReleaseDate());
            preparedStatement.setInt(6, toSave.getAuthorId());
            preparedStatement.setString(7,String.valueOf(toSave.getStatus()));

            preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, toDelete.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDelete;
    }
    }
