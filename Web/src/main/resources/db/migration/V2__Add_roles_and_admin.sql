insert into usrs (login, name, password)
    values ('admin', 'admin', '$2y$08$6yTCpKiDbyE9jO2S8uQ3HOrADqwSzADr76QVRddI/ZEZg4T2c/SrK');

insert into roles (type_of_role, role_type_id)
    values ('admin', 'admin'), ('subordinate', 'subordinate'), ('head', 'head'), ('observer', 'observer');

insert into users_role (user_id, role_id)
    values ('admin', 'admin');