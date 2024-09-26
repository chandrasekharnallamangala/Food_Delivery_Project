<%@page import="java.util.ArrayList"%>
<%@page import="com.project.Model.Restaurant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tasty Bites - Home</title>
    <style>
        /* Global styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9; /* Light background for a clean feel */
            margin: 0;
            padding: 0;
        }

        /* Header styles */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #ff7043; /* Warm orange for header background */
            padding: 20px 40px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Soft shadow for depth */
        }

        .header h1 {
            font-family: 'Georgia', serif;
            font-size: 40px;
            margin: 0;
            color: #fff; /* White text for the app name */
            letter-spacing: 2px; /* Slight letter spacing for elegance */
        }

        /* Navigation styles */
        .nav {
            display: flex;
            gap: 30px;
        }

        .nav a {
            color: #ffffff; /* White text for links */
            text-decoration: none;
            font-size: 18px;
            font-family: 'Verdana', sans-serif;
            font-weight: bold;
            padding: 5px 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .nav a:hover {
            background-color: #ffffff; /* On hover, background turns white */
            color: #ff7043; /* Text turns orange on hover */
        }

        /* Content styling */
        .content {
            text-align: center;
            padding: 80px 20px;
            background-color: #ffffff; /* White background for content area */
            color: #333; /* Dark grey for clean and readable text */
        }

        /* Card container styling */
        .card-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); /* Responsive columns */
            gap: 20px;
            padding: 20px;
        }

        /* Card styling */
        .card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            transition: transform 0.3s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        /* Individual card item styling */
        .card-item {
            margin-bottom: 10px;
            color: #555;
        }

        .card-item strong {
            color: #333;
        }

        .card h2 {
            font-size: 22px;
            margin-bottom: 15px;
            color: #ff7043;
        }

        .card p {
            margin: 5px 0;
            font-size: 16px;
        }

        /* Footer styles */
        .footer {
            background-color: #333; /* Dark footer for contrast */
            color: #ffffff; /* White text in the footer */
            text-align: center;
            padding: 20px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        .footer p {
            margin: 0;
            font-size: 14px;
        }

    </style>
</head>
<body>

    <!-- Header section with the application name and navigation links -->
    <div class="header">
        <h1>Tasty Bites</h1>
        <div class="nav">
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Register</a>
        </div>
    </div>

    <!-- Main content area -->
    <div class="content">
        <h2>Restaurant Details</h2>

        <!-- Card container for restaurant details -->
        <div class="card-container">
            <%
                ArrayList<Restaurant> restlist = (ArrayList<Restaurant>)session.getAttribute("restList");
                if (restlist != null) {
                    for(Restaurant res : restlist) {
            %>
                <!-- Each restaurant displayed as a card -->
                <div class="card">
                    <h2><%= res.getName() %></h2>
                    <p class="card-item"><strong>Restaurant ID:</strong> <%= res.getRestaurant_Id() %></p>
                    <p class="card-item"><strong>Cuisine Type:</strong> <%= res.getCuisine_type() %></p>
                    <p class="card-item"><strong>Delivery Time:</strong> <%= res.getDelivery_Time() %> minutes</p>
                    <p class="card-item"><strong>Rating:</strong> <%= res.getRating() %>/5</p>
                </div>
            <%
                    }
                } else {
            %>
                <p>No restaurants available to display.</p>
            <%
                }
            %>
        </div>
    </div>

    <!-- Footer section -->
    <div class="footer">
        <p>&copy; 2024 Tasty Bites. All Rights Reserved.</p>
    </div>

</body>
</html>
