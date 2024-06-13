package com.example.pruebalaboratorio1.daos;

import com.example.pruebalaboratorio1.beans.genero;
import com.example.pruebalaboratorio1.beans.pelicula;
import com.example.pruebalaboratorio1.beans.streaming;

import java.sql.*;
import java.util.ArrayList;

public class peliculaDao extends baseDao{

    public ArrayList<pelicula> listarPeliculas() {

        ArrayList<pelicula> listaPeliculas = new ArrayList<>();



        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();) {


            String sql = "SELECT A.*, B.NOMBRE, C.NOMBRESERVICIO FROM  \n" +
                    "(SELECT * FROM PELICULA ) AS A \n" +
                    "INNER JOIN \n" +
                    "(SELECT * FROM GENERO) AS B\n" +
                    "ON A.IDGENERO = B.IDGENERO\n" +
                    "INNER JOIN \n" +
                    "(SELECT * FROM STREAMING) AS C\n" +
                    "ON A.IDSTREAMING = C.IDSTREAMING\n" +
                    "ORDER BY RATING DESC , BOXOFFICE DESC";


            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                pelicula movie = new pelicula();
                genero genero = new genero();
                streaming streaming = new streaming();
                int idPelicula = rs.getInt(1);
                movie.setIdPelicula(idPelicula);
                String titulo = rs.getString("titulo");
                movie.setTitulo(titulo);
                String director = rs.getString("director");
                movie.setDirector(director);
                int anoPublicacion = rs.getInt("anoPublicacion");
                movie.setAnoPublicacion(anoPublicacion);
                double rating = rs.getDouble("rating");
                movie.setRating(rating);
                double boxOffice = rs.getDouble("boxOffice");
                movie.setBoxOffice(boxOffice);
                int idGenero = rs.getInt("idGenero");


                //mi modificacion:
                genero gener = new genero();
                gener.setNombre(rs.getString("nombre"));
                gener.setIdGenero(rs.getInt("idGenero"));
                movie.setGeneroB(gener);
                String duracion = rs.getString("duracion");
                boolean premioOscar = rs.getBoolean("premioOscar");
                streaming strem = new streaming();
                strem.setIdStreaming(rs.getInt("idStreaming"));
                strem.setNombreServicio(rs.getString("nombreServicio"));
                movie.setDuracion(duracion);
                movie.setPremioOscar(premioOscar);
                movie.setStreamingB(strem);


                /*
                Job job = new Job();
                job.setJobId(rs.getString("e.job_id"));
                job.setJobTitle(rs.getString("job_title"));
                employee.setJob(job);
                * */



                //boolean validador= validarBorrado(movie);
                //movie.setValidadorBorrado(validador);

                listaPeliculas.add(movie);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPeliculas;
    }

    public ArrayList<pelicula> listarPeliculasFiltradas(int idGenero, int idStreaming) {

        ArrayList<pelicula> listaPeliculasFiltradas= new ArrayList<>();


        return listaPeliculasFiltradas;
    }

    // AGREGAR CAMPOS FALTANTES (GENERO, STREAMING)
    public void editarPelicula(int idPelicula, String titulo, String director, int anoPublicacion, double rating, double boxOffice){
        try (Connection conn = getConnection();) {
            String sql = "UPDATE PELICULA SET titulo = ?, director = ?, anoPublicacion = ? ," +
                    "rating = ?, boxOffice = ? WHERE IDPELICULA = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, titulo);
                pstmt.setString(2, director);
                pstmt.setInt(3, anoPublicacion);
                pstmt.setDouble(4, rating);
                pstmt.setDouble(5, boxOffice);
                pstmt.setInt(6, idPelicula);
                pstmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void borrarPelicula(String idPelicula) throws SQLException {

        // NOTA: PARA BORRAR UNA PELICULA CORRECTAMENTE NO OLVIDAR PRIMERO BORRARLA DE LA TABLA PROTAGONSITAS


        String sql = "DELETE FROM `mydb`.`protagonistas` WHERE (`idPelicula` = ?)";

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,idPelicula);
            pstmt.executeUpdate();

        }

        String sql2 ="DELETE FROM `mydb`.`pelicula` WHERE (`idPelicula` = ?)";
        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql2)){

            pstmt.setString(1,idPelicula);
            pstmt.executeUpdate();

        }

    }


    public pelicula buscarPorId(String idPeliculaDelete) {
        ArrayList<pelicula> listaPelicul = listarPeliculas();
        pelicula peliculaaa = new pelicula();
        for(pelicula pelicula1: listaPelicul){
            if(pelicula1.getIdPelicula() == Integer.parseInt(idPeliculaDelete)){
                peliculaaa = pelicula1;
            }
        }
        return peliculaaa;
    }
}
