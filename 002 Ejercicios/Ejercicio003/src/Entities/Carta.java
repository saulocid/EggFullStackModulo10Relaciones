package Entities;

public class Carta {

   private String palo;
   private Integer numero;

   public Carta() {
   }

   public Carta(String palo, Integer numero) {
      this.palo = palo;
      this.numero = numero;
   }

   public String getPalo() {
      return palo;
   }

   public void setPalo(String palo) {
      this.palo = palo;
   }

   public Integer getNumero() {
      return numero;
   }

   public void setNumero(Integer numero) {
      this.numero = numero;
   }

   @Override
   public String toString() {
      return "Carta: " + numero + " de " + palo;
   }

}
