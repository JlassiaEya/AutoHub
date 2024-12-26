<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>/* Reset CSS */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Global styles */

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 20px;
}

/* Header styles */
header {
    background-color: #333;
    color: #fff;
    padding: 20px 0;
}

.nav {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.logo {
    color: #fff;
    font-size: 24px;
    text-decoration: none;
}

.logo span {
    font-weight: bold;
}

.navbar {
    list-style-type: none;
    display: flex;
}

.navbar li {
    margin: 0 10px;
}

.navbar li a {
    color: #fff;
    text-decoration: none;
    transition: color 0.3s ease;
}

.navbar li a:hover {
    color: #ffd700;
}

.dropdown {
    position: relative;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #333;
    min-width: 120px;
    z-index: 1;
}

.dropdown-content a {
    color: white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown:hover .dropdown-content {
    display: block;
}

/* Search box styles */
.search-box {
    margin-left: auto;
}

.search-box input[type="text"] {
    padding: 8px;
    border: none;
    border-radius: 5px;
}

.search-box input[type="submit"] {
    padding: 8px 16px;
    border: none;
    border-radius: 5px;
    background-color: #ffd700;
    color: #333;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.search-box input[type="submit"]:hover {
    background-color: #ffcc00;
}
.navbar li {
    margin-right: 20px; /* Ajoutez la marge désirée entre les éléments li */
}
.logo {
    margin-right: 20px;
    order: -1; /* Le logo est placé en premier */
}

</style>
</head>
<body>
<header>
    <div class="nav container">
        <!--Menu icon-->
        <i class='bx bx-menu' id="menu-icon"></i>
        <a href="Page1" class="logo">Auto<span>Hub</span></a>
        <ul class="navbar">
                    <li><a href="Login">Login</a></li>
                    <li><a href="Register">Register</a></li>
        
            <li><a href="about">About</a></li>
            <li><a href="contact">Contact-us</a></li>   
     
         </ul></div>
</header>
</body>
</html>