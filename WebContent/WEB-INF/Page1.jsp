<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
    <jsp:include page="Head.jsp" />
</head>
<body>
    <style>
        /* Styles spécifiques au conteneur des boutons */
        .button-container {
            text-align: center; /* Centrer horizontalement son contenu */
            margin-top: 300px;
        }
 body {
            font-family: 'Times New Roman', Times, serif;
            background-image: url('https://media.istockphoto.com/id/927781468/fr/photo/carrosserie-de-la-voiture-d%C3%A9mont%C3%A9e-et-de-nombreuses-pi%C3%A8ces-de-v%C3%A9hicules.jpg?s=612x612&w=0&k=20&c=v2ptRLLytSryV9jY8eokM-q7HkQ0GDei8l1egAGQuBY=');
            background-repeat: no-repeat;
            background-size: cover; /* Pour couvrir toute la page */
            object-fit:cover;
            color: #bb7449db;
            margin: 0;
            padding: 0;
        }


        /* Styles spécifiques aux boutons */
        .button-container a {
            font-family: 'Times New Roman', Times, serif;
            background-color: #8a8178;
            color: #ffffff;
            padding: 15px 30px;
            font-size: 2em; /* Taille de police augmentée */
            border: none;
            cursor: pointer;
            box-shadow: 10px 15px 15px rgba(15, 15, 15, 0.3);
            border-radius: 7px;
            margin-left: 15px; /* Espace entre les boutons */
            text-decoration: none; /* Supprimer le soulignement du lien */
            transition: background-color 0.3s ease, transform 0.3s ease-in-out;
        }

        .button-container a:hover {
            background-color: #75360f;
            transform: scale(1.05);
        }
         blockquote {
           font-style: italic;
            color: #333;   
            margin: 20px auto;
            width: 50%; /* Largeur du bloc de citation */
            padding: 20px; /* Espace intérieur */
            background-color: #f7f7f7; /* Couleur de fond */
        }
    </style>

    <div class="button-container">
        <a href="Home1">Client</a>
        <a href="Login">Vendeur</a>
    </div>

   
</body>
</html>
