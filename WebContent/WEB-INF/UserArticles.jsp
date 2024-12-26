<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vos Articles</title>
<style>
     body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
            background-size: cover; /* Pour que l'image couvre toute la zone du corps */
            background-position: center; /* Pour centrer l'image */
        }
    /* Utilisation de la grille pour positionner les articles */
    #articlesList {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(375px, 1fr));
        grid-gap: 30px;
        list-style-type: none;
        padding: 0;
        margin-top: 50px;
        margin-left: 75px;
        margin-right: 75px;
       
    }
 .message {
        text-align: center;
        margin-top: 20px;
        color: #666;
    }
    .article-details {
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #adaf5566;
        padding: 20px;
        
    }

    .article-details h2 {
        margin-top: 0;
        font-size: 24px;
        color: #333;
    }

    .article-details img {
        max-width: 100%;
        height: auto;
        margin-bottom: 10px;
    }

    .article-details p {
        margin: 0;
        color:#ffffff;
    }

    .article-details .user-details {
        margin-top: 10px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f7f7f7;
    }

    .article-details form {
        margin-top: 5px;
    }

    .article-details input[type="number"] {
        width: 60px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    .article-details button {
       background-color: #8a8178;
       color: #ffffff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
.dropdown-content ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
}

.dropdown-content ul li {
    display: inline-block;
    margin-right: 10px; /* Espacement entre les boutons */
}

.dropdown-content ul li a {
    display: inline-block;
    padding: 8px 12px; /* Ajustez selon votre préférence */
    background-color: #8a8178;
    color: #ffffff;
    text-decoration: none;
    border-radius: 20px; /* Pour rendre les boutons arrondis */
}

.dropdown-content ul li a:hover {
    background-color: #6f6660; /* Couleur au survol */
}
.dropdown-content {
    margin-top: 20px;
    display: flex;
    justify-content: center; /* Centre horizontalement */
    align-items: center; /* Centre verticalement */
}

   

    .no-items {
        color: #666;
    }h1 {
        text-align: center;
        color: #333;
    }  table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            
        }
        th{ background-color: #adaf5566;}

        thead {
            background-color: #ddd;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

      
        button[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #8a8178;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #75360f;
        }
</style>
</head>
<body>
<jsp:include page="Header.jsp" />
    <div class="container">
        <h1>Vos Articles</h1>
        <c:if test="${not empty message}">
            <p class="message">${message}</p>
        </c:if>
        <c:if test="${not empty articles}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Nom de l'article</th>
                        <th>Description</th>
                        <th>Prix</th>
                        <th>Date de Publication</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="article" items="${articles}">
                        <tr>
                            <td>${article.nomArticle}</td>
                            <td>${article.description}</td>
                            <td>${article.prix}</td>
                            <td>${article.datePublication}</td>
                            <td>
                                <form method="post" action="${pageContext.request.contextPath}/UserArticle">
                                    <input type="hidden" name="articleId" value="${article.idArticle}" />
                                    <input type="hidden" name="action" value="delete" />
                                    <button type="submit" class="btn btn-danger">Supprimer</button>
                                </form>
                              <form method="get" action="${pageContext.request.contextPath}/EditArticle">
                                    <input type="hidden" name="articleId" value="${article.idArticle}" />
                                    <button type="submit" class="btn btn-primary">Modifier</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
