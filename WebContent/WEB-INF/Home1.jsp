<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Page Accueil</title>
 
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
        color:#fffff;
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
    }
</style>
 </head>
<body>
<jsp:include page="Headdd.jsp" />
<div class="dropdown-content">
    <ul>
        <c:if test="${not empty uniqueCategories}">
            <c:forEach var="category" items="${uniqueCategories}">
                <li><a href="Home1?category=${category}" class="all">${category}</a></li>
            </c:forEach>
        </c:if>
    </ul>
</div>


<ul id="articlesList">
    <c:choose>
        <c:when test="${empty articles}">
            <p>Aucun article n'est disponible.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="article" items="${articles}">
                <li class="article-details" data-categorie="${article.categorie}">
                    <h2>${article.nomArticle}</h2>
                     <img src="${article.photo}?width=440&height=248" alt="Photo de l'article">
                    <p>Prix : ${article.prix}DNT</p>
                    <p>Description : ${article.description}</p>
                    <p>État : ${article.etat}</p>
                    <p>Téléphone : ${article.telephone}</p>
                    <p>Date de publication : ${article.datePublication}</p>
                    <p>Catégorie : ${article.categorie}</p>
                    <p>Quantité de Stock: ${article.qteStock}</p>
                  <div class="user-details">
    <c:set var="userFound" value="false" />
    <c:forEach var="user" items="${usersP}">
        <c:if test="${user.id_user == article.idUser && !userFound}">
            <p>Nom de l'utilisateur : ${user.nom}</p>
            <p>Email de l'utilisateur : ${user.email}</p>
            <c:set var="userFound" value="true" />
        </c:if>
    </c:forEach>
</div>

                    <!-- Créer un formulaire pour chaque article -->
                    <form action="Home" method="post">
                        <!-- Champs cachés pour les informations de l'article -->
                        <input type="hidden" name="articleId" value="${article.idArticle}">
                        <input type="hidden" name="nomArticle" value="${article.nomArticle}">
                        <input type="hidden" name="prix" value="${article.prix}">
                        <!-- Champ pour la quantité -->
                        <input type="number" name="quantity" value="1" min="1" max="${article.qteStock}">
                        <!-- Bouton d'ajout au panier -->
                        <button type="submit">Ajouter Au Panier</button>
                    </form>
                </li>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</ul>

</body>
</html>