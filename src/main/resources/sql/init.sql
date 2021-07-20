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
('description text1', 'link 0'),
('description text2', 'link 1'),
('description text3', 'link 3'),
('description text4 ', 'link ..'),
('description text5 ', 'link ..'),
('description text6 ', 'link ..'),
('description text7 ', 'link ..');


DROP TABLE IF EXISTS prodmag.products CASCADE;

CREATE TABLE prodmag.products (id bigserial PRIMARY KEY, 

	name VARCHAR(128),
	price INT,

	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp, 
	details_id bigint, FOREIGN KEY (details_id) REFERENCES prodmag.product_details (id));
ALTER TABLE prodmag.products
    OWNER to postgres;

INSERT INTO prodmag.products (name, price, details_id) VALUES
('x1 S.', 100, 1),
('x2 S.', 111, 2),
('x3 B.', 222, 3),
('x4 D.', 244, 4),
('x3 B.', 263, 5),
('x6 F.', 264, 6),
('x7 F.', 275, 7),
('x8 B.', 236, 8),
('x9 G.', 237, 9)
('xA G.', 239,10);