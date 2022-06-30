INSERT INTO users (email, password, id)
VALUES
    ('user1@yandex.ru', '{noop}123456', nextval('global_seq')),
    ('user2@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user3@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user4@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user5@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user6@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user7@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user8@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user9@yandex.ru', '{noop}password', nextval('global_seq')),
    ('admin1@yandex.ru', '{noop}password', nextval('global_seq')),
    ('admin2@yandex.ru', '{noop}password', nextval('global_seq'))
;

INSERT INTO user_roles (role, user_id)
VALUES
    ('USER', 100000),
    ('USER', 100001),
    ('USER', 100002),
    ('USER', 100003),
    ('USER', 100004),
    ('USER', 100005),
    ('USER', 100006),
    ('USER', 100007),
    ('USER', 100008),
    ('USER', 100009),
    ('USER', 100010),
    ('ADMIN', 100009),
    ('ADMIN', 100010)
;

INSERT INTO restaurant (id, name)
VALUES (nextval('global_seq'), 'Stim'),         --100011
       (nextval('global_seq'), 'Surf Coffee'),  --100012
       (nextval('global_seq'), 'Zotman Pizza'), --100013
       (nextval('global_seq'), 'Farro')         --100014
;

INSERT INTO dish (id, name, date, price, restaurant_id)
VALUES (nextval('global_seq'), 'Capuccino', SYSDATE, 350, 100011),
       (nextval('global_seq'), 'Latte', SYSDATE, 350, 100011),
       (nextval('global_seq'), 'Sweet pipe', SYSDATE, 350, 100011),
       (nextval('global_seq'), 'Carrot pie', SYSDATE, 350, 100011),
       (nextval('global_seq'), 'Water', SYSDATE, 350, 100011),
       (nextval('global_seq'), 'Espresso', SYSDATE, 500, 100012),
       (nextval('global_seq'), 'Raf', SYSDATE, 500, 100012),
       (nextval('global_seq'), 'Donut', SYSDATE, 500, 100012),
       (nextval('global_seq'), 'Cheese cake', SYSDATE, 500, 100012),
       (nextval('global_seq'), 'Pepperoni', SYSDATE, 700, 100013),
       (nextval('global_seq'), 'Margarita', SYSDATE, 700, 100013),
       (nextval('global_seq'), 'Pineapple', SYSDATE, 700, 100013),
       (nextval('global_seq'), 'Ham and mushrooms', SYSDATE, 700, 100013),
       (nextval('global_seq'), 'Lemonade', SYSDATE, 700, 100013),
       (nextval('global_seq'), 'Grill', SYSDATE, 800, 100014),
       (nextval('global_seq'), 'Pepper', SYSDATE, 800, 100014),
       (nextval('global_seq'), 'Bologna', SYSDATE, 800, 100014),
       (nextval('global_seq'), 'Margarita', SYSDATE, 800, 100014),
       (nextval('global_seq'), 'Tar-tar', SYSDATE, 800, 100014) --100033
;

INSERT INTO vote (id, date_time, restaurant_id, user_id)
VALUES (nextval('global_seq'), SYSDATE, 100012, 100000),
       (nextval('global_seq'), SYSDATE, 100011, 100001),
       (nextval('global_seq'), SYSDATE, 100012, 100002),
       (nextval('global_seq'), SYSDATE, 100014, 100003),
       (nextval('global_seq'), SYSDATE, 100014, 100004),
       (nextval('global_seq'), SYSDATE, 100013, 100005),
       (nextval('global_seq'), PARSEDATETIME('29.06.2022 15:00', 'dd.MM.yyyy HH:mm'), 100014, 100006),
       (nextval('global_seq'), PARSEDATETIME('29.06.2022 10:00', 'dd.MM.yyyy HH:mm'), 100011, 100000)
;





