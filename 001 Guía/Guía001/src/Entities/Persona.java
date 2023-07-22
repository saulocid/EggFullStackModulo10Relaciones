package Entities;

public class Persona {
   
   
   
   private String nombre;
   private String apellido;
   private DNI dni;

   public Persona() {
   }

   public Persona(String nombre, String apellido, DNI dni) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.dni = dni;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public DNI getDni() {
      return dni;
   }

   public void setDni(DNI dni) {
      this.dni = dni;
   }

   @Override
   public String toString() {
      return "La persona es "+nombre+" "+apellido+" con DNI "+dni.toString();
   }
   
}
