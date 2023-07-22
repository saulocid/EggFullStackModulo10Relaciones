package ejercicio001;

import Entities.Perro;
import Entities.Persona;

/**
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */

public class Ejercicio001 {

   public static void main(String[] args) {
      
      Perro p1 = new Perro("T-Rex","callejero",4,"grande");
      Perro p2 = new Perro("Nero","callejero",3,"grande");
      Persona Saulo = new Persona("Saulo","Cid",35,33331260,p1);
      Persona Nathan = new Persona("Nathan","Cid",9,53483839,p2);
      
      System.out.println(Saulo.toString());
      System.out.println(Nathan.toString());
      
   }
   
}
