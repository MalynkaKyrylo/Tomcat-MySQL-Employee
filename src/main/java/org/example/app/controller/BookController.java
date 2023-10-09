package org.example.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.entity.Book;
import org.example.app.repository.BookRepository;
import org.example.app.utils.Rounder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BookController extends HttpServlet {

    private final BookRepository repository = new BookRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new" -> showNewForm(request, response);
                case "/insert" -> insertBook(request, response);
                case "/delete" -> deleteBook(request, response);
                case "/edit" -> showEditForm(request, response);
                case "/update" -> updateBook(request, response);
                default -> listBook(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listBook = repository.readBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/book_list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/book_form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = repository.getBookById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/book_form.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Rounder.round(Double.parseDouble(request.getParameter("price")), 2);
        Book newBook = new Book(title, author, price);
        repository.createBook(newBook);
        response.sendRedirect("list");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Rounder.round(Double.parseDouble(request.getParameter("price")), 2);
        Book book = new Book(id, title, author, price);
        repository.updateBook(book);
        response.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = new Book(id);
        repository.deleteBook(book);
        response.sendRedirect("list");
    }
}
