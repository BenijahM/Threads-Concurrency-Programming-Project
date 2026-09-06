//Class: Water
//Purpose: Represents a shared resource used by contenders
//during the battle. Only one contender can drink at a time.
//The drink() method is synchronized to prevent multiple threads
//from drinking simultaneously.

public class Water {
    //Allows a contender to take a water break.
    public synchronized void drink (String name, int drinkTime){
        try{
            //Indicates who is taking a drink.
            System.out.println(name + " is taking a water break...");

            //Thread sleeps while drinking.
            Thread.sleep(drinkTime);

            //Indicates when the contender finishes drinking.
            System.out.println(name + " has finished his water break.");
        }catch(InterruptedException e) {
            //Catches possible interruption exception during sleep.
            System.out.println(name + " was interrupted during a water break.");
        }
    }

}
