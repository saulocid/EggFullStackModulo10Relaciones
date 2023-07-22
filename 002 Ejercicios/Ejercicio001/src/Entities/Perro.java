package Entities;

public class Perro {
   
   public String nombre;
   public String raza;
   public Integer edad;
   public String tamanno;

   public Perro() {
   }

   public Perro(String nombre, String raza, Integer edad, String tamaño) {
      this.nombre = nombre;
      this.raza = raza;
      this.edad = edad;
      this.tamanno = tamaño;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getRaza() {
      return raza;
   }

   public void setRaza(String raza) {
      this.raza = raza;
   }

   public Integer getEdad() {
      return edad;
   }

   public void setEdad(Integer edad) {
      this.edad = edad;
   }

   public String getTamaño() {
      return tamanno;
   }

   public void setTamaño(String tamaño) {
      this.tamanno = tamaño;
   }

   @Override
   public String toString() {
      return " es "+nombre+" de raza "+raza+", tiene "+edad+" años y su tamaño es "+tamanno;
   }
        
}
