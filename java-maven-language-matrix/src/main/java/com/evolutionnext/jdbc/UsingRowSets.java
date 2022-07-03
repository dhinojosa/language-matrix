package com.evolutionnext.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class UsingRowSets {
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

        RowSetFactory factory = RowSetProvider.newFactory();

        try (JdbcRowSet jdbcRowSet = factory.createJdbcRowSet()) {
            jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/sakila");
            jdbcRowSet.setUsername(username);
            jdbcRowSet.setPassword(password);
            jdbcRowSet.setCommand("SELECT first_name, last_name from " +
                "customer where last_name like ? order by first_name");
            jdbcRowSet.setString(1, "Ma%");
            jdbcRowSet.execute();
            while (jdbcRowSet.next()) {
                System.out.printf("first_name = %s, last_name = %s;\n", jdbcRowSet.getString(1), jdbcRowSet.getString(2));
            }
        }
    }
}
