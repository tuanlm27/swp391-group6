<%-- 
    Document   : HomePage
    Created on : Feb 19, 2025, 3:25:57 PM
    Author     : tovie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            .navbar {
                background-color: #333;
                overflow: hidden;
            }
            .navbar a {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 14px 20px;
                text-decoration: none;
            }
            .navbar a:hover {
                background-color: #ddd;
                color: black;
            }
            .navbar .right {
                float: right;
            }
            .banner {
                width: 100%;
                height: 500px;
                position: relative;
                overflow: hidden;
            }
            .banner img {
                width: 100%;
                height: 100%;
                position: absolute;
                top: 0;
                left: 0;
                opacity: 0;
                transition: opacity 1s ease-in-out;
            }
            .banner img.active {
                opacity: 1;
            }
            .posters {
                display: flex;
                justify-content: center;
                flex-wrap: wrap;
                padding: 20px;
            }
            .poster {
                margin: 10px;
                width: 200px;
                height: 300px;
                background-size: cover;
                background-position: center;
            }
        </style>
        <script>
            let currentIndex = 0;
            function showNextImage() {
                const images = document.querySelectorAll('.banner img');
                images[currentIndex].classList.remove('active');
                currentIndex = (currentIndex + 1) % images.length;
                images[currentIndex].classList.add('active');
            }
            setInterval(showNextImage, 3000);
        </script>
    </head>
    <body>
        <div class="navbar">
            <a href="#home">Home</a>
            <a href="#movies">Movies</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <div class="right">
                <a href="login.jsp">Login</a> <!-- Chuyển hướng đến login.jsp -->
                <a href="#register">Register</a>
            </div>
        </div>
        <div class="banner">
            <img src="images banner quảng cáo/banner1.jpg" class="active">
            <img src="images banner quảng cáo/banner2.jpg">
            <img src="images banner quảng cáo/banner3.jpg">
            <img src="images banner quảng cáo/banner4.jpg">
            <img src="images banner quảng cáo/banner5.jpg">
        </div>
        <div class="posters">
            <div class="poster" style="background-image: url('images poster/phim1.jpg');"></div>
            <div class="poster" style="background-image: url('images poster/phim2.jpg');"></div>
            <div class="poster" style="background-image: url('images poster/phim3.jpg');"></div>
            <div class="poster" style="background-image: url('images poster/phim4.jpg');"></div>
            <div class="poster" style="background-image: url('images poster/phim5.jpg');"></div>
        </div>
    </body>
</html>
