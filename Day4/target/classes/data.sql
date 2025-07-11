-- Sample categories
INSERT INTO category (id, name, parent_id) VALUES (1, 'Electronics', NULL);
INSERT INTO category (id, name, parent_id) VALUES (2, 'Phones', 1);
INSERT INTO category (id, name, parent_id) VALUES (3, 'Laptops', 1);

-- Sample products
INSERT INTO product (id, name, price, category_id) VALUES (1, 'iPhone', 999.99, 2);
INSERT INTO product (id, name, price, category_id) VALUES (2, 'MacBook', 1299.99, 3);
INSERT INTO product (id, name, price, category_id) VALUES (3, 'Android Phone', 499.99, 2);

-- Sample orders
INSERT INTO orders (id, order_date, customer_name) VALUES (1, '2025-07-11T10:00:00', 'Alice');
INSERT INTO orders (id, order_date, customer_name) VALUES (2, '2025-07-11T11:00:00', 'Bob');

-- Sample order items
INSERT INTO order_item (id, product_name, quantity, price, order_id) VALUES (1, 'iPhone', 1, 999.99, 1);
INSERT INTO order_item (id, product_name, quantity, price, order_id) VALUES (2, 'MacBook', 1, 1299.99, 2);
INSERT INTO order_item (id, product_name, quantity, price, order_id) VALUES (3, 'Android Phone', 2, 499.99, 1);
