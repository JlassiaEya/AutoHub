<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #ffffff;
            margin: 0;
            padding: 0; 
            background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
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
        }

        a:hover {
            color: #75360f;
            text-decoration: underline;
        }
    </style>
     <jsp:include page="Head.jsp" />
    
</head>
<body>


    
    <form action="Login" method="post">
        <h2>Login</h2>
        <div>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>

    <div>
        <p>Don't have an account? <a href="Register">Register here</a></p>
    </div>
</body>
</html>
