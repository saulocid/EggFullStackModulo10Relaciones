package Entities;

public class Perro {
   
   public String nombre;
   public String raza;
   public Integer edad;
   public String tamanno;
   public boolean duenno;

   public Perro() {
   }

   public Perro(String nombre, String raza, Integer edad, String tamanno, boolean duenno) {
      this.nombre = nombre;
      this.raza = raza;
      this.edad = edad;
      this.tamanno = tamanno;
      this.duenno = duenno;
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

   public String getTamanno() {
      return tamanno;
   }

   public void setTamanno(String tamanno) {
      this.tamanno = tamanno;
   }

   public boolean isDuenno() {
      return duenno;
   }

   public void setDuenno(boolean duenno) {
      this.duenno = duenno;
   }

   @Override
   public String toString() {
      return nombre+" de raza "+raza+", tiene "+edad+" años, su tamaño es "+tamanno+tieneDueño(this);
   }
   
   public String tieneDueño(Perro p){
      if(p.isDuenno()==true){
         return " y tiene dueño";
      } else{
         return " y NO tiene dueño";
      }
   }
        
}

