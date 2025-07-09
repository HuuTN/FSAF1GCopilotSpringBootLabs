-- Oracle-compatible SQL script to insert 2 categories and 3 products into the database.
INSERT INTO categories (name) VALUES ('Electronics');
INSERT INTO categories (name) VALUES ('Books');

INSERT INTO products (name, price, stock, category_id, created_at, updated_at)
VALUES ('Smartphone', 699.99, 100, (SELECT id FROM categories WHERE name = 'Electronics'), SYSTIMESTAMP, SYSTIMESTAMP);

INSERT INTO products (name, price, stock, category_id, created_at, updated_at)
VALUES ('Laptop', 1299.99, 50, (SELECT id FROM categories WHERE name = 'Electronics'), SYSTIMESTAMP, SYSTIMESTAMP);

INSERT INTO products (name, price, stock, category_id, created_at, updated_at)
VALUES ('Java Programming Book', 39.99, 200, (SELECT id FROM categories WHERE name = 'Books'), SYSTIMESTAMP, SYSTIMESTAMP);