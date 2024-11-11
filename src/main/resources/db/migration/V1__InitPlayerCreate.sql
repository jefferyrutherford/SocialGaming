
create table player
(
    Email  varchar(100) not null
        primary key,
    UserID int auto_increment,
    constraint player_pk2
        unique (UserID)
);



INSERT INTO player (Email) VALUE ('jeffTest@gmail.com')