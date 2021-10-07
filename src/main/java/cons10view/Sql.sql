CREATE [OR REPLACE] VIEW view_name AS

  SELECT columns

  FROM tables

  [WHERE conditions];

CREATE VIEW current_inventory AS
  SELECT product_name, quantity
  FROM products
  WHERE quantity > 0;


  SELECT *  FROM current_inventory;

==================================
CREATE OR REPLACE VIEW view_name AS

  SELECT columns

  FROM table

  WHERE conditions;



  CREATE or REPLACE VIEW current_inventory AS
  SELECT product_name, quantity, category_name
  FROM products
  INNER JOIN categories
  ON products.category_id = categories.category_id
  WHERE quantity > 0;
-------------------

Drop VIEW [IF EXISTS] view_name;

Drop VIEW current_inventory;

=====================================

