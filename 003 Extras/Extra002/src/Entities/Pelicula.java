package Entities;

public class Pelicula {
   
   private String titulo;
   private Double duracion;
   private Integer clasificacion;
   private String director;

   public Pelicula() {
   }

   public Pelicula(String titulo, Double duracion, Integer clasificacion, String director) {
      this.titulo = titulo;
      this.duracion = duracion;
      this.clasificacion = clasificacion;
      this.director = director;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public Double getDuracion() {
      return duracion;
   }

   public void setDuracion(Double duracion) {
      this.duracion = duracion;
   }

   public Integer getClasificacion() {
      return clasificacion;
   }

   public void setClasificacion(Integer clasificacion) {
      this.clasificacion = clasificacion;
   }

   public String getDirector() {
      return director;
   }

   public void setDirector(String director) {
      this.director = director;
   }
   
}
