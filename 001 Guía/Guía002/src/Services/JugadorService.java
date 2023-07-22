package Services;

import Entities.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorService {
   
   public final Scanner leer = new Scanner(System.in).useDelimiter("\n");

   public Jugador crearJugador(){
      Jugador j = new Jugador();
      System.out.println("Ingrese los datos del jugador");
      System.out.print("Nombre: ");
      j.setNombre(leer.next());
      System.out.print("Apellido: ");
      j.setApellido(leer.next());
      System.out.print("Posicion: ");
      j.setPosicion(leer.next());
      System.out.print("Número Camiseta: ");
      j.setNumero(leer.nextInt());
      return j;
   }
   
   public void mostrar(ArrayList<Jugador> lista){
      System.out.println("Los jugadores son:");
      for (Object j : lista) {
         System.out.println(j.toString());
      }
   }
          
}
