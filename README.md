# fincraft-assignment
Designed a product catalog as an assignment.

How to run the application:
1. mvn clean install
2. docker-compose build
3. docker-compose up

_I have added a script to add some users and some products which populates the user and product databases in MySql and MongoDB respectively._

Please find cURLs for registering user, adding product, fetching all products(by page/ all) and fetch product by id.

1. Register user:
   
curl : ```curl --location --request POST 'http://localhost:8080/v1/productCatalog/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "Archit Jain",
    "username" : "archit.jain2",
    "email" : "architjenn@gmail.com",
    "password" : "archit7"
}'```

3. Add a product :
   
curl : ```curl --location --request POST 'http://localhost:8080/v1/productCatalog/products' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "laptop",
  "description": "Product Description",
  "inventory": 100,
  "price": 29.99,
  "brand": "Product Brand",
  "imageUrl": "https://example.com/product-image.jpg",
  "createdBy": "john_doe"
}
'```

4. Fetch all products :
   
   i. Fetch by page :
     curl : ```curl --location --request GET 'http://localhost:8080/v1/productCatalog/products?page=0&size=10'```
   
   ii. Fetch all : 
      curl : ```curl --location --request GET 'http://localhost:8080/v1/productCatalog/products'```

 5. Fetch Product by id
    
  curl : ```curl --location --request GET 'http://localhost:8080/v1/productCatalog/products/{productId}'```
