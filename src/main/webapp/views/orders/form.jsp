<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello from JSP</title>
  </head>
  <body>
    <form action="/orders" method="Post">
      <h1>Create your order</h1>

      <div>
        <label for="username">Name:
          <input type="text" name="username" id="username">
        </label>

        <label for="itemName">Item:
          <input type="text" name="itemName" id="itemName">
        </label>

        <label for="itemQuantity">Quantity:
          <input type="number" name="itemQuantity" id="itemQuantity">
        </label>

        <p>Gluten Free:</p>
        <label for="glutenFree">True:
          <input type="radio" name="glutenFree" id="glutenFree" value="true">
        </label>

        <label for="glutenFree">False:
          <input type="radio" name="glutenFree" id="glutenFree" value="false">
        </label><br>

        <label for="imageUrl">Image URL:
          <input type="text" name="imageUrl" id="imageUrl">
        </label>

        <input type="submit" value="Create Order">

    </form>
  </body>
</html>
