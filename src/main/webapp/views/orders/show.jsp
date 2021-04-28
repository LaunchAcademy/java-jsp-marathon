<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Orders</title>
  </head>
  <body>
    <h1>Current Orders</h1>
    <h3>Username: <c:out value="${order.username}"/></h3>
    <p>Bakery Item: <c:out value="${order.itemName}"/></p>
    <p>Order Quantity: <c:out value="${order.itemQuantity}"/></p>

    <c:if test="${order.glutenFree}">
      <p>Gluten free: Y </p>
    </c:if>
    <li><c:out value="${order.itemName}"/></a></li>
    <img src="<c:out value="${order.imageUrl}" /> "/>

    <p><a href="/orders">Back to Order List</a></p>

  </body>
</html>