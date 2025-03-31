<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<!DOCTYPE html>
<html>
    
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url("/images/lienhe/background1.png") no-repeat center center fixed;
            background-size: cover;
            font-family: Arial, sans-serif;
        }
        .register-container {
            background: #e7a3a5;
            padding: 30px;
            border-radius: 15px;
            color: white;
            width: 420px;
            text-align: center;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
        }
        /* #2c3e50; */
        .form-control {
            margin-bottom: 15px;
            padding: 12px;
            border-radius: 8px;
        }
        .btn-submit {
            background-color: #28a745;
            color: white;
            padding: 12px;
            font-size: 16px;
            border-radius: 8px;
        }
        .btn-submit:hover {
            background-color: #218838;
        }
        h2 {
            font-size: 26px;
            margin-bottom: 10px;
        }
        p {
            font-size: 14px;
            margin-bottom: 20px;
        }
        a{
            font-weight: bold;
        }
        a:hover {
            color: #00ffcc !important;
            text-decoration: underline ;
            
        }
    </style>
    <script> 
        $(document).ready(() => { 
            const avatarFile = $("#avatarFile"); 
            avatarFile.change(function (e) { 
                const imgURL = URL.createObjectURL(e.target.files[0]); 
                $("#avatarPreview").attr("src", imgURL); 
                $("#avatarPreview").css({ "display": "block" }); 
            }); 
        }); 
    </script>
</head>
<body>
    <div class="register-container">
        <h2>Register</h2>
        <p>Đăng kí ngay nào!</p>
        <form:form action="/register" method="post" modelAttribute="registerUser"  enctype="multipart/form-data">
            <c:set var="errorPassword"> 
                <form:errors path="confirmPassword" cssClass="invalid-feedback" /> 
            </c:set> 
            <c:set var="errorEmail"> 
                <form:errors path="email" cssClass="invalid-feedback" /> 
            </c:set> 
            <c:set var="errorFirstName"> 
                <form:errors path="firstName" cssClass="invalid-feedback" /> 
            </c:set> 
        
            <!-- Hàng chứa Firstname & Lastname -->
            <div class="d-flex mb-3">
                <div class="w-50 me-1">
                    <form:input type="text" class="form-control ${not empty errorFirstName ? 'is-invalid':''}" 
                                placeholder="Firstname" path="firstName"/>
                    ${errorFirstName}
                </div>
                <div class="w-50 ms-1">
                    <form:input type="text" class="form-control" placeholder="Lastname" path="lastName"/>
                </div>
            </div>
        
            <!-- Email -->
            <div class="mb-3">
                <form:input type="email" class="form-control ${not empty errorEmail ? 'is-invalid':''}" 
                            placeholder="Email address" path="email"/>
                ${errorEmail}
            </div>
        
            <!-- Password -->
            <div class="mb-3">
                <form:input type="password" class="form-control ${not empty errorPassword ? 'is-invalid':''}"  
                            placeholder="Password" path="password"/>
                            ${errorPassword}
            </div>
        
            <!-- Confirm Password -->
            <div class="mb-3">
                <form:input type="password" class="form-control ${not empty errorConfirmPassword ? 'is-invalid':''}"  
                            placeholder="Confirm password" path="confirmPassword"/>
                
            </div>

            <div class="row g-3">
                <div class="col">
                <div class="mb-3">
                  <label class="form-label">Role:</label>
                  <form:select class="form-select" path = "role.name">
              

                    <form:option value="ADMIN">ADMIN</form:option>
                    <form:option value="USER">USER</form:option>
                    
                  </form:select>
                </div>
                </div>
                <div class="col">
                <div class="mb-3">
                  <label for="avatarFile" class="form-label">Avatar:</label>
                  <input class="form-control" type="file" id="avatarFile"
                  
                   accept=".png, .jpg, .jpeg"
                   name="laithuyFile"
                    />
                   
                </div>
                <div class="col-12 mb-3">
                  <img style="max-height: 250px; display: none;" alt="avatar preview"
                  id="avatarPreview"/>

                </div>
                </div>
                </div>
            <button type="submit" class="btn btn-submit w-100">Create Account</button>
        </form:form>
        
    
        <p class="mt-3">Already have an account?    <a href="/login" class="text-white">Login</a></p>
    </div>
</body>
</html>
