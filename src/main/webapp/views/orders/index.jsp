<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="order" items="${requestScope.orderList}">
 <c:out value="${order.username}"/>
 <c:out value="${order.itemName}"/>
</c:forEach>

