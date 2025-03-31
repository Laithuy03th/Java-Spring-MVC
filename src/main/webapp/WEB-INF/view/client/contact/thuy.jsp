<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liên Hệ - Lại Thị Thùy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        body {
            background: url("/images/lienhe/background.png") no-repeat center center fixed;
            background-size: cover;
        }
        .contact-container {
            max-width: 600px;
            margin: 50px auto;
            background: rgba(255, 255, 255, 0.9); /* Hộp trắng có độ trong suốt */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #d63384;
        }
        .contact-info {
            font-size: 18px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="contact-container text-center">
            <h1>Liên Hệ</h1>
            <p class="contact-info"><strong>Tên:</strong> Lại Thị Thùy</p>
            <p class="contact-info"><strong>Địa chỉ:</strong> Hà Nội, Việt Nam</p>
            <p class="contact-info"><strong>Số điện thoại:</strong> 0123 456 789</p>
            <p class="mt-4">Cảm ơn bạn đã ghé thăm! Nếu có bất kỳ thắc mắc nào, vui lòng liên hệ qua số điện thoại hoặc email của chúng tôi.</p>
            <a href="mailto:support@example.com" class="btn btn-primary">Gửi Email</a>
            <a href="tel:0123456789" class="btn btn-success">Gọi Ngay</a>
            <a href="/" class="btn btn-warning">Trang chủ</a>
        </div>
    </div>
</body>
</html>
