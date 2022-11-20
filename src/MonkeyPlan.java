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

        System.out.println("");


        // make plan
        Planner planner = new Planner();
        boolean goalMet = false;

        Move move;
        Push push;
        ClimbUp climbUp;
        Grab grab;
        WorldState tempWorldState;
        boolean actionTaken = false;
        
        while(!goalMet){
            actionTaken = false;
            while(planner.checkGoal(worldState)){
                planner.incrementGoalsIndex();
            }
            
            // move to A
            move = new Move(worldState.getRoomMonkeyIn(), WorldState.ROOM_A);
            if(move.checkPreconditions(worldState)){
                tempWorldState = move.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("Move(" + worldState.getRoomMonkeyIn() + ", A)");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }

            // move to B
            move = new Move(worldState.getRoomMonkeyIn(), WorldState.ROOM_B);
            if(move.checkPreconditions(worldState) && !actionTaken){
                tempWorldState = move.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("Move(" + worldState.getRoomMonkeyIn() + ", B)");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }

            // move to C
            move = new Move(worldState.getRoomMonkeyIn(), WorldState.ROOM_C);
            if(move.checkPreconditions(worldState) && !actionTaken){
                tempWorldState = move.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("Move(" + worldState.getRoomMonkeyIn() + ", C)");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }

            // push to A
            push = new Push(worldState.getRoomBoxIn(), WorldState.ROOM_A);
            if(push.checkPreconditions(worldState) && !actionTaken){
                tempWorldState = push.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("Push(" + worldState.getRoomMonkeyIn() + ", A)");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }
            
            // push to B
            push = new Push(worldState.getRoomBoxIn(), WorldState.ROOM_B);
            if(push.checkPreconditions(worldState) && !actionTaken){
                tempWorldState = push.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("Push(" + worldState.getRoomMonkeyIn() + ", B)");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }

            // push to C
            push = new Push(worldState.getRoomBoxIn(), WorldState.ROOM_C);
            if(push.checkPreconditions(worldState) && !actionTaken){
                tempWorldState = push.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("Push(" + worldState.getRoomMonkeyIn() + ", C)");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }

            // climb up
            climbUp = new ClimbUp();
            if(climbUp.checkPreconditions(worldState) && !actionTaken){
                tempWorldState = climbUp.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("ClimbUp()");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }

            // grab
            grab = new Grab();
            if(grab.checkPreconditions(worldState) && !actionTaken){
                tempWorldState = grab.applyPostconditions(worldState);
                if(planner.checkGoal(tempWorldState)){
                    System.out.println("Grab()");
                    worldState = tempWorldState;
                    planner.incrementGoalsIndex();
                    actionTaken = true;
                }
            }

            if(planner.goalStateMet(worldState)){
                goalMet = true;
            }
        }
    }
}
