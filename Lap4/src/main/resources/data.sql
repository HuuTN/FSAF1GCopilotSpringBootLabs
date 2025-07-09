-- Insert categories
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');

-- Insert products
INSERT INTO product (id, name, price, category_id) VALUES (1, 'Smartphone', 699.99, 1);
INSERT INTO product (id, name, price, category_id) VALUES (2, 'Laptop', 1299.99, 1);
INSERT INTO product (id, name, price, category_id) VALUES (3, 'Novel', 19.99, 2);
