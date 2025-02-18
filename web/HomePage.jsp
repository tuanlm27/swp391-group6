<%-- 
    Document   : HomePage
    Created on : Feb 18, 2025, 3:46:05 PM
    Author     : tovie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movie"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie List</title>
    </head>
    <body>
        <h1>Movie List</h1>
        <table border="1">
            <tr>
                <th>Movie ID</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Duration</th>
                <th>Release Date</th>
                <th>Description</th>
            </tr>
            <%
                List<Movie> movies = (List<Movie>) request.getAttribute("movies");
                if (movies != null) {
                    for (Movie movie : movies) {
            %>
            <tr>
                <td><%= movie.getMovieID() %></td>
                <td><%= movie.getTitle() %></td>
                <td><%= movie.getGenre() %></td>
                <td><%= movie.getDuration() %></td>
                <td><%= movie.getReleaseDate() %></td>
                <td><%= movie.getDescription() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
