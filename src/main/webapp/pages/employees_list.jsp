<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Employees List</title>
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
        <h1>Employees List</h1>
        <h3>
        <!-- <a href="<%=request.getContextPath()%>/new">Add New Employee</a> -->
            <a href="<%=request.getContextPath()%>/new" class="greenButton">Add Employee</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list">List Employees</a>
        </h3>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Employees</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Position</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.position}" /></td>
                    <td><c:out value="${employee.phone}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${employee.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${employee.id}' />" class="redButton">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>