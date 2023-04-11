CREATE SEQUENCE products_seq start with 5 increment by 1;

CREATE SEQUENCE product_items_seq start with 17 increment by 1;

CREATE TABLE products(
    product_id int not null primary key,
    product_name varchar(150)
);

CREATE TABLE product_items(
    item_id int not null primary key,
    inventory_number int not null,
    product_id int references products(product_id)
);