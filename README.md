# Website--SportStore

# Sơ đồ ERD

![image](https://user-images.githubusercontent.com/87469606/230778805-19b5d88b-7a79-406c-ae2b-ed60b40f67f4.png)

# Flow Chat

![image](https://user-images.githubusercontent.com/87469606/230780629-f3b0f001-76d8-4290-9273-9596b44de7b3.png)

# Installation

Can use Intellij or Esclipse or Spring Tool

# Application UI

HomePage

![image](https://user-images.githubusercontent.com/87469606/230780786-51ea153a-4153-4ef5-9e35-b8910877b319.png)

Detail Product

![image](https://user-images.githubusercontent.com/87469606/230780804-a2dc1189-3993-44d3-8460-456ddc2308a9.png)

Login

![image](https://user-images.githubusercontent.com/87469606/230780824-29986f3e-c097-4b0c-aaad-1b6b3613b537.png)

Cart and checkout

![image](https://user-images.githubusercontent.com/87469606/230780837-e87f899d-a92a-4206-b9f4-3b4221b3c5dc.png)

Thank you

![image](https://user-images.githubusercontent.com/87469606/230780870-2172f613-d2ec-4809-8b8c-11e8fd0c72e5.png)

Admin addproduct and show list product

![image](https://user-images.githubusercontent.com/87469606/230780891-b0da698e-1a8b-48ed-81b5-49fe811a3743.png)

Admin show list bill order in query

![image](https://user-images.githubusercontent.com/87469606/230780922-980e3c75-8912-4c18-a519-9e46ec18847b.png)

Admin show list bill order handled

![image](https://user-images.githubusercontent.com/87469606/230780951-fc872e55-b2d7-4d05-b278-cca53ef51b10.png)

# HTTP Headers

Homepage: localhost:8080

View List Product: http://localhost:8080/product/listProduct 

Search Product: http://localhost:8080/product/search?keyword= 

Filter : http://localhost:8080/product/filter?brand=&color=&price= 

Add product to Cart: http://localhost:8080/product/add/{id} 

Detail product : http://localhost:8080/product/details/{id} 

View Cart: http://localhost:8080/product/shopping-cart 

Checkout product: http://localhost:8080/product/update 

Thank you: http://localhost:8080/product/order

Login Page: http://localhost:8080/login -- Only use when they have account "admin" and password "admin123". If don't have , no to connect Admin Home

# Admin

Admin home: http://localhost:8080/Admin/home 

Admin add product and show list product: httpL//localhost:8080/Admin/saveProduct 

Delete Product: http://localhost:8080/Admin/delete/{id}(id=${product.id}) 

Edit Product: http://localhost:8080/Admin/products/edit/{id}(id=${product.id}) 

# Explaination application

The website is very friendly for people to use. People can see a lot of football shoes follow to list. It shows price and detail about product to help people to choose for themself. You can search product to follow your favorite such as color,brand. Then you can order and checkout. Especially, needn't to create account.

Login page only for admin, who want to manage the application. It'll prevent if you must not be a manager. It not remove other page, it still stay in login page. Admin can add,edit,delete product , they can hanlde bill order to accept or deny, who can see list order was handled.

# Code Structure

5 package and 1 folder resource:
- package controller: HomeController
- package entity: BillAccept, Cart, Product
- package repository: BillRepository, CartRepository, ProductRepository
- package security: SecurityConfig
- package service: BillService, ProductService, ShoppingCartService

* resources: 
  - static: folder css, image
  - templates: contain all html files
  - application.properties
