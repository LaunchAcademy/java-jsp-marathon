<%@ page language= "java" contentType = "text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "com.launchacademy.orders.models.Order" %>


<!DOCTYPE html>
<html>
	<head>
	    <title><c:out value="" /></title>
	</head>
	<body>
	  <ul>
	    <c:forEach items= "${requestScope.orders}" var= "order" >
        <li>
          <a href="/orders?orderId=<c:out value="${order.id}"/>"><c:out value = "${order.username}" />: <c:out value="${order.itemName}" /></a>
        </li>
    </c:forEach>
  	</ul>
  </body>
	</html>