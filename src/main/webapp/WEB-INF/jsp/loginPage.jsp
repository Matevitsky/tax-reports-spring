<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <title>Login Page</title>

    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/local.css"/>

    <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>


</head>
<body>

<div class="row">

    <div class="col-lg-12 text-center v-center">

        <h1>Tax Reports</h1>
        <p class="lead">Enter your email and password for login</p>

        <br>
        <br>


        <form class="col-lg-12" action="/login" method="post">
            <div class="input-group" style="width: 340px; text-align: center; margin: 0 auto;">
                <input class="form-control input-lg" name="username" id="username"
                       placeholder="Enter your email address"
                       type="text"> <span id="loginValid"></span>
            </div>
            <br>
            <div class="input-group" style="width: 340px; text-align: center; margin: 0 auto;">
                <input class="form-control input-lg" name="password" id="password"
                       placeholder="Enter your password"
                       type="text">

            </div>
            <br>

            <div class="input-group" style="width: 340px; text-align: center; margin: 0 auto;">
                <input type="submit" firstName="login-submit" id="login-submit" tabindex="4"
                       class="btn btn-primary btn-lg btn-block" value="Log In/Войти"
                       disabled>
            </div>
            <br>


            <a href="../jsp/RegistrationPage.jsp">Don't have an account? Sign up</a>


            <script src="/js/loginEmailValidation.js"></script>
        </form>
    </div>
</div>


</body>
</html>
