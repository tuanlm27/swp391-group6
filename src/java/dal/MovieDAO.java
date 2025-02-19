package dal;

import model.Movie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object for Movie
 * Handles database operations related to Movie
 */
public class MovieDAO extends DBContext {

    /**
     * Retrieves all movies from the database
     * @return List of Movie objects
     */
    public List<Movie> getAllMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movie";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getInt("MovieID"),
                        rs.getString("Title"),
                        rs.getString("Genre"),
                        rs.getInt("Duration"),
                        rs.getDate("ReleaseDate").toString(),
                        rs.getString("Description")
                );
                movies.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movies;
    }

    /**
     * Adds a new movie to the database
     * @param movie Movie object
     * @return true if the movie was added successfully, false otherwise
     */
    public boolean addMovie(Movie movie) throws Exception {
        String sql = "INSERT INTO Movie (Title, Genre, Duration, ReleaseDate, Description) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDuration());
            ps.setDate(4, Date.valueOf(movie.getReleaseDate()));
            ps.setString(5, movie.getDescription());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Retrieves a movie by ID
     * @param id Movie ID
     * @return Movie object
     */
    public Movie getMovieByID(int id) throws Exception {
        Movie movie = null;
        String sql = "SELECT * FROM Movie WHERE MovieID=?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    movie = new Movie(
                            rs.getInt("MovieID"),
                            rs.getString("Title"),
                            rs.getString("Genre"),
                            rs.getInt("Duration"),
                            rs.getDate("ReleaseDate").toString(),
                            rs.getString("Description")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movie;
    }

    /**
     * Retrieves movies by title
     * @param title Movie title
     * @return List of Movie objects
     */
    public List<Movie> getMoviesByTitle(String title) throws Exception {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movie WHERE Title LIKE ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + title + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie(
                            rs.getInt("MovieID"),
                            rs.getString("Title"),
                            rs.getString("Genre"),
                            rs.getInt("Duration"),
                            rs.getDate("ReleaseDate").toString(),
                            rs.getString("Description")
                    );
                    movies.add(movie);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movies;
    }

    /**
     * Retrieves movies by genre
     * @param genre Movie genre
     * @return List of Movie objects
     */
    public List<Movie> getMoviesByGenre(String genre) throws Exception {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movie WHERE Genre LIKE ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + genre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie(
                            rs.getInt("MovieID"),
                            rs.getString("Title"),
                            rs.getString("Genre"),
                            rs.getInt("Duration"),
                            rs.getDate("ReleaseDate").toString(),
                            rs.getString("Description")
                    );
                    movies.add(movie);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movies;
    }

    /**
     * Updates a movie in the database
     * @param movie Movie object
     * @return true if update was successful, false otherwise
     */
    public boolean updateMovie(Movie movie) throws Exception {
        String sql = "UPDATE Movie SET Title=?, Genre=?, Duration=?, ReleaseDate=?, Description=? WHERE MovieID=?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDuration());
            ps.setDate(4, Date.valueOf(movie.getReleaseDate()));
            ps.setString(5, movie.getDescription());
            ps.setInt(6, movie.getMovieID());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Deletes a movie from the database
     * @param id Movie ID
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteMovie(int id) throws Exception {
        String sql = "DELETE FROM Movie WHERE MovieID=?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Retrieves the ID of the last inserted movie
     * @return the ID of the last inserted movie
     */
    public int getLastInsertedMovieID() throws Exception {
        String sql = "SELECT MAX(MovieID) AS LastID FROM Movie";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("LastID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * Retrieves a movie by details
     * @param title Movie title
     * @param genre Movie genre
     * @param duration Movie duration
     * @param releaseDate Movie release date
     * @param description Movie description
     * @return Movie object
     */
    

    public static void main(String[] args) {
        MovieDAO dao = new MovieDAO();
        try {
            System.out.println(dao.getMovieByID(1));
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}