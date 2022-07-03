package com.evolutionnext.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class UsingDataSource {

    public static void main(String[] args) throws SQLException,
        ClassNotFoundException {
        if (args.length != 2) {
            System.out.println("Application needs two arguments, e.g. java " +
                "com" +
                ".evolutionnext.jdbc.UsingDataSource <root> <password>");
            System.exit(1);
        }
        String username = args[0];
        String password = args[1];

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("localhost");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);
        mysqlDataSource.setDatabaseName("sakila");
        queryFrom(mysqlDataSource);
//        insertIntoDirect(mysqlDataSource);
//        insertIntoWithGeneratedKeys(mysqlDataSource);
//        updateRecord(mysqlDataSource);
        createTable(mysqlDataSource);
    }

    private static void insertIntoDirect(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                 connection.prepareStatement("insert into country (country) " +
                     "values (?);", Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, "Eritrea");
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated %d\n", rows);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private static void insertIntoWithGeneratedKeys(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                 connection.prepareStatement("insert into country (country) " +
                     "values (?);", Statement.RETURN_GENERATED_KEYS);

        ) {
            preparedStatement.setString(1, "Eritrea");
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated %d\n", rows);
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()) {
                    System.out.printf("%d key was added\n",
                        keys.getLong(1));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private static void queryFrom(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT customer.first_name, customer.last_name, address.address," +
                " " +
                "city.city, country.country from customer left join " +
                "address on (customer.address_id = address.address_id) " +
                "left join city on (address.city_id = city.city_id) " +
                "left join country on (city.country_id = country.country_id) " +
                "where last_name like 'Ma%'" +
                "order by customer.first_name;");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("first_name = %s, last_name = %s, address = %s," +
                    " city = %s, country = %s\n",
                resultSet.getString(1), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4),
                resultSet.getString(5));
        }

        preparedStatement.close();
        resultSet.close();
        connection.close();
    }

    private static void updateRecord(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE film_text set description = ? where film_id = ?");
        ) {
            preparedStatement.setString(1, "Apache Devine is an Apache " +
                "Project that delivers messages to different brokers " +
                "without care as to what technology it is");
            preparedStatement.setLong(2, 31);
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated %d\n", rows);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private static void createTable(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "CREATE TABLE film_reviews (" +
                     "movie_review_id bigint primary key, " +
                     "news_source varchar(500) not null, " +
                     "stars int not null, " +
                     "reviewer varchar(200), " +
                     "film_id smallint unsigned not null, " +
                     "FOREIGN KEY (film_id) REFERENCES film(film_id)) ENGINE=INNODB;");
        ) {
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
