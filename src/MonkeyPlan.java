import java.util.Scanner;

public class MonkeyPlan {
    private String monkeyRoomStart;
    private String boxRoomStart;
    private String bananasRoomStart;
    private String monkeyHeightStart;
    private boolean monkeyHasBananasStart;

    public void makePlan(){
        boolean incorrectInput = true;
        Scanner scanner = new Scanner(System.in);

        // get room monkey starts in
        System.out.println("Select which room the monkey starts in:");
        System.out.println("[1] Room A\n[2] Room B\n[3] Room C");
        String userInput = scanner.nextLine();
        while(incorrectInput){
            if(userInput.equalsIgnoreCase("A") || userInput.equalsIgnoreCase("B") || userInput.equalsIgnoreCase("C")){
                monkeyRoomStart = userInput;
                incorrectInput = false;
            }
            else{
                System.out.println("Incorrect input, please enter A B or C");
                userInput = scanner.nextLine();
            }
        }

        // get room box starts in
        incorrectInput = true;
        System.out.println("Select which room the box starts in:");
        System.out.println("[1] Room A\n[2] Room B\n[3] Room C");
        userInput = scanner.nextLine();
        while(incorrectInput){
            if(userInput.equalsIgnoreCase("A") || userInput.equalsIgnoreCase("B") || userInput.equalsIgnoreCase("C")){
                boxRoomStart = userInput;
                incorrectInput = false;
            }
            else{
                System.out.println("Incorrect input, please enter A B or C");
                userInput = scanner.nextLine();
            }
        }

        // get room bananas start in 
        incorrectInput = true;
        System.out.println("Select which room the bananas start in:");
        System.out.println("[1] Room A\n[2] Room B\n[3] Room C");
        userInput = scanner.nextLine();
        while(incorrectInput){
            if(userInput.equalsIgnoreCase("A") || userInput.equalsIgnoreCase("B") || userInput.equalsIgnoreCase("C")){
                bananasRoomStart = userInput;
                incorrectInput = false;
            }
            else{
                System.out.println("Incorrect input, please enter A B or C");
                userInput = scanner.nextLine();
            }
        }

        monkeyHeightStart = "LOW";
        monkeyHasBananasStart = false;

        scanner.close();

        // create WorldState
        WorldState worldState = new WorldState(monkeyRoomStart, boxRoomStart, bananasRoomStart, monkeyHeightStart, monkeyHasBananasStart);

        worldState.printWorldState();
        
    }
}
