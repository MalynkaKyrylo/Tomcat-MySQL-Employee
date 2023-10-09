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
    </style>
</head>
<body>
    <center>
        <h1>Employees List</h1>
        <h3>
            <a href="<%=request.getContextPath()%>/list"  class="greenButton">List Employees</a>
        </h3>
    </center>
    <div align="center">
        <c:if test="${employee != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h3>
                    <c:if test="${employee != null}">
                        Edit Employee
                    </c:if>
                    <c:if test="${employee == null}">
                        Add New Employee
                    </c:if>
                </h3>
            </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                </c:if>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${employee.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Position: </th>
                <td>
                    <input type="text" name="position" size="45"
                            value="<c:out value='${employee.position}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone: </th>
                <td>
                    <input type="text" name="phone" size="12"
                            value="<c:out value='${employee.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <form action="<%=request.getContextPath()%>/insert">
                        <input type="submit" value="Save" />
                    </form>
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>