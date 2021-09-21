# fpt_masa

-- HOW TO BUILD:
	- RUN DOCKER-COMPOSE

	# serverdev là nhóm các services nhưng không bao gồm tomcat
	- $docker-compose up -d serverdev

-- GIẢI THÍCH CẤU TRÚC FOLDERS:
	- MAILDATA: CHỨA NHỮNG EMAIL ĐANG GỬI

-- CẤU HÌNH DATABASE:

	-- DATABASE NAME: MASA
	-- DATABASE USER: SA
	-- DATABASE USER PASSWORD: Password123
	-- PORT: 1533
	-- SERVER: LOCALHOST

	-- CONNECT DB USING AZURE:
		- server: localhost,1533
		- password: SA
		- user: SA

-- CÁCH REFRESH LẠI DATABASE:
	- RUN $docker-compose down
	- XÓA FOLDER DATABASE/MSSQLVOLUME
	- RUN $docker-compose up -d serverdev

-- CÁCH XEM VÀ REFRESH LẠI EMAIL:
	- MỞ FILE MAIL.JSON ĐỂ XEM CÁC EMAIL ĐANG GỬI.
	- XÓA FILE MAIL.JSON ĐỂ HỦY HÀNG ĐỢI GỬI EMAIL.

-- CÁCH DỌN DẸP SAU KHI CODE XONG:
	- RUN $docker-compose down