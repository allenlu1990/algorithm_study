create table if not exists test.options
(
	id int not null
		primary key,
	place varchar(255) not null,
	opinion varchar(255) not null
);



INSERT INTO test.options (id, place, opinion) VALUES (1, 'mount nawo oz', 'recommended');
INSERT INTO test.options (id, place, opinion) VALUES (2, 'mount nawo oz', 'not recommended');
INSERT INTO test.options (id, place, opinion) VALUES (3, 'codility', 'recommended');
INSERT INTO test.options (id, place, opinion) VALUES (4, 'codility', 'recommended');
INSERT INTO test.options (id, place, opinion) VALUES (5, 'codility', 'recommended');
INSERT INTO test.options (id, place, opinion) VALUES (6, 'qr week', 'recommended');
INSERT INTO test.options (id, place, opinion) VALUES (7, 'qr week', 'not recommended');
INSERT INTO test.options (id, place, opinion) VALUES (8, 'cafe worst', 'not recommended');
INSERT INTO test.options (id, place, opinion) VALUES (9, 'mount nawo oz', 'recommended');


select place from(
                select  place,
                    sum(case when opinion ='recommended' then 1 else 0 end) as recommended,
                    sum(case when opinion ='not recommended' then 1 else 0 end) as not_recommended
                from options group by place
                     ) T
where recommended > not_recommended;
