DROP TABLE IF EXISTS PRODUCT;
 
CREATE TABLE PRODUCT (

  product_brand_name VARCHAR(20) NOT NULL,
  product_name VARCHAR(20) NOT NULL,
  product_price VARCHAR(20) NOT NULL,
  product_code NUMBER(30) PRIMARY KEY
  
);