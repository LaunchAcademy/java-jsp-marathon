<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cookies Order Form</title>
  </head>
  <body>
    <h1>Add a New Order</h1>
    <form action="/orders" method="post">
      <div>
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" />
      </div>
      <div>
        <label for="itemName">Item Name:</label>
        <input type="text" name="itemName" id="itemName" />
      </div>
      <div>
        <label for="itemQuantity">Item Quantity:</label>
        <input type="number" name="itemQuantity" id="itemQuantity" />
      </div>
      <p>Gluten Free:</p>
      <div>
        <input type="radio" id="true" name="glutenFree" value="true" />
        <label for="true">Yes</label>
        <input type="radio" id="false" name="glutenFree" value="false" />
        <label for="false">No</label>
      </div>
      <div>
        <label for="imageUrl">Image Url:</label>
        <input type="text" name="imageUrl" id="imageUrl" />
      </div>
      <div>
        <input type="submit" value="Submit" />
      </div>
    </form>
  </body>
</html>

