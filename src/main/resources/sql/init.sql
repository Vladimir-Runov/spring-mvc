DROP TABLE IF EXISTS prodmag.product_details CASCADE;
CREATE TABLE prodmag.product_details
(
    id bigserial NOT NULL,
    descr VARCHAR(128),
    url character varying(128),
    PRIMARY KEY (id)
);

ALTER TABLE prodmag.product_details
    OWNER to postgres;

INSERT INTO prodmag.product_details (descr, url) VALUES
('description....', 'link0'),
('text', 'link1'),
('text2', 'link 3');


DROP TABLE IF EXISTS prodmag.products CASCADE;

CREATE TABLE prodmag.products (id bigserial PRIMARY KEY, 
	title VARCHAR(128),
	price INT,
	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp, 
	details_id bigint, FOREIGN KEY (details_id) REFERENCES prodmag.product_details (id));
ALTER TABLE prodmag.products
    OWNER to postgres;

INSERT INTO prodmag.products (title, price, details_id) VALUES
('x1 S.', 100, 1),
('x2 S.', 111, 2),
('x3 B.', 222, 3);