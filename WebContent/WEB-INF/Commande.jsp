<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Commande Page</title>
     <jsp:include page="Headdd.jsp" />
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

h2 {
    text-align: center;
    color: #333;
    margin-top: 50px;
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
            margin-top:50px;
            padding: 20px;
            background-color: #adaf5566;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
 /* CSS pour les input */
#nom,#email,#prenom,#adresse,#total,
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
    
    
</head>
<body>
<form action="Commande" method="post">
    <h2>Vente des articles</h2>
    
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" required><br><br>
    
    <label for="prenom">Prenom :</label>
    <input type="text" id="prenom" name="prenom" required><br><br>
   
    <label for="adresse">Adresse :</label>
    <input type="text" id="adresse" name="adresse" required><br><br>
    
    <label for="total">Total du panier :</label>
    <input type="text" id="total" name="total" value="${totalCart}" readonly><br><br>
    
    <button type="submit" value="Acheter">Acheter</button>
</form>
</body>
</html>
