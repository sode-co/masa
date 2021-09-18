Drop database MASA;
go
CREATE DATABASE MASA;

USE MASA;

CREATE TABLE UserStatus(
	id varchar(15),
	constraint PK_UserStatus primary key(id),
);

CREATE TABLE MeetingStatus(
	id varchar(15),
	constraint PK_MeetingStatus primary key(id),
);

CREATE TABLE RequestStatus(
	id varchar(15),
	constraint PK_RequestStatus primary key(id),
);

CREATE TABLE Role(
	id varchar(15),
	constraint PK_Role primary key(id),
);

CREATE TABLE Platform(
	id varchar(15),
	constraint PK_Platform primary key(id),
);

CREATE TABLE Account(
	id varchar(25),
	email varchar(30),
	password varchar(20),
	constraint PK_Account primary key(id),
	constraint UQ_Email_Account unique(email)
);

CREATE TABLE Users(
	id varchar(15),
	fullName nvarchar(30) not null,
	email varchar(30) not null,
	avatar_url varchar(50),
	role_id varchar(15),
	last_login bigint not null,
	status_id varchar(15),
	constraint PK_User primary key(id),
	constraint UQ_email_Users unique(email),
	constraint FK_Users_Status_id foreign key(status_id) references UserStatus(id),
	constraint FK_Users_Role_id foreign key(role_id) references Role(id)
);

CREATE TABLE Request(
	id bigint,
	description varchar(255) not null,
	user_id varchar(15),
	status_id varchar(15),
	constraint PK_Request primary key(id),
	constraint FK_Request_User_id foreign key(user_id) references Users(id),
	constraint FK_Request_Status_id foreign key(status_id) references RequestStatus(id)
);

CREATE TABLE UserLink(
	mentor_id varchar(15),
	platform_id varchar(15),
	link_meeting varchar(30),
	constraint PK_UserLink primary key(mentor_id,platform_id),
	constraint FK_UserLink_Mentor_id foreign key(mentor_id) references Users(id),
	constraint FK_UserLink_Platform_id foreign key(platform_id) references Platform(id)
);

CREATE TABLE Meeting(
	id bigint,
	title varchar(40) not null,
	time_start bigint not null,
	time_end bigint not null,
	mentor_id varchar(15),
	platform_id varchar(15),
	status_id varchar(15),
	description varchar(255),
	constraint PK_Meeting primary key(id),
	constraint FK_Meeting_Mentor_id foreign key(mentor_id) references Users(id),
	constraint FK_Meeting_Platform_id foreign key(platform_id) references Platform(id),
	constraint FK_Meeting_Status_id foreign key(status_id) references MeetingStatus(id),
	CONSTRAINT CheckTimeConstraint CHECK(time_start < time_end)
);

Create table MeetingStudents(
	meeting_id bigint,
	student_id varchar(15),
	constraint PK_MeetingStudents primary key(meeting_id,student_id),
	constraint FK_MeetingStudents_Student_id foreign key(student_id) references Users(id),
	constraint FK_MeetingStudents_Meeting_id foreign key(meeting_id) references Meeting(id)
);


go
--drop procedure addMeeting
create procedure addMeeting
	@id bigint,
	@title varchar(40),
	@time_start bigint ,
	@time_end bigint ,
	@mentor_id varchar(15),
	@platform_id varchar(15),
	@status_id varchar(15),
	@description varchar(255)
	as 
	begin
		insert into Meeting values(@id,@title,@time_start,@time_end,@mentor_id,@platform_id,@status_id,@description);
		end
		go

		--drop procedure updateMeeting
create procedure updateMeeting
	@id bigint,
	@title varchar(40),
	@time_start bigint ,
	@time_end bigint ,
	@platform_id varchar(15),
	@description varchar(255)
	as 
	begin
		update Meeting
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
from Meeting as mt
inner join UserLink as ul
on mt.mentor_id=ul.mentor_id and mt.platform_id=ul.platform_id;
end

go

--getMeetingsByHost
go
--drop procedure getMeetingsByHost
create procedure getMeetingsByHost
@id varchar(15)
as
begin
SELECT *
from Meeting
where mentor_id = @id;
end
