
package Entities;

public class Cine {
   
   private Espectador[][] sala;
   private Pelicula pelicula;
   private Double entrada;

   public Cine() {
   }

   public Cine(Espectador[][] sala, Pelicula pelicula, Double entrada) {
      this.sala = sala;
      this.pelicula = pelicula;
      this.entrada = entrada;
   }

   public Espectador[][] getSala() {
      return sala;
   }

   public void setSala(Espectador[][] sala) {
      this.sala = sala;
   }
   
   public Pelicula getPelicula() {
      return pelicula;
   }

   public void setPelicula(Pelicula pelicula) {
      this.pelicula = pelicula;
   }

   public Double getEntrada() {
      return entrada;
   }

   public void setEntrada(Double entrada) {
      this.entrada = entrada;
   }
   
}
