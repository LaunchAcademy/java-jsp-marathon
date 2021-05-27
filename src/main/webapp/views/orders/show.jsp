<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="order" value="${requestScope.order}" />

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello from JSP</title>
  </head>
  <body>
    <img src="${order.imageUrl}" alt="cookie image">
    <h2>Username: <c:out value="${order.username}"/></h2>
    <h2>Item Name: <c:out value="${order.itemName}"/></h2>
    <h2>Item Quantity: <c:out value="${order.itemQuantity}"/></h2>
    <c:if test="${order.glutenFree}">
      <h2>GF: Yes!</h2>
    </c:if>
  </body>
</html>
