<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a new order</title>
  </head>
  <body>
    <form action="/orders" method="post">
      <div>
        <label for="username">username</label>
        <input type="text" id="username" name="username" value="" />
      </div>
      <div>
        <label for="itemName">item name</label>
        <input type="text" id="itemName" name="itemName" value="" />
      </div>
      <div>
        <label for="itemQuantity">item quantity</label>
        <input type="text" id="itemQuantity" name="itemQuantity" value="" />
      </div>
      <div>
        <label for="glutenFree">gluten free</label>
        <input type="radio" id="isGlutenFree" name="glutenFree" value="true" /><label>true</label>
        <input type="radio" id="notGlutenFree" name="glutenFree" value="false" /><label>false</label>
      </div>
      <div>
        <label for="imageUrl">image URL</label>
        <input type="text" id="imageUrl" name="imageUrl" value="" />
      </div>
        <input type="submit" value="submit" />
      </form>
  </body>
</html>