
insert into products (product_id, product_name)
values (1, 'Computer'), (2, 'Monitor'),
       (3, 'Keyboard'), (4, 'Mouse');

insert into product_items (item_id, inventory_number, product_id)
values (1, 10010323, 1), (2, 10020323, 1),
       (3, 10030323, 1), (4, 10040323, 1),

       (5, 10050323, 2), (6, 10050323, 2),
       (7, 10070323, 2), (8, 10080323, 2),

       (9, 10090323, 3), (10, 10100323, 3),
       (11, 10110323, 3), (12, 10120323, 3),

       (13, 10130323, 4), (14, 10140323, 4),
       (15, 10150323, 4), (16, 10160323, 4);