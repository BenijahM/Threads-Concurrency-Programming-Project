// Be'Nijah Mitchell COP-3330-25407 February 20, 2026
//Objective:
//This program simulates a battle between two contenders: Gojo and Sukuna.
//Each contender runs as a separate thread and competes to defeat 200 curses first.
//The first contender to reach 200 wins the battle.


public class UltimateBattleApp {
    public static void main (String[] args){

        Water sharedWater = new Water();

        //Contenders for the battle: Gojo and Sukuna.
        Contender gojo = new Contender("Gojo",15,2000, sharedWater);
        Contender sukuna = new Contender("Sukuna", 20, 1000, sharedWater);

        //Array that holds threads.
       Thread [] contenderThreads = new Thread[2];

       //Assigning threads to the array.
        contenderThreads [0] = new Thread(gojo);
        contenderThreads [1] = new Thread(sukuna);

        System.out.println("⚔ ⚔ ⚔ ⚔ LET THE BATTLE BEGIN! ⚔ ⚔ ⚔ ⚔");

        //Starting each thread (starting the battle).
        for(Thread battleTime: contenderThreads){
            battleTime.start();
        }
    }
}
