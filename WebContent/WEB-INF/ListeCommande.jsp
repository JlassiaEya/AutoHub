<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panier</title>
    <jsp:include page="Header.jsp" />
    <style>/* styles.css */
       
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0; 
            background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
            background-size: cover; /* Pour que l'image couvre toute la zone du corps */
            background-position: center; /* Pour centrer l'image */
        }

        h1 {
            color: #333;
        }
        input[type="hidden"],{
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        table {
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

        p {
            text-align: center;
            margin-top: 20px;
            color: #fffff;
        }

        a {
            color: #8a8178;
            text-decoration: none;
        }

        a:hover {
            color: #75360f;
            text-decoration: underline;
        }
        form {
            width: 80%; /* Définition de la largeur du formulaire à 80% */
            max-width: 600px; /* Largeur maximale pour assurer la lisibilité */
            margin: 0 auto; /* Centrage du formulaire */
           margin-top:50px;
            padding: 20px;
            background-color: #adaf5566;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
 <form method="post">
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Adresse</th>
        <th>Date Commande</th>
    </tr>
    <c:forEach var="commande" items="${commandes}">
        <tr>
            <td>${commande.id}</td>
            <td>${commande.nom}</td>
            <td>${commande.prenom}</td>
            <td>${commande.adresse}</td>
            <td>${commande.dateCommande}</td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
