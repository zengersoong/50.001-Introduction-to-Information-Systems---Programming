
// Cohort Question 2
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

package PartB;


public class CoffeeMaker {
    private static final int tooCold = 55;
    private static final int tooHot = 85;

   
    public void makeCoffee(int temperature) throws TooCold, TooHot {
        if (temperature <= tooCold) throw new TooCold(temperature);
        if (temperature >= tooHot) throw new TooHot(temperature);
        System.out.println("Mmm!");
    }

   public static void main (String[] args) {
       CoffeeMaker c = new CoffeeMaker ();
       int temperature[] = {20,90,60};
       for (int i = 0; i < 3; i++) {
       try {
            c.makeCoffee(temperature[i]);
        }
        catch (TooCold ex){
        	System.out.println("yuck! ");
        	System.out.println(ex);
        }
        catch (TooHot ex){
            System.out.println("Ouch! ");
           System.out.println(ex);

        }
       }
    }
}

    class TooCold extends Exception {
      private int temp;
      public TooCold(int temperature) {
    	  super("Too Cold "+ temperature+" Celsius");
    	  this.temp=temperature;
      }
      


    }

    class TooHot extends Exception {
    	   private int temp;
    	      public TooHot(int temperature) {
    	    	  super("Too Hot "+ temperature+" Celsius");
    	    	  // This is to replace the default output of the exception to what you want.
    	    	  
    	    	  this.temp=temperature;

    }
    }
