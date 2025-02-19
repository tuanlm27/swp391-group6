<%-- 
    Document   : viewMovieDetail
    Created on : Feb 19, 2025, 1:38:23 PM
    Author     : tovie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movie"%>
<%
    Movie movie = (Movie) request.getAttribute("movie");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Details</title>
    </head>
    <body>
        <h1>Movie Details</h1>
        <% if (movie != null) { %>
            <p><strong>Title:</strong> <%= movie.getTitle() %></p>
            <p><strong>Genre:</strong> <%= movie.getGenre() %></p>
            <p><strong>Duration:</strong> <%= movie.getDuration() %> minutes</p>
            <p><strong>Release Date:</strong> <%= movie.getReleaseDate() %></p>
            <p><strong>Description:</strong> <%= movie.getDescription() %></p>
        <% } else { %>
            <p>Movie not found.</p>
        <% } %>
    </body>
</html>
