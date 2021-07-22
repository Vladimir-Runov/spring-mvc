create user myuser with encrypted password 'mypass';
grant all privileges on database postgres to myuser;
grant all privileges on schema prodmag to myuser;


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
('description text7 ', 'link ..'),
('description text8 ', 'link ..'),
('description text9 ', 'link ..'),
('description text10' , 'link ..');


DROP TABLE IF EXISTS prodmag.products CASCADE;

CREATE TABLE prodmag.products (id bigserial PRIMARY KEY, 

	name VARCHAR(128),
	price INT,

	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp, 

	details_id bigint, FOREIGN KEY (details_id) REFERENCES prodmag.product_details (id));
ALTER TABLE prodmag.products
    OWNER to postgres;

INSERT INTO prodmag.products (id,name, price, details_id) VALUES
( 1,'x1 S.', 100, 1),
( 2,'x2 S.', 111, 2),
( 3,'x3 B.', 222, 3),
( 4,'x4 D.', 244, 4),
( 5,'x3 B.', 263, 5),
( 6,'x6 F.', 264, 6),
( 7,'x7 F.', 275, 7),
( 8,'x8 B.', 236, 8),
( 9,'x9 G.', 237, 9),
(10,'xA G.', 239,10);

SELECT * FROM prodmag.products
ORDER BY id ASC 


GRANT ALL ON SEQUENCE prodmag.product_details_id_seq TO postgres;

GRANT ALL ON SEQUENCE prodmag.products_id_seq TO postgres;

GRANT ALL ON TABLE prodmag.product_details TO postgres;

GRANT ALL ON TABLE prodmag.products TO postgres;

