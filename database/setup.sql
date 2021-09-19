IF EXISTS (SELECT * FROM sys.databases WHERE name = 'MASA')
BEGIN
set noexec on
END;
GO

CREATE DATABASE MASA;
go
USE MASA;

CREATE TABLE UserStatus(
	id integer,
	title varchar(255) not null,
	constraint UQ_UserStatus_Title unique(title),
	constraint PK_UserStatus primary key(id),
);

CREATE TABLE MeetingStatus(
	id integer,
	title varchar(255) not null,
	constraint UQ_MeetingStatus_Title unique(title),
	constraint PK_MeetingStatus primary key(id),
);

CREATE TABLE RequestStatus(
	id integer,
	title varchar(255) not null,
	constraint UQ_RequestStatus_Title unique(title),
	constraint PK_RequestStatus primary key(id),
);

CREATE TABLE Roles(
	id integer,
	title varchar(255) not null,
	constraint UQ_Role_Title unique(title),
	constraint PK_Role primary key(id),
);

CREATE TABLE Platforms(
	id integer,
	title varchar(255) not null,
	constraint UQ_Platform_Title unique(title),
	constraint PK_Platform primary key(id),
);

CREATE TABLE Accounts(
	id varchar(255),
	email varchar(255) not null,
	password varchar(255) not null,
	constraint PK_Account primary key(id),
	constraint UQ_Account_Email unique(email)
);

CREATE TABLE Users(
	id varchar(255),
	fullName nvarchar(255) not null,
	email varchar(255) not null,
	role_id integer not null,
	status_id integer not null,
	avatar_url varchar(255),
	constraint PK_User primary key(id),
	constraint UQ_email_Users unique(email),
	constraint FK_Users_Status_id foreign key(status_id) references UserStatus(id),
	constraint FK_Users_Role_id foreign key(role_id) references Roles(id)
);

CREATE TABLE Requests(
	id varchar(255),
	description varchar(255) not null,
	user_id varchar(255) not null,
	status_id integer not null,
	constraint PK_Request primary key(id),
	constraint FK_Request_User_id foreign key(user_id) references Users(id),
	constraint FK_Request_Status_id foreign key(status_id) references RequestStatus(id)
);

CREATE TABLE PlatformUrls(
	mentor_id varchar(255),
	platform_id integer not null,
	url varchar(255) not null,
	constraint PK_UserLink primary key(mentor_id,platform_id),
	constraint FK_UserLink_Mentor_id foreign key(mentor_id) references Users(id),
	constraint FK_UserLink_Platform_id foreign key(platform_id) references Platforms(id)
);

CREATE TABLE Meetings(
	id varchar(255),
	title varchar(255) not null,
	time_start bigint not null,
	time_end bigint not null,
	mentor_id varchar(255) not null,
	platform_id integer not null,
	status_id integer not null,
	description varchar(255),
	constraint PK_Meeting primary key(id),
	constraint FK_Meeting_Mentor_id foreign key(mentor_id) references Users(id),
	constraint FK_Meeting_Platform_id foreign key(platform_id) references Platforms(id),
	constraint FK_Meeting_Status_id foreign key(status_id) references MeetingStatus(id),
	CONSTRAINT CheckTimeConstraint CHECK(time_start < time_end)
);

Create table Appointments(
	meeting_id varchar(255),
	user_id varchar(255),
	constraint PK_MeetingStudents primary key(meeting_id,user_id),
	constraint FK_MeetingStudents_Student_id foreign key(user_id) references Users(id),
	constraint FK_MeetingStudents_Meeting_id foreign key(meeting_id) references Meetings(id)
);


go
--drop procedure addMeeting
create procedure addMeeting
	@id varchar(255),
	@title varchar(255),
	@time_start bigint ,
	@time_end bigint ,
	@mentor_id varchar(255),
	@platform_id integer,
	@status_id integer,
	@description varchar(255)
	as 
	begin
		insert into Meetings values(@id,@title,@time_start,@time_end,@mentor_id,@platform_id,@status_id,@description);
		end
		go

		--drop procedure updateMeeting
create procedure updateMeeting
	@id varchar(255),
	@title varchar(255),
	@time_start bigint ,
	@time_end bigint ,
	@platform_id integer,
	@description varchar(255)
	as 
	begin
		update Meetings
		set 
		title = @title,
	time_start =@time_start,
	time_end =@time_end,
	platform_id =@platform_id,
	description =@description
		where id = @id;
	end

	go
	--drop procedure getAllMeetings
	create procedure getAllMeetings
as
begin
SELECT *
from Meetings
end

go

--getMeetingsByHost
go
--drop procedure getMeetingsByHost
create procedure getMeetingsByHost
@id varchar(255)
as
begin
SELECT *
from Meetings
where mentor_id = @id;
end
go
/* Insert 4 roles intor Role table*/
INSERT INTO Roles(id, title)
VALUES(1, 'ADMIN');
go
INSERT INTO Roles(id, title)
VALUES(2, 'STUDENT');
go
INSERT INTO Roles(id, title)
VALUES(3, 'GUEST');
go
INSERT INTO Roles(id, title)
VALUES(4, 'MENTOR');
go
--select * from Roles go
--delete from Roles 
/* Insert 2 status intor UserStatus table*/
insert into UserStatus (id, title)
VALUES(1,'BLOCKED');
go
INSERT INTO UserStatus (id, title)
VALUES(2,'ACTIVE');
	
--select * from UserStatus go	

go
--delete from UserStatus ;

/* Insert data into Meeting table*/
INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('SE100001', 'Nguyen Van An', 'annvSE100001@fpt.edu.vn', 'url1', 2, 2);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('SE100002', 'Nguyen Van Binh', 'binhnvSE100002@fpt.edu.vn', 'url2', 2, 2);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('SE100003', 'Nguyen Van Cuong', 'coungnvSE100003@fpt.edu.vn', 'url3', 2, 2);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('SE100004', 'Nguyen Van Duong', 'duongnvSE100004@fpt.edu.vn', 'url4', 2, 1);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('mentorE', 'Men tor E', 'mentorE@fpt.edu.vn', 'url5', 4, 2);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('mentorF', 'Men tor  F', 'mentorF@fpt.edu.vn', 'url6', 4, 2);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('GU100007', 'Ta Bien Cuong', 'cuongtbGU100007@fpt.edu.vn', 'url7', 3, 2);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('GU100008', 'Nguyen Phi Long', 'longnpGU100008@fpt.edu.vn', 'url8', 3, 2);

INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id)
VALUES
    ('AD100007', 'To Hong Dieu', 'dieuthAD100007@fpt.edu.vn', 'url9', 1, 2);

	--select * from Users 
	go

	--delete from Users

		/* Insert data into Platform table*/
INSERT INTO Platforms(id, title)
VALUES(1, 'GOOGLE MEET');
INSERT INTO Platforms(id, title)
VALUES(2, 'ZOOM');

--select * from Platforms;
--delete from Platforms;
go
/* Insert data into UserLink table*/
INSERT INTO PlatformUrls(mentor_id, platform_id, url)
VALUES('mentorE', 1, 'link1');

INSERT INTO PlatformUrls(mentor_id, platform_id, url)
VALUES('mentorF', 2, 'link2');

--select * from PlatformUrls;
go
--delete from PlatformUrls;

/* Insert data into MeetingStatus table*/
		
INSERT INTO MeetingStatus(id, title)
VALUES( 1, 'COMING');
INSERT INTO MeetingStatus(id, title)
VALUES( 2, 'DONE');
--select * from MeetingStatus;
--delete from MeetingStatus;
go
	/* Insert data into Meeting table*/
	--delete from Meetings;

INSERT INTO Meetings
    (id, title, time_start, time_end, mentor_id,platform_id, status_id, description)
VALUES
    ('M1', 'Thay E', 14, 16, 'mentorE', 1, 1, 'hoc OOP');

	INSERT INTO Meetings
    (id, title, time_start, time_end, mentor_id,platform_id, status_id, description)
VALUES
    ('M2', 'Thay F', 8, 10, 'mentorF', 2, 2, 'hoc C#');

	--select * from Meetings;
	--delete from Meetings;
go
/* Insert data into MeetingStatus table*/
INSERT INTO Appointments(meeting_id, user_id)
VALUES( 'M1', 'SE100001');
INSERT INTO Appointments(meeting_id, user_id)
VALUES( 'M1', 'SE100002');
INSERT INTO Appointments(meeting_id, user_id)
VALUES( 'M1', 'GU100007');
INSERT INTO Appointments(meeting_id, user_id)
VALUES( 'M2', 'SE100003');
INSERT INTO Appointments(meeting_id, user_id)
VALUES( 'M2', 'GU100008');

--select * from Appointments;
--delete from Appointments;
go
/* Insert data into RequestStatus table*/
insert into RequestStatus (id, title)
VALUES(1,'DENIED');
insert into RequestStatus (id, title)
VALUES(2,'PROCESSING');
insert into RequestStatus (id, title)
VALUES(3,'APPROVED');
--select * from RequestStatus
--delete from RequestStatus
go
/* Insert data into Requests table*/
insert into Requests (id, description, user_id, status_id)
VALUES(1,'No description','GU100007', 2 );
insert into Requests (id, description, user_id, status_id)
VALUES(2,'Bla bla','GU100008', 1 );
--select * from Requests

--delete from Requests

/*
select U.email, U.fullName, U.role_id, U.status_id 
from Users U , MeetingStudents M 
where U.id = M.student_id and  M.meeting_id = 2;

use MASA
Select id, fullName, avatar_url, role_id, last_login, status_id
 From Users
WHERE Users.email = 'NguyenVanA@gmail.com'
go */

Select id, fullName, email, avatar_url, role_id, status_id 
From Users
WHERE id = 'SE100001'
go

set noexec off 
go