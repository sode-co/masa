# Masa: Meetings management

### HOW TO BUILD:
	docker-compose up -d serverdev
serverdev là nhóm các services nhưng không bao gồm tomcat

### GIẢI THÍCH CẤU TRÚC FOLDERS:
- MAILDATA: CHỨA NHỮNG EMAIL ĐANG GỬI

### CẤU HÌNH DATABASE:

- DATABASE NAME: MASA
- DATABASE USER: SA
- DATABASE USER PASSWORD: Password123
- PORT: 1533
- SERVER: LOCALHOST
- CONNECT DB USING AZURE:

	server: localhost,1533
	password: Password123
	user: SA

### CÁCH RESET LẠI DỮ LIỆU TRONG DATABASE:
-- Tắt container: 

	docker-compose down
- Mở docker app
- Chuyển qua tab Volumes
- Xóa volume xx_vmssql

### CÁCH XEM VÀ RESET LẠI DỮ LIỆU CỦA SERVER EMAIL:
-- XÓA FILE MAIL.JSON ĐỂ HỦY HÀNG ĐỢI GỬI EMAIL.

### CÁCH DỌN DẸP SAU KHI CODE XONG:
	docker-compose down
	
### CÁCH UPDATE DOCKER:
-- Tắt container: 
	
	docker-compose down
- Xóa volumes để reset dữ liệu: 
	 - Cách 1: Sử dụng docker desktop:
		- Open Docker App
		- Select Volumes
		- Delete xx_vmssql Volumes
	 - Cách 2: Sử dụng lệnh:
	 
	 	docker volume rm masa_vmssql
-- Tải bản cập nhật mới:

	docker-compose pull
-- Khởi động lại Docker và đợi 30 giây:

	docker-compose up -d serverdev --build
