<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cookies Order Form</title>
  </head>
  <body>
    <h1>All Orders</h1>
    <c:forEach items="${requestScope.orders}" var="order">
      <h3><c:out value="${order.username}" /></h3>
      <p><c:out value="${order.itemName}" /></p>
    </c:forEach>


    <a href="/orders/new">Order Again</a>
  </body>
</html>