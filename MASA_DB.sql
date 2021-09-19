Drop database MASA;
go
CREATE DATABASE MASA;

USE MASA;

CREATE TABLE UserStatus(
	id integer,
	title varchar(20) not null,
	constraint UQ_UserStatus_Title unique(title),
	constraint PK_UserStatus primary key(id),
);

CREATE TABLE MeetingStatus(
	id integer,
	title varchar(20) not null,
	constraint UQ_MeetingStatus_Title unique(title),
	constraint PK_MeetingStatus primary key(id),
);

CREATE TABLE RequestStatus(
	id integer,
	title varchar(20) not null,
	constraint UQ_RequestStatus_Title unique(title),
	constraint PK_RequestStatus primary key(id),
);

CREATE TABLE Roles(
	id integer,
	title varchar(20) not null,
	constraint UQ_Role_Title unique(title),
	constraint PK_Role primary key(id),
);

CREATE TABLE Platforms(
	id integer,
	title varchar(20) not null,
	constraint UQ_Platform_Title unique(title),
	constraint PK_Platform primary key(id),
);

CREATE TABLE Accounts(
	id varchar(25),
	email varchar(30) not null,
	password varchar(20) not null,
	constraint PK_Account primary key(id),
	constraint UQ_Account_Email unique(email)
);

CREATE TABLE Users(
	id varchar(15),
	fullName nvarchar(30) not null,
	email varchar(30) not null,
	role_id integer not null,
	status_id integer not null,
	avatar_url varchar(50),
	constraint PK_User primary key(id),
	constraint UQ_email_Users unique(email),
	constraint FK_Users_Status_id foreign key(status_id) references UserStatus(id),
	constraint FK_Users_Role_id foreign key(role_id) references Roles(id)
);

CREATE TABLE Requests(
	id bigint,
	description varchar(255) not null,
	user_id varchar(15) not null,
	status_id integer not null,
	constraint PK_Request primary key(id),
	constraint FK_Request_User_id foreign key(user_id) references Users(id),
	constraint FK_Request_Status_id foreign key(status_id) references RequestStatus(id)
);

CREATE TABLE PlatformUrls(
	mentor_id varchar(15),
	platform_id integer not null,
	url varchar(30) not null,
	constraint PK_UserLink primary key(mentor_id,platform_id),
	constraint FK_UserLink_Mentor_id foreign key(mentor_id) references Users(id),
	constraint FK_UserLink_Platform_id foreign key(platform_id) references Platforms(id)
);

CREATE TABLE Meetings(
	id varchar(19),
	title varchar(40) not null,
	time_start bigint not null,
	time_end bigint not null,
	mentor_id varchar(15) not null,
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
	meeting_id varchar(19),
	user_id varchar(15),
	constraint PK_MeetingStudents primary key(meeting_id,user_id),
	constraint FK_MeetingStudents_Student_id foreign key(user_id) references Users(id),
	constraint FK_MeetingStudents_Meeting_id foreign key(meeting_id) references Meetings(id)
);


go
--drop procedure addMeeting
create procedure addMeeting
	@id varchar(19),
	@title varchar(40),
	@time_start bigint ,
	@time_end bigint ,
	@mentor_id varchar(15),
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
	@id varchar(19),
	@title varchar(40),
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
@id varchar(15)
as
begin
SELECT *
from Meetings
where mentor_id = @id;
end
