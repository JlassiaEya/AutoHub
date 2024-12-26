<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter Article</title>
 <jsp:include page="Header.jsp" />

</head>
 <style>/* Style pour le corps de la page */
/* style.css */

/* Styles communs aux deux pages */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    padding: 0; 
    background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
    background-size: cover; /* Pour que l'image couvre toute la zone du corps */
    background-position: center; /* Pour centrer l'image */
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
            width: 80%; /* Définition de la largeur du formulaire à 80% */
            max-width: 400px; /* Largeur maximale pour assurer la lisibilité */
            margin: 0 auto; /* Centrage du formulaire */
            padding: 20px;
            background-color: #adaf5566;
            border-radius: 10px;   margin-top: 50px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }/* CSS pour les input */
#telephone,#nomArticle,#categorie,
input[type="number"],
textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

/* CSS pour les select */
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #fff;
    /* Autres styles selon vos besoins */
}
        
 </style>
<body>
    
   <form action="Article" method="post">
   <h1>Ajouter un Article</h1>
    <label for="nomArticle">Nom de l'article:</label><br>
    <input type="text" id="nomArticle" name="nomArticle"><br>
    
    <label for="categorie">Categorie:</label><br>
    <input type="text" id="categorie" name="categorie"><br>
    
    <label for="description">Description:</label><br>
    <textarea id="description" name="description"></textarea><br>
    
    <label for="prix">Prix:</label><br>
    <input type="number" id="prix" name="prix" step="0.01"><br>
    
    <label for="etat">État:</label><br>
   <select id="etat" name="etat">
    <option value="Neuf">Neuf</option>
    <option value="Occasion">Occasion</option>
    <option value="Reconditionné">Reconditionné</option>
    <option value="En Promotion">En Promotion</option>
    <!-- Ajoutez d'autres options selon vos besoins -->
</select><br>

    
    <label for="telephone">Téléphone:</label><br>
    <input type="text" id="telephone" name="telephone"><br>
    
    <label for="photo">Photo:</label><br>
    <textarea  id="photo" name="photo"></textarea><br>
    
    <label for="qteStock">Quantité de Stock:</label><br>
    <input type="number" id="qteStock" name="qteStock"><br>
    
    <p>        
    <button type="submit" value="Ajouter">Ajouter</button></p>
</form>
</body>
</html>
