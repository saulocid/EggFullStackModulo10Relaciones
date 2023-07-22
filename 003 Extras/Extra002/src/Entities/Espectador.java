package Entities;

public class Espectador {

   private String nombre;
   private Integer edad;
   private Double dinero;
   private String asiento;

   public Espectador() {
   }

   public Espectador(String nombre, Integer edad, Double dinero, String asiento) {
      this.nombre = nombre;
      this.edad = edad;
      this.dinero = dinero;
      this.asiento = asiento;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public Integer getEdad() {
      return edad;
   }

   public void setEdad(Integer edad) {
      this.edad = edad;
   }

   public Double getDinero() {
      return dinero;
   }

   public void setDinero(Double dinero) {
      this.dinero = dinero;
   }

   public String getAsiento() {
      return asiento;
   }

   public void setAsiento(String asiento) {
      this.asiento = asiento;
   }

}
