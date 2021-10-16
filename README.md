# CacHeThongPhanTan
Đồ án cuối kỳ môn Các Hệ Thống Phân Tán PTITHCM - 2021
# Tên đề tài
Xây dựng service xử lý tương tranh trong việc bán ghế cho các đại lý bán vé máy bay
## Thành viên
| Họ & Tên  | MSSV| Lớp|
| ------------- | ------------- |----------|
| Đậu Trường Quân           |N18DCCN162  |D18CQCP02|
| Nguyễn Ngọc Phương Trinh    | N18DCCN231  |D18CQCP02|
| Hà Thị Mơ           |N18DCCN126  |D18CQCP01|
| Nguyễn Ngọc Lâm Như    | N18DCCN144  |D18CQCP02|
| Tôn Thị Huế    | N18DCCN075  |D18CQCP01|
## Giảng viên hướng dẫn
>>**Lê Ngọc Bảo**
## Nội dung
**Server**
* Hiển thị danh sách ghế với hai trạng thái "được mua" hoặc "được đặt" (tương ứng với hai cột SOLD và BLOCK)
* Thông báo client nào đang kết nối hoặc ngắt kết nối, client nào đã mua ghế nào

**Client**
* Thể hiện các vé dưới dạng nút để người dùng ấn chọn, mỗi ghế có các trạng thái sau đây:
  * Màu xanh: chưa có client nào đặt
  * Màu vàng: đang được đặt
  * Màu đỏ: đã được mua
* Khi người dùng click chọn một ghế, ghế đó sẽ xem như được đặt, client khác sẽ không được đặt nữa
* Sau 10s nếu ghế đang được đặt không được mua thì sẽ tự động hủy đặt
* Khi người dùng ấn nút Mua, ghế đó sẽ được mua và không thể được đặt nữa
