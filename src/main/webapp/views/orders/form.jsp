<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Add a New Bookmark</title>
  </head>
  <body>
    <form action="/orders" method="post">
       <div>
          <label for="username">Userame</label>
          <input type="text" id="username" name="username" value="" />
       </div>
       <div>
          <label for="itemName">Item Name</label>
          <input type="text" id="itemName" name="itemName" value="" />
       </div>
       <div>
          <label for="itemQuantity">Quantity</label>
          <input type="number" id="itemQuantity" name="itemQuantity" value="" min="0" max="24"/>
       </div>
       <div>
          Gluten Free:
          <label for "glutenFree">Yes
          <input type="radio" id="glutenFreeYes" name="glutenFree" value="true" />
          </label>
          <label for "glutenFree"> No
          <input type="radio" id="glutenFreeNo" name="glutenFree" value="false" />
          </label>

       </div>
       <div>
           <label for="vegan">Vegan
           <input type="radio" id="veganYes" name="vegan" value="true" />
           <input type="radio" id="veganNo" name="vegan" value="false" />
           </label>
      </div>
       <div>
         <label for="imageUrl">Item Image Url</label>
         <input type="text" id="imageUrl" name="imageUrl" value="" />
       </div>

       <div>
        <input type="submit" value="Submit"/>
       </div>
    </form>
   </body>
</html>
