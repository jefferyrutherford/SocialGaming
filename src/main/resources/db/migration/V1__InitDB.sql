create table User
(
    Email  varchar(100) not null
        primary key,
    UserID int auto_increment,
    LastLoggedIn DATETIME,
    constraint user_pk2
        unique (UserID)
);

create table Game
(
    Title  varchar(100) not null
        primary key,
    Rating ENUM ('E','T','M'),
    Genre  SET ('Shooter','BR','Other'),
    GameID int auto_increment,
    constraint game_pk
        unique (GameID)
);


create table Format
(
    Format   varchar(100)                   not null
        primary key,
    TeamSize int default 1                  null,
    FormatID int auto_increment,
    GameID   int                            not null,
    constraint format_pk
        unique (FormatID),
    constraint format_game_GameID_fk
        foreign key (GameID) references Game (GameID)
);


create table Tournament
(
    TournamentID  int auto_increment
        primary key,
    GameID        int      not null,
    StartDateTime datetime null,
    EndDateTime   datetime null,
    constraint tournament_game_GameID_fk
        foreign key (GameID) references Game (GameID)
);


INSERT INTO User (Email) VALUE ('jeffTest@gmail.com');
INSERT INTO Game (Title, Rating, Genre) VALUE ('COD BLOPS6', 'M','Shooter');
INSERT INTO Format(Format, TeamSize, GameID) VALUE ('2v2', 2, 1);