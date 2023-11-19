package Repository.Operations;

import Configuration.DbConfiguration;
import Model.Subscriber;
import Repository.CrudOperations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<Subscriber> {
    DbConfiguration connection = new DbConfiguration();

    public SubscriberCrudOperations() {

    }

    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> subscribers = new ArrayList<>();
        String sql = "SELECT * FROM subscribers";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Subscriber subscriber = new Subscriber();
                    subscriber.setId(resultSet.getString("id"));
                    subscriber.setName(resultSet.getString("name"));
                    subscriber.setSex(resultSet.getString("sex"));

                    subscribers.add(subscriber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        String sql = "INSERT INTO subscribers(id,name,sex) VALUES (?,?,?)";

        try (Connection conn = connection.Connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            for (Subscriber subscriber : toSave) {
                preparedStatement.setString(1,subscriber.getId());
                preparedStatement.setString(2,subscriber.getName());
                preparedStatement.setString(3,subscriber.getSex());

                preparedStatement.executeQuery();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        String sql = "INSERT INTO subscribers(id,name,sex) VALUES (?,?,?)";

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
    public Subscriber delete(Subscriber toDelete) {
        String sql = "DELETE FROM subscribers WHERE id = ?";
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
