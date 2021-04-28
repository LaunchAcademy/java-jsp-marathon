## Getting Started

```no-highlight
et get java-jsp-marathon
cd java-jsp-marathon
createdb my_bakery
idea .
```

## Cookies come from Bakeries!

Having spent part of the week learning about Cookies and the role they play in the modern web you decide that it's high time to create a bakery ordering platform.

## Core User Stories

### Order baked goods

```no-highlight
As a hungry student
I want to fill out a form
So that I can order baked goods
```

We want to be able to save our orders in our database. A migration and an entity to help persist these orders have been provided.

1. Create an `OrderService` DAO to handle our database operations. This file will require a new package under `orders`. Set up a method in this `Service` to persist a record to the database

2. Create a `Controller` to route our traffic. Ensure that a user can visit `/orders/new`

3. Create a new folder under `webapp` called `views` then under that `orders`. Within that `orders` folder create a JSP called `form.jsp` with a form to place an order. The form should contain the following fields:
  - Username
  - Item Name
  - Item Quantity (greater than 0 and less than or equal to 24)
  - Gluten Free (true/false) - use a radio button
  - Item Image URL

4. Create your POST route to receive the form submission. Orders should be saved to the database using the `OrderService`. Submitting the form should redirect us to the index page outlined below, at `/orders`. Don't worry about setting up this page or route just yet

### Viewing Orders

```no-highlight
As a hungry student
I want to see the open orders
So I can anticipate the delicious treats!
```

5. Update our `OrderService` to retrieve a list of the `orders` in the database

6. Update our controller to handle for the path `/orders`. Ensure that the controller passes forward a list of all orders to the view using the `OrderService` to retrieve the data

7. Create a new file `webapp/views/orders/index.jsp`. The JSP should display a list of the item name and attached username for all orders. Each of the item names should be a link to `/orders?orderId=<primarykey>` where `<primarykey>` is a unique identifier for the order. The `/orders` page should also have a link to "Order Again" which takes the user to the order form at `/orders/new`.

### Looking at order details

```no-highlight
As a hungry student
I want to see details on my item
So I can drool in anticipation
```

7. Update the `OrderService` to retrieve a single `Order` based on the `id` of the `Order`.

8. Update our controller to handle for a query string at the end of `/orders`. Ensure that the view is passed information for the order matching an `id` provided in the query string using the `Order Service`. 

9. Create a new file `webapp/views/orders/show.jsp`. Clicking onto an item name on the `/orders` page should send me to a show page for that item. The show page should display the username tied to the order. It should also display the item's name, quantity, and photo. Finally, it should show options: display "GF" if `gluten free` is `y`. If the item is not `gluten free` the page should not display `options`.


## Non-Core User Stories

You will need to read ahead to the material on `sessions` to complete the following:

### Viewing Only My Orders

```no-highlight
As a hungry student
I want to see only my open orders
So I can focus on the important things - like when MY treats are coming
```

Acceptance Criteria:

- When I complete an order and submit my form, it stores my username (filled in via the form) in a Session
- When I am redirected to `/orders`, I am presented with only those orders tied to my username
- Closing and reopening your browser and loading the page should reset your session and reload the entire list

### Remove orders from Database

```no-highlight
As a baker
I want to remove cancelled orders
So that I don't make items no one wants
```

Acceptance Criteria:

- When a user visits `/orders/cancel?orderId=<primarykey>` the corresponding record is deleted from the database in addition to being removed from their session
- `/orders` should provide a link that says "Delete" next to each order, which links to the corresponding cancellation path noted above

### Change order status

```no-highlight
As a baker
I want my orders to have a status
So I can track their progress
```

Acceptance Criteria:

- The bakery order table is updated to include a status field
- The status can be updated by navigating to `orders/update?orderId=<primarykey>`
- The order update page should display the order information as read only
- The order update page should have a status input (field or radio buttons) that accepts the following values
  - Confirmed
  - In progress
  - Completed
  - Cancelled
- When submitted the status should update in the database for that order

### Placing Additional Orders

```no-highlight
As a user
I want to be remembered when placing another order
So I can feel like a valued customer
```

- On the `/orders/new` page the user should be greeted by name if there is a username in the cookie
  - You can update the form POST route to add the username to the cookie in addition to the session
- The field for username should not appear if there is a username in the cookie
- There should be a button for "Not me!" next to their name which resets the cookie and shows the form with the username field
