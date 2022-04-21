package exceptions;


public class NegValueException extends Exception{

   public NegValueException() {
       super("Il valore deve essere positivo!!");
   
   }

   public NegValueException(double c) {
       super("Il valore "+c+" deve essere positivo!!");
   }
   
}
