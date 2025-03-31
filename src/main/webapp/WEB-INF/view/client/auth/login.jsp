<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- <link rel="stylesheet" href="styles.css"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="login-container">
        <div class="login-card">
            <h2>Welcome Back</h2>
            <p>Login to continue</p>
            <form method="post" action="/login">
                <c:if test="${param.error != null}"> 
                    <div class="my-2" style="color: red;">Invalid email or password.</div> 
                    </c:if>

                    <c:if test="${param.logout != null}"> 
                    <div class="my-2" style="color: rgb(41, 193, 183);">Logout success!</div> 
                    </c:if>


                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input type="email" placeholder="Email" 
                    name="username"/>
                </div>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Password" 
                    name="password"/>
                </div>
                <div>
                    <input type="hidden" name="${_csrf.parameterName}" 
                    value="${_csrf.token}"/> 
                </div>
                

                <button type="submit" class="login-btn">Login</button>
                <p class="signup-text">Don't have an account? <a href="/register">Sign up</a></p>
            </form>
        </div>
    </div>
</body>
</html>

<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background: url("/images/lienhe/background1.png") no-repeat center center fixed;
        background-size: cover;
    }
    .login-container {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
    }
    .login-card {
        background: rgba(250, 222, 243, 0.956);
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 400px;
    }
    .login-card h2 {
        margin-bottom: 15px;
    }
    .login-card p {
        color: #666;
        margin-bottom: 25px;
    }
    .input-group {
        display: flex;
        align-items: center;
        background: #f9f9f9e4;
        padding: 12px;
        border-radius: 8px;
        margin-bottom: 20px;
    }
    .input-group i {
        margin-right: 12px;
        color: #888;
    }
    .input-group input {
        border: none;
        outline: none;
        background: none;
        flex: 1;
        font-size: 16px;
    }
    .login-btn {
        width: 100%;
        background: #3498db;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        font-size: 18px;
    }
    .login-btn:hover {
        background: #2980b9;
    }
    .signup-text {
        margin-top: 15px;
        font-size: 16px;
        color: #666;
    }
    .signup-text a {
        color: #3498db;
        text-decoration: none;
    }
    .signup-text a:hover {
        text-decoration: underline;
    }
</style>
