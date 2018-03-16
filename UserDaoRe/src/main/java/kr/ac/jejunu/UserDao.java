package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public User get(int id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();

        //sql 작성하고
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setInt(1, id);
        //sql 실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        //결과를 User 에 매핑하고
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원을 해지하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴한다.
        return user;
    }

    public Integer insert(User user) throws ClassNotFoundException, SQLException {
        //mysql driver load
        Connection connection = getConnection();
        //sql 작성하고
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into userinfo(name, password) values (?, ?)");
        preparedStatement.setInt(1, user.getName());
        preparedStatement.setInt(2, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Integer id = resultSet.getInt(1);

        user.setPassword(resultSet.getString("password"));
        //자원을 해지하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴한다.
        return null;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        //mysql driver load
        Class.forName("com.mysql.jdbc.Driver");
        //Connection 맺고
        return DriverManager.getConnection("jdbc:mysql://192.168.0.54/jeju?charactorEncoding=utf-8"
                , "jeju", "jejupw");
    }
}
