package Entities;

public class DNI {
         
   private char serie;
   private Integer numero;

   public DNI() {
   }

   public DNI(char serie, Integer numero) {
      this.serie = serie;
      this.numero = numero;
   }

   public char getSerie() {
      return serie;
   }

   public void setSerie(char serie) {
      this.serie = serie;
   }

   public Integer getNumero() {
      return numero;
   }

   public void setNumero(Integer numero) {
      this.numero = numero;
   }

   @Override
   public String toString() {
      return serie+"-"+numero;
   }
   
}
