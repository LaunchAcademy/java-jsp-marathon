<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="orders" value="${requestScope.orders}" />
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <div>
      <ul>
        <c:forEach items="${orders}" var="order">
        <li>
          <a href="/orders?orderId=<c:out value="${order.id}"/>">
            <c:out value="${order.username}"/> <c:out value="${order.itemName}" />
          </a>
        </li>
        </c:forEach>
      </ul>
    </div>
  </body>
</html>