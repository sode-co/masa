# Masa: Meetings management

### HOW TO BUILD:
	- RUN DOCKER-COMPOSE

	serverdev là nhóm các services nhưng không bao gồm tomcat
	- $docker-compose up -d serverdev

### GIẢI THÍCH CẤU TRÚC FOLDERS:
	- MAILDATA: CHỨA NHỮNG EMAIL ĐANG GỬI

### CẤU HÌNH DATABASE:

	-- DATABASE NAME: MASA
	-- DATABASE USER: SA
	-- DATABASE USER PASSWORD: Password123
	-- PORT: 1533
	-- SERVER: LOCALHOST

	-- CONNECT DB USING AZURE:
		- server: localhost,1533
		- password: Password123
		- user: SA

### CÁCH REFRESH LẠI DATABASE:
	- Open docker desktop
	- Switch to volume tab VOLUMES
	- DELETE VOLUME vmssql

### CÁCH XEM VÀ REFRESH LẠI EMAIL:
	- MỞ FILE MAIL.JSON ĐỂ XEM CÁC EMAIL ĐANG GỬI.
	- XÓA FILE MAIL.JSON ĐỂ HỦY HÀNG ĐỢI GỬI EMAIL.

### CÁCH DỌN DẸP SAU KHI CODE XONG:
	- RUN $docker-compose down
	
### CÁCH UPDATE DOCKER:
	- Tắt container: RUN $docker-compose down
	- Xóa volumes để reset dữ liệu: 
	 - Cách 1: Sử dụng docker desktop:
		- Open Docker App
		- Select Volumes
		- Delete _vmssql Volumes
	 - Cách 2: Sử dụng lệnh:
	 	- RUN $docker volume rm masa_vmssql
	- Tải bản cập nhật mới: RUN $docker-compose pull
	- Khởi động lại Docker và đợi 30 giây RUN $docker-compose up -d serverdev --build
