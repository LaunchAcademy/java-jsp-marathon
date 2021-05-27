<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="orders" value="${requestScope.orders}" />

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello from JSP</title>
  </head>
  <body>

    <h2>Orders</h2>
    <ul>
      <c:forEach items="${orders}" var="order" >
        <li>
          Username: <c:out value="${order.username}" />
          Item name: 
         <a href="/orders?orderId=${order.id}"> <c:out value="${order.itemName}" /></a>

        </li>
      </c:forEach>
    </ul>

    <h4><a href="/orders/new">Order Again</a></h4>

  </body>
</html>
