INSERT INTO products(
    id,
    p_number,
    product,
    category,
    price,
    registration_date
    ) VALUES (
    1,
    1,
    'オフィスデスク',
    '机',
    '30,000'
    );

INSERT INTO stocks(
    id,
    product_id,
    inventory,
    ) VALUES (
    1,
    1,
    5,
    );

INSERT INTO orders(
    id,
    stocks_id,
    orders_number,
    delivery_date
    ) VALUES (
    1,
    1,
    5,
    '2024-06-12'
    );