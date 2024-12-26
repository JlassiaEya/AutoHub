<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
/* Reset CSS */
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
    background-color: #75360f;
    color: #ffffff;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.search-box input[type="submit"]:hover {
    background-color:#f4b188;
}

.navbar li {
    margin-right: 20px; /* Ajoutez la marge désirée entre les éléments li */
}

.logo {
    margin-right: 20px;
    order: -1; /* Le logo est placé en premier */
} 
.img {
    width: 40px;
    height: 40px;
    border-radius: 50%; 
    float: right;
}


</style>
<script>
    function search() {
        var searchText = document.getElementById("searchInput").value.toLowerCase();
        var articles = document.querySelectorAll(".article-details");

        articles.forEach(function(article) {
            var name = article.dataset.name.toLowerCase(); // Récupérer le nom de l'article
            if (name.includes(searchText)) {
                article.style.display = "block"; // Afficher l'article s'il correspond à la recherche
            } else {
                article.style.display = "none"; // Masquer l'article s'il ne correspond pas à la recherche
            }
        });
    }
</script>
</head>
<body>
<header>
    <div class="nav container">
        <!--Menu icon-->
        <i class='bx bx-menu' id="menu-icon"></i>
        <a href="Page1" class="logo">Auto<span>Hub</span></a>
        <ul class="navbar">
            <li><a href="about">About</a></li>
            <li><a href="contact">Contact</a></li>   
            <li><a href="Home1" class="active">Home</a></li>         
        </ul>
        <div class="search-box">
            <input type="text" placeholder="Search..." name="search" id="searchInput">
            <input type="submit" value="Search" onclick="search()">
        </div>
    </div>
</header>

<div class="container">
    <c:choose>
        <c:when test="${not empty articlesByCategory}">
            <c:forEach var="articleCategoryEntry" items="${articlesByCategory}">
                <c:if test="${articleCategoryEntry.key eq categoryFilter}">
                    <ul>
                        <c:forEach var="article" items="${articleCategoryEntry.value}">
                          
                        </c:forEach>
                    </ul>
                </c:if>
            </c:forEach>
        </c:when>
    </c:choose>
    
    <script>
    function search() {
        var searchText = document.getElementById("searchInput").value.toLowerCase();
        var articles = document.querySelectorAll(".article-details");

        var found = false; // Flag to indicate if any matching articles are found

        articles.forEach(function(article) {
            var name = article.dataset.name ? article.dataset.name.toLowerCase() : ''; // Check if dataset.name exists
            if (name.includes(searchText)) {
                article.style.display = "block"; // Display the article if it matches the search
                found = true; // Set found to true if a match is found
            } else {
                article.style.display = "none"; // Hide the article if it doesn't match the search
            }
        });

        if (!found) {
            // If no matching articles are found, you can redirect to a separate page or display a message
            // Here, let's redirect to a page named 'NoResults.jsp'
            window.location.href = 'NoRes';
        }
    }

</script>
    
</div>
</body>
</html>
