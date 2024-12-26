<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>About Us</title>
             <jsp:include page="Head.jsp" />
    <style>
   /* style.css */

/* Styles pour le corps de la page */
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    padding: 0; 
    background-image: url("https://img.freepik.com/vecteurs-libre/fond-pieces-voiture-images-realistes-disques-alliage-amortisseurs-volant-espace-vide_1284-53973.jpg");
    background-size: cover; /* Pour que l'image couvre toute la zone du corps */
    background-position: center; /* Pour centrer l'image */
}


.cont {
    width: 80%; /* Largeur de la container */
    max-width: 600px; /* Largeur maximale */
    margin: auto; /* Centrage horizontal */
    padding: 20px;
    background-color: #adaf5566;; /* Couleur de fond de la container */
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Ombre */
    
    /* Centrage vertical et horizontal */
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}


h1 {
    text-align: center;
    color: #333;
    margin-top: 50px;
}

p {
    margin-top: 20px;
    color: #0a0909;
}

a {
    color: #8a8178;
    text-decoration: none;
    display: block; /* Pour que le lien occupe toute la largeur disponible */
    margin-top: 20px; /* Ajout d'une marge au-dessus du lien */
    text-align: center; /* Centrer le texte */
}

a:hover {
    color: #75360f;
    text-decoration: underline;
}
    </style>
    
</head>
<body>
    <div class="cont">
        <h1>About Us</h1>
        <p>Welcome to Our App! We strive to provide you with the most comprehensive and up-to-date catalog of automotive components and spare parts.</p>
        <p>Our mission is to simplify the process of finding the right parts for your vehicle, ensuring a smooth and hassle-free experience.</p>
        <a href="Home">Back to Home</a>
    </div>
</body>
</html>
