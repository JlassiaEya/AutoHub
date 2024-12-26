<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #ffffff;
            margin: 0;
            padding: 0; background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
    background-size: cover; /* Pour que l'image couvre toute la zone du corps */
    background-position: center; /* Pour centrer l'image */
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 50px; /* Ajout d'un espacement au-dessus du titre */
        }

        form {
            width: 80%; /* Définition de la largeur du formulaire à 80% */
            max-width: 400px; /* Largeur maximale pour assurer la lisibilité */
            margin: 0 auto; /* Centrage du formulaire */
            padding: 20px;
            background-color: #adaf5566;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);    
            margin-top:50px;
            
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: black;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
            color: #777;
        }

      a {
    color: #8a8178;
    text-decoration: none;
    text-align: center; /* Ajout de la propriété pour centrer le texte */
    display: block; /* Pour que le lien occupe toute la largeur disponible */
    margin-top: 20px; /* Ajout d'une marge au-dessus du lien */
}

a:hover {
    color: #75360f;
    text-decoration: underline;
}

    </style>
    <jsp:include page="Head.jsp" />
</head>
<body>
<form action="Register" method="post"><h2>Register</h2>

    <label for="username">Username:</label>
    <input type="text" id="username" name="username">

    <label for="email">Email:</label>
    <input type="email" id="email" name="email">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password">

    <button type="submit">Register</button>
</form>

<a href="Login" class="login-link">Login Page</a>
</body>
</html>
