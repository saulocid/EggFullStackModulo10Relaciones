package Entities;

public class Persona {

   private String nombre;
   private String appelido;
   private Integer edad;
   private Integer dni;
   private Perro perro;

   public Persona() {
   }

   public Persona(String nombre, String appelido, Integer edad, Integer dni, Perro perro) {
      this.nombre = nombre;
      this.appelido = appelido;
      this.edad = edad;
      this.dni = dni;
      this.perro = perro;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getAppelido() {
      return appelido;
   }

   public void setAppelido(String appelido) {
      this.appelido = appelido;
   }

   public Integer getEdad() {
      return edad;
   }

   public void setEdad(Integer edad) {
      this.edad = edad;
   }

   public Integer getDni() {
      return dni;
   }

   public void setDni(Integer dni) {
      this.dni = dni;
   }

   public Perro getPerro() {
      return perro;
   }

   public void setPerro(Perro perro) {
      this.perro = perro;
   }

   @Override
   public String toString() {
      return nombre + " " + appelido + ", de " + edad + " años, con dni Nº " + dni + ", y su perro es " + perro.toString();
   }

}
