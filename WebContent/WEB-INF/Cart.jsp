<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panier</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
            background-size: cover;
            background-position: center;
        }

       h1{
    text-align: center;
    color: #333;
    margin-top: 50px;
}

        input[type="hidden"], {
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

        th {
            background-color: #adaf5566;
        }

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
            color: #fff;
        }

        .home-link {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 50px;
        margin-top: 20px;
    }

    .home-link a {
        text-decoration: none;
        font-size: 20px;
        color: #ffffff;
        background-color: #8a8178;
        padding: 10px 20px;
        border-radius: 5px;
    }

    .home-link a:hover {
        background-color: #75360f;
    }


        form {
            width: 80%;
            max-width: 600px;
            margin: 0 auto;
            margin-top: 50px;
            padding: 20px;
            background-color: #adaf5566;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
   <script>
    function deleteItem(articleId, articleTotal) {
        if (confirm('Voulez-vous vraiment supprimer cet article?')) {
            const xhr = new XMLHttpRequest();
            xhr.open('POST', 'CartServlet', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    const row = document.getElementById('row-' + articleId);
                    if (row) {
                        row.parentNode.removeChild(row);
                    }
                    const totalCartElement = document.getElementById('totalCart');
                    let currentTotal = parseFloat(totalCartElement.textContent);
                    totalCartElement.textContent = (currentTotal - articleTotal).toFixed(2);
                }
            };
            xhr.send('action=delete&articleId=' + articleId);
        }
    }
</script>

</head>
<body>
    <form method="post">
        <h1>Votre Panier</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Nom de l'article</th>
                    <th>Prix unitaire</th>
                    <th>Quantité</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart.items}" varStatus="status">
                    <tr id="row-${item.idArticle}">
                        <td>${item.nomArticle}</td>
                        <td>${item.prix}</td>
                        <td>${item.qteStock}</td>
                        <td>${item.prix * item.qteStock}</td>
                        <td>
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="articleId" value="${item.idArticle}">
                            <button type="button" onclick="deleteItem(${item.idArticle}, ${item.prix * item.qteStock})">Supprimer</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>Total du panier : <span id="totalCart">${totalCart}</span></p>
        <button type="submit">Ajouter un Commande</button>
    </form>
<div class="home-link">
    <a href="Home1">Page Acceuil</a>
</div></body>
</html>
