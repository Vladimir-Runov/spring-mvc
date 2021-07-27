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
( 1,'Канеле (canelé) R.', 100, 1),
( 2,'Канеле (canelé) S.', 111, 2),
( 3,'Канеле (canelé) B.', 222, 3),
( 4,'Канеле (canelé) D.', 244, 4),
( 5,'Канеле (canelé) B.', 263, 5),
( 6,'Канеле (canelé) F.', 264, 6),
( 7,'Канеле (canelé) F.', 275, 7),
( 8,'Канеле (canelé) B.', 236, 8),
( 9,'Канеле (canelé) G.', 237, 9),
(10,'Канеле (canelé) G.', 239,10);

