<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Article</title>
<style>
/* Style pour le corps de la page */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    padding: 0; 
    background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
    background-size: cover;
    background-position: center;
}
h1 {
    text-align: center;
    color: #333;
}
p {
    text-align: center;
    margin-top: 20px;
    color: #777;
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
form {
    width: 80%;
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #adaf5566;
    border-radius: 10px;
    margin-top: 50px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
input[type="number"],
textarea,
input[type="text"],
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}
</style>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/UserArticle" method="post">
        <h1>Edit Article</h1>
        <input type="hidden" name="articleId" value="${article.idArticle}" />
        <input type="hidden" name="existingPhoto" value="${article.photo}" />
        
        <label for="nomArticle">Article Name:</label>
        <input type="text" id="nomArticle" name="nomArticle" value="${article.nomArticle}" required>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" required>${article.description}</textarea>
        
        <label for="prix">Price:</label>
        <input type="number" id="prix" name="prix" step="0.01" value="${article.prix}" required>
        
        <label for="etat">Condition:</label>
        <select id="etat" name="etat" required>
            <option value="new" ${article.etat == 'new' ? 'selected' : ''}>nouveau</option>
            <option value="used" ${article.etat == 'used' ? 'selected' : ''}>Occassion</option>
        </select>
        
        <label for="categorie">Category:</label>
        <input type="text" id="categorie" name="categorie" value="${article.categorie}" required>
        
        <label for="qteStock">Stock Quantity:</label>
        <input type="number" id="qteStock" name="qteStock" value="${article.qteStock}" required>
        
        <label for="photo">Photo URL:</label>
        <input type="text" id="photo" name="photo" value="${article.photo}">
        
        <button type="submit">Save Changes</button>
    </form>
</div>
</body>
</html>
