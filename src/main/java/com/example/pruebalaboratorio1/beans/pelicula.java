package com.example.pruebalaboratorio1.beans;

public class pelicula {

    private int idPelicula;
    private String titulo;

    private String director;
    private int anoPublicacion;
    private Double rating;
    private double boxOffice;
    private genero generoB;
    private String genero;
    private String streaming;

    private streaming streamingB;
    private String duracion;
    private boolean premioOscar;

    private boolean sePuedeBorrar;

    public boolean isSePuedeBorrar() {
        return sePuedeBorrar;
    }

    public void setSePuedeBorrar(boolean sePuedeBorrar) {
        this.sePuedeBorrar = sePuedeBorrar;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStreaming() {
        return streaming;
    }

    public void setStreaming(String streaming) {
        this.streaming = streaming;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public genero getGeneroB() {
        return generoB;
    }

    public void setGeneroB(genero generoB) {
        this.generoB = generoB;
    }

    public streaming getStreamingB() {
        return streamingB;
    }

    public void setStreamingB(streaming streamingB) {
        this.streamingB = streamingB;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public boolean isPremioOscar() {
        return premioOscar;
    }

    public void setPremioOscar(boolean premioOscar) {
        this.premioOscar = premioOscar;
    }

    // private boolean validadorBorrado;



}
