<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="order" value="${requestScope.order}" />
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <div>
      <ul>
        <li>
            Username: <c:out value="${order.username}" /> <br>
            Item Name: <c:out value="${order.itemName}"/>
            <c:if test="${order.glutenFree}"> (GF)
            </c:if>
            <br>Quantity: <c:out value="${order.itemQuantity}"/><br>
            <img src="<c:out value="${order.imageUrl}"/>" /><br>
        </li>
      </ul>
    </div>
  </body>
</html>