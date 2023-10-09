<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Books Store</title>
    <style>
        .greenButton {
            background-color:#44c767;
            border-radius:16px;
            border:1px solid #18ab29;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-family:Arial;
            font-size:14px;
            padding:8px 16px;
            text-decoration:none;
            text-shadow:0px 1px 0px #2f6627;
        }
        .greenButton:hover {
            background-color:#5cbf2a;
        }
        .greenButton:active {
            position:relative;
            top:1px;
        }
        .redButton {
            box-shadow:inset 0px 39px 0px -24px #e67a73;
            background-color:#e4685d;
            border-radius:4px;
            border:1px solid #ffffff;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-family:Arial;
            font-size:12px;
            padding:6px 14px;
            text-decoration:none;
            text-shadow:0px 1px 0px #b23e35;
        }
        .redButton:hover {
            background-color:#eb675e;
        }
        .redButton:active {
            position:relative;
            top:1px;
        }
    </style>
</head>
<body>
    <center>
        <h1>Book Store</h1>
        <h3>
        <!-- <a href="<%=request.getContextPath()%>/new">Add New Book</a> -->
            <a href="<%=request.getContextPath()%>/new" class="greenButton">Add Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list">List Books</a>
        </h3>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${book.id}' />" class="redButton">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>