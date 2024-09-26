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
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        /* Header styles */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #ff7043;
            padding: 20px 40px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .header h1 {
            font-family: 'Georgia', serif;
            font-size: 40px;
            margin: 0;
            color: #fff;
            letter-spacing: 2px;
        }

        /* Right section for profile and cart dropdowns */
        .header-right {
            display: flex;
            align-items: center;
        }

        /* Dropdown common styles */
        details {
            position: relative;
        }

        summary {
            list-style: none;
            cursor: pointer;
        }

        summary::-webkit-details-marker {
            display: none;
        }

        details[open] .dropdown-content {
            display: block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #ffffff;
            min-width: 200px;
            max-width: 300px;
            box-shadow: 0px 8px 16px rgba(0,0,0,0.2);
            z-index: 1;
            padding: 15px;
            border-radius: 5px;
            right: 0;
        }

        /* Profile details */
        .user-dropdown .initial {
            width: 50px;
            height: 50px;
            background-color: #42a5f5;
            color: white;
            font-size: 24px;
            font-weight: bold;
            text-align: center;
            line-height: 50px;
            border-radius: 50%;
            cursor: pointer;
        }

        .dropdown-content p {
            margin: 5px 0;
            font-size: 16px;
            color: #333;
        }

        /* Cart styles */
        .cart-dropdown {
            position: relative;
            display: inline-block;
        }

        .cart-icon {
            font-size: 24px;
            color: white;
            cursor: pointer;
            padding: 10px;
        }

        .cart-dropdown-content {
            display: none;
            position: absolute;
            background-color: #ffffff;
            padding: 15px;
            box-shadow: 0px 8px 16px rgba(0,0,0,0.2);
            border-radius: 5px;
            z-index: 1;
            min-width: 200px;
            right: 0;
        }

        details[open] .cart-dropdown-content {
            display: block;
        }

        /* Content styling */
        .content {
            text-align: center;
            padding: 80px 20px;
            background-color: #ffffff;
            color: #333;
        }

        .card-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            padding: 20px;
        }

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

        .card button {
            background-color: #ff7043;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
            font-size: 16px;
        }

        .card button:hover {
            background-color: #ff5722;
        }

        .footer {
            background-color: #333;
            color: #ffffff;
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

        /* Add space between dropdowns */
        .header-right details {
            margin-left: 20px; /* Add space between the dropdowns */
        }
    </style>
</head>
<body>

    <!-- Header section with the application name and user details -->
    <div class="header">
        <h1>Tasty Bites</h1>

        <!-- Right section for profile and cart dropdowns -->
        <div class="header-right">
            <!-- User profile dropdown section -->
            <details class="user-dropdown">
                <summary>
                    <div class="initial">
                        <%
                            String email = (String) session.getAttribute("email");
                            if (email != null && !email.isEmpty()) {
                                out.print(email.substring(0, 1).toUpperCase());
                            } else {
                                out.print("U");
                            }
                        %>
                    </div>
                </summary>
                <div class="dropdown-content">
                    <p>Hey, <%
                        String name = (String) session.getAttribute("user_name");
                        out.print(name != null ? name : "Guest");
                    %>!</p>
                    <p><strong>Email:</strong> <%= session.getAttribute("email") %></p>
                    <p><strong>Address:</strong> <%= session.getAttribute("address") %></p>
                </div>
            </details>

            <!-- Cart dropdown section -->
            <details class="cart-dropdown">
                <summary class="cart-icon">
                    🛒 Cart
                </summary>
                <div class="cart-dropdown-content">
                    <p>Total: <strong><%= session.getAttribute("total") != null ? session.getAttribute("total") : "0" %></strong></p>
                </div>
            </details>
        </div>
    </div>

    <!-- Main content area -->
    <div class="content">
        <div class="card-container">
            <%
                ArrayList<Restaurant> restlist = (ArrayList<Restaurant>) session.getAttribute("restList");
                if (restlist != null) {
                    for (Restaurant res : restlist) {
            %>
                <div class="card">
                    <h2><%= res.getName() %></h2>
                    <p><strong>Restaurant ID:</strong> <%= res.getRestaurant_Id() %></p>
                    <p><strong>Cuisine Type:</strong> <%= res.getCuisine_type() %></p>
                    <p><strong>Delivery Time:</strong> <%= res.getDelivery_Time() %> minutes</p>
                    <p><strong>Rating:</strong> <%= res.getRating() %>/5</p>
                    <a href="MenuServlet?id=<%= res.getRestaurant_Id() %>">
                        <button type="submit">View Menu</button>
                    </a>
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
