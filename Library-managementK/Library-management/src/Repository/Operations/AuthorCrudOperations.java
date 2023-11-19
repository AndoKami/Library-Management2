package Repository.Operations;

import Configuration.DbConfiguration;
import Model.Author;
import Repository.CrudOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author> {
    DbConfiguration connection = new DbConfiguration();

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM author";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Author author = new Author();
                    author.setId(resultSet.getString("id"));
                    author.setName(resultSet.getString("name"));
                    author.setSex(resultSet.getString("sex"));

                    authors.add(author);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        String sql = "INSERT INTO author(id,name,sex) VALUES (?,?,?)";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            for (Author author : toSave) {
                preparedStatement.setString(1, author.getId());
                preparedStatement.setString(2, author.getName());
                preparedStatement.setString(3, author.getSex());

                preparedStatement.executeQuery();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        String sql = "INSERT INTO author(id,name,sex) VALUES (?,?,?)";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, toSave.getId());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setString(3, toSave.getSex());

            preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        String sql = "DELETE FROM author WHERE id = ?";
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
