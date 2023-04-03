SET SCHEMA PUBLIC;

CREATE SEQUENCE IF NOT EXISTS products_seq  START 1;

CREATE SEQUENCE IF NOT EXISTS product_items_seq START 1;

CREATE TABLE IF NOT EXISTS products(
    product_id int not null primary key,
    product_name varchar(150)
);

CREATE TABLE IF NOT EXISTS product_items(
    item_id int not null primary key,
    inventory_number int not null,
    product_id int references products(product_id)
);

insert into products (product_id, product_name)
values (nextval(products_seq), 'Computer'), (nextval(products_seq), 'Monitor'),
       (nextval(products_seq), 'Keyboard'), (nextval(products_seq), 'Mouse');

insert into product_items (item_id, inventory_number, product_id)
values (nextval(product_items_seq), 10010323, 1), (nextval(product_items_seq), 10020323, 1),
       (nextval(product_items_seq), 10030323, 1), (nextval(product_items_seq), 10040323, 1),

       (nextval(product_items_seq), 10050323, 2), (nextval(product_items_seq), 10050323, 2),
       (nextval(product_items_seq), 10070323, 2), (nextval(product_items_seq), 10080323, 2),

       (nextval(product_items_seq), 10090323, 3), (nextval(product_items_seq), 10100323, 3),
       (nextval(product_items_seq), 10110323, 3), (nextval(product_items_seq), 10120323, 3),

       (nextval(product_items_seq), 10130323, 4), (nextval(product_items_seq), 10140323, 4),
       (nextval(product_items_seq), 10150323, 4), (nextval(product_items_seq), 10160323, 4);