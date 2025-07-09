-- An SQL script to insert two categories and three products for initial testing.

-- Insert Categories
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');

-- Insert Products
INSERT INTO product (name, price, stock, category_id) VALUES ('Laptop', 999.99, 10, 1);
INSERT INTO product (name, price, stock, category_id) VALUES ('Smartphone', 499.99, 20, 1);
INSERT INTO product (name, price, stock, category_id) VALUES ('Java Programming Book', 49.99, 50, 2);
