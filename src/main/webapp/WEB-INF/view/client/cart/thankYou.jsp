<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thank You!</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
          body {
            background: url("/images/lienhe/background.png") no-repeat center center fixed;
            background-size: cover;
        }
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }
        .thank-you-container {
            background: rgba(255, 255, 255, 0.636);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
        }
        .thank-you-icon {
            font-size: 50px;
            color: #28a745;
        }
    </style>
</head>
<body>
    <div class="thank-you-container">
        <div class="thank-you-icon">✅</div>
        <h2>Cảm ơn bạn đã đặt hàng!</h2>
        <p><strong>Đơn hàng của bạn đã được xác nhận và chúng tôi sẽ xử lý sớm nhất có thể.</strong></p>
        <a href="/" class="btn btn-success mt-3">Tiếp tục mua sắm</a>
    </div>
</body>
</html>
