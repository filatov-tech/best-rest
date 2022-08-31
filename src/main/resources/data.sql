INSERT INTO users (email, password, id)
VALUES
    ('user@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user1@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user2@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user3@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user4@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user5@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user6@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user7@yandex.ru', '{noop}password', nextval('global_seq')),
    ('user8@yandex.ru', '{noop}password', nextval('global_seq')),
    ('admin@yandex.ru', '{noop}password', nextval('global_seq')),
    ('admin1@yandex.ru', '{noop}password', nextval('global_seq'))
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

INSERT INTO dish (id, name, price, restaurant_id)
VALUES (nextval('global_seq'), 'Capuccino', 350, 100011),
       (nextval('global_seq'), 'Latte', 350, 100011),
       (nextval('global_seq'), 'Sweet pipe', 350, 100011),
       (nextval('global_seq'), 'Carrot pie', 350, 100011),
       (nextval('global_seq'), 'Water', 350, 100011),
       (nextval('global_seq'), 'Espresso', 500, 100012),
       (nextval('global_seq'), 'Raf', 500, 100012),
       (nextval('global_seq'), 'Donut', 500, 100012),
       (nextval('global_seq'), 'Cheese cake', 500, 100012),
       (nextval('global_seq'), 'Pepperoni', 700, 100013),
       (nextval('global_seq'), 'Margarita', 700, 100013),
       (nextval('global_seq'), 'Pineapple', 700, 100013),
       (nextval('global_seq'), 'Ham and mushrooms', 700, 100013),
       (nextval('global_seq'), 'Lemonade', 700, 100013),
       (nextval('global_seq'), 'Grill', 800, 100014),
       (nextval('global_seq'), 'Pepper', 800, 100014),
       (nextval('global_seq'), 'Bologna', 800, 100014),
       (nextval('global_seq'), 'Margarita', 800, 100014),
       (nextval('global_seq'), 'Tar-tar', 800, 100014) --100033
;

INSERT INTO dish (id, name, price, restaurant_id, enabled)
VALUES (nextval('global_seq'), 'Donut', 500, 100012, false)
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





