<%@page language ="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>New Order</title>
</head>
<body>
<form action="/orders" method="post">
  <div>
    <label for="username">Username</label>
    <input type="text" name="username" id="username">
  </div>
  <div>
    <label for="itemName">Item Name</label>
    <input type="text" name="itemName" id="itemName">
  </div>
  <div>
    <label for="itemQuantity">Item Qty</label>
    <input type="number" name="itemQuantity" id="itemQuantity" min="0" max="24">
  </div>
  <div>
    <label for="imageUrl"> Image URL
    <input type="url" name="imageUrl" id="imageUrl" placeholder="http: or https:">
    </label>
  </div>
  <div>
    <p>Gluten Free (true/false):</p>
    <div>
    <input type="radio" id="true" name="glutenFree" value="true">
      <label for="true">True</label>
    </div>
    <div>
    <input type="radio" id="false" name="glutenFree" value="false">
    <label for="false">False</label>
    </div>
  </div>
  <input type="submit" value="Submit a new order."/>
</form>
</body>
</html>