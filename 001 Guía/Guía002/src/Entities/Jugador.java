package Entities;

//nombre, apellido, posición y número

public class Jugador {
   
   private String nombre;
   private String apellido;
   private String posicion;
   private Integer numero;

   public Jugador() {
   }

   public Jugador(String nombre, String apellido, String posicion, Integer numero) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.posicion = posicion;
      this.numero = numero;
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

   public String getPosicion() {
      return posicion;
   }

   public void setPosicion(String posicion) {
      this.posicion = posicion;
   }

   public Integer getNumero() {
      return numero;
   }

   public void setNumero(Integer numero) {
      this.numero = numero;
   }

   @Override
   public String toString() {
      return "Jugador: "+nombre+" "+apellido+", su posición es "+posicion+" y su número de camiseta es "+numero;
   }
   
}
