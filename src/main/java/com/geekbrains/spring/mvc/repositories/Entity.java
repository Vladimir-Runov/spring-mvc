package com.geekbrains.spring.mvc.repositories;
import com.geekbrains.spring.mvc.model.Product;
import org.sqlite.JDBC;
import java.sql.*;
import java.util.*;

//          3. Создать entity класс для этой таблицы
//          4. Реализовать create, update, read и delete методы для этой сущности.
//          (создание сущности хардкодом, читать/обновлять/удалять существующие сущности)
public class Entity {
        private static final String CON_STR = "jdbc:sqlite:C:/sql/db_1.db";


    /*   ------------------------  create scema .sql
CREATE TABLE `spring-mvc`.`t_products` (
      `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `Title` TEXT NULL,
  `Cost` INT UNSIGNED ZEROFILL NULL DEFAULT 0,
  `Description` TEXT ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
                      */

        private static Entity instance = null;
        public static synchronized Entity getInstance() throws SQLException, ClassNotFoundException {
            if (instance == null)
                instance = new Entity();
            return instance;
        }
        //  --------------------------------------

   /*
    public void CloseConnection() throws SQLException {
        this.connection.close();
        this.connection = null;
    } */

        public void add(String title, int cost) {
            try (Connection connection = DriverManager.getConnection(CON_STR);
                 PreparedStatement st = connection.prepareStatement(SQL_INSERT_PRODUCT)) {
                st.setString(1, title);  // display name
                st.setString(2, String.valueOf(cost));

                int r = st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            }
        }
    public int del(int id) {
        int userID = 0;
        try (Connection connection = DriverManager.getConnection(CON_STR);
             PreparedStatement st = connection.prepareStatement(String.format("DELETE FROM t_Productss where id = '%s'", String.valueOf(id))) {
            ResultSet rs = st.executeQuery();
            if( rs.next() ) {
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Product get(int id) {
        try (Connection connection = DriverManager.getConnection(CON_STR);
             PreparedStatement st = connection.prepareStatement(String.format("SELECT Title, Cost FROM t_Productss where id = '%s'", String.valueOf(id))) {
            ResultSet rs = st.executeQuery();
            if( rs.next() ) {
                return new Product((long) id, rs.getString("Title"), rs.getInt("Cost"));

            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


