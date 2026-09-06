//Class: Contender
//Purpose:
// Represents a battle participant in the Ultimate Battle simulation.
// Each Contender runs as its own thread and competes by defeating curses.
// The first contender to defeat 200 or more curses wins the battle.

public class Contender implements Runnable {
    private String name;
    private int curseKills = 0; //Curses defeated per action.
    private int runningTotal = 0;//Curses defeated during battle running total.
    private int maxRest = 0;//Max time the contender can rest.
    private static volatile boolean winner = false;//Determines if a winner has been declared.

    //Shared water object.
    private Water water;

    //Constructor
    public Contender(String name, int curseKills, int maxRest, Water water) {
        this.name = name;
        this.curseKills = curseKills;
        this.maxRest = maxRest;
        this.runningTotal = 0; //Sets running total to 0 before battle begins.
        this.water = water; // Stores shared Water object.
    }

    //Getters
    public String getName() {
        return name;// returns contender name.
    }

    public int getCurseKills() {
        return curseKills;//returns curses defeated per action.
    }

    public int getRunningTotal() {
        return runningTotal;//returns total curses defeated.
    }

    public int getMaxRest() {
        return maxRest;//returns max rest time.
    }

    //Run method override.
    public void run() {
        try{
            while(!winner){
               //Random rest time for maxRest.
                int restTime = (int)(Math.random() * maxRest);
                Thread.sleep(restTime);//puts thread to sleep.

                //Performs action: defeating curses.
                runningTotal += curseKills;

                //Printing the progress.
                System.out.println(name + " has defeated " + runningTotal + " curses");

                //Checking for the winner.
                if(runningTotal >= 200 && !winner){
                    winner = true;

                    //Announcing the winner.
                    System.out.println( "⭐ ⭐ ⭐ " + name + " HAS WON THE BATTLE!! ⭐ ⭐ ⭐");
                }

                // Take a water break (shared resource)
                int drinkTime = (name.equals("Gojo")) ? 1000 : 900; water.drink(name, drinkTime);
            }
        } catch (InterruptedException e){
            //Catches possible interruption exception during sleep.
            System.out.println(name + " has been interrupted!");
        }
    }
}
