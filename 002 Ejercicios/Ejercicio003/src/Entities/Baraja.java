package Entities;

import java.util.ArrayList;

public class Baraja {

   private ArrayList<Carta> cartas;
   private ArrayList<Carta> cartasDadas;

   public Baraja() {
   }

   public Baraja(ArrayList<Carta> cartas, ArrayList<Carta> cartasDadas) {
      this.cartas = cartas;
      this.cartasDadas = cartasDadas;
   }
    
   public ArrayList<Carta> getCartas() {
      return cartas;
   }

   public void setCartas(ArrayList<Carta> cartas) {
      this.cartas = cartas;
   }

   public ArrayList<Carta> getCartasDadas() {
      return cartasDadas;
   }

   public void setCartasDadas(ArrayList<Carta> cartasDadas) {
      this.cartasDadas = cartasDadas;
   }

}
