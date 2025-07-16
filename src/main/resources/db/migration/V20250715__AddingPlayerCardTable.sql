create table PlayerCard
(
    UserID VARCHAR(36) not null
        primary key,
    PhotoID int not null ,
    Title VARCHAR(50),

    constraint user_pk
        unique (UserID),
    constraint PlayerCard_UserID_fk
        foreign key (UserID) references User (UserID)
);

insert into PlayerCard (UserID, PhotoID, Title) VALUE ('e10bb590-5051-7079-f569-96e8246c917c', 1, 'Default Andy')