<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>LaptopStore - Lịch sử mua hàng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet">
    
    <!-- Font Awesome & Bootstrap Icons -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    
    <!-- External Libraries -->
    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    
    <!-- Bootstrap & Custom Styles -->
    <link href="/client/css/bootstrap.min.css" rel="stylesheet">
    <link href="/client/css/style.css" rel="stylesheet">
    
    <style>
        .order-header-row {
            background-color: #f8f9fa;
            font-weight: bold;
        }
        .order-id-cell {
            padding: 10px 15px;
        }
    </style>
</head>

<body>
    <!-- Loading Spinner -->
    <div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-grow text-primary" role="status"></div>
    </div>

    <!-- Header -->
    <jsp:include page="../layout/header.jsp"/>

    <!-- Main Content -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <h1 class="mb-4 text-center">Lịch sử mua hàng</h1>
            
            <c:if test="${empty orders}">
                <p class="text-center">Không có đơn hàng nào được tạo.</p>
            </c:if>
            
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">Sản phẩm</th>
                            <th scope="col">Tên</th>
                            <th scope="col">Giá</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Thành tiền</th>
                            <th scope="col">Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr class="order-header-row">
                                <td colspan="6" class="order-id-cell">Mã đơn hàng: ${order.id}</td>
                                <!-- <td colspan="2" class="order-id-cell text-end">${order.status}</td> -->
                            </tr>
                            <c:forEach var="orderDetail" items="${order.orderDetails}">
                                <tr>
                                    <td>
                                        <img src="/images/product/${orderDetail.product.image}" class="img-fluid rounded" style="width: 60px; height: 60px; object-fit: cover;" alt="${orderDetail.product.name}">
                                    </td>
                                    <td>
                                        <a href="/product/${orderDetail.product.id}" target="_blank" class="text-dark">${orderDetail.product.name}</a>
                                    </td>
                                    <td>
                                        <fmt:formatNumber type="number" value="${orderDetail.price}"/> $
                                    </td>
                                    <td>${orderDetail.quantity}</td>
                                    <td>
                                        <fmt:formatNumber type="number" value="${orderDetail.price * orderDetail.quantity}"/> $
                                    </td>
                                    <td>${order.status}</td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="../layout/footer.jsp"/>
    
    <div class="container-fluid copyright bg-dark py-4">
        <div class="container text-center text-light">
            <span>&copy; Your Site Name, All rights reserved.</span>
        </div>
    </div>

    <!-- Back to Top Button -->
    <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top">
        <i class="fa fa-arrow-up"></i>
    </a>

    <!-- Scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/client/lib/easing/easing.min.js"></script>
    <script src="/client/lib/waypoints/waypoints.min.js"></script>
    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="/client/js/main.js"></script>
</body>

</html>