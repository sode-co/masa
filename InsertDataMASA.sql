use MASA
go
/* Insert 4 roles intor Role table*/
INSERT INTO Roles(id, title)
VALUES(1, 'ADMIN');
INSERT INTO Roles(id, title)
VALUES(2, 'STUDENT');
INSERT INTO Roles(id, title)
VALUES(3, 'GUEST');
INSERT INTO Roles(id, title)
VALUES(4, 'MENTOR');
go
--select * from Roles go
--delete from Roles 
/* Insert 2 status intor UserStatus table*/
insert into UserStatus (id, title)
VALUES(1,'BLOCKED');
	
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