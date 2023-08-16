package postgres;

import utilities.Address;
import utilities.User;

import java.sql.*;
import java.util.Optional;

public class PostgresDB implements UserDAO {


    public static void main(String[] args) {
        UserDAO userDAO = new PostgresDB();
        User user = new User("test", "test", "test", new Address("petrovchina"));
        userDAO.save(user);
        //userDAO.findByUserName("test");

    }

    @Override
    public void save(User user) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/postgres", "postgres", "1111");
            connection.setAutoCommit(false);


            PreparedStatement preparedStatement1 = connection.prepareStatement("insert into addresses (street) values (?) returning id");
            preparedStatement1.setString(1, user.getAddress().getStreet());
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            long addressId = resultSet.getLong(1);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into users_web(name, username, password,address_id) values(?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setLong(4, addressId);
            preparedStatement.execute();

            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<User> findByUserName(String name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/postgres", "postgres", "1111");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from users_web where username = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Optional<User> optionalUser = Optional.of(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), null));
                return optionalUser;
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
