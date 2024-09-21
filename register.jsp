<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Error</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f4f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* Styling for the container */
        .error-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 400px;
        }

        /* Header styling */
        h2 {
            color: #e74c3c;
            font-size: 24px;
            margin-bottom: 20px;
        }

        /* Paragraph and Link styling */
        p {
            font-size: 16px;
            color: #555;
        }

        .register-link {
            color: #3498db;
            font-weight: bold;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .register-link:hover {
            color: #2980b9;
        }

        /* Button styling */
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .back-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>


    <div class="error-container">
        <h2>Oops!</h2>
        <p>It looks like the email doesn't have an account with us.</p>
        <p><a href="register.html" class="register-link">Click here to register</a></p>
        <button class="back-btn" onclick="history.back()">Go Back</button>
    </div>


</body>
</html>
