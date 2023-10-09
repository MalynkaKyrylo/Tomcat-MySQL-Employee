package org.example.app.repository;

import org.example.app.database.DBConn;
import org.example.app.entity.Book;
import org.example.app.utils.Rounder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookRepository {

    private static final Logger LOGGER =
            Logger.getLogger(BookRepository.class.getName());

    public void createBook(Book book) {
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setDouble(3, Rounder.round(book.getPrice(), 2));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public List<Book> readBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Book(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("author"),
                                Rounder.round(rs.getDouble("price"), 2)
                        )
                );
            }
            // Повертаємо колекцію даних
            return list;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            // Якщо помилка – повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }

    public Book getBookById(int id) {
        Book book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                book = new Book(id, rs.getString("title"),
                        rs.getString("author"),
                        Rounder.round(rs.getDouble("price"), 2)
                );
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return book;
    }

    public void updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setDouble(3, Rounder.round(book.getPrice(), 2));
            pstmt.setInt(4, book.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public void deleteBook(Book book) {
        String sql = "DELETE FROM books where id = ?";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, book.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }
}
