import java.util.ArrayList;
public class Planner {

     private int goalsIndex;

    public Planner(){
        this.goalsIndex = 0;
    }

    public int getGoalsIndex(){
        return this.goalsIndex;
    }

    public void incrementGoalsIndex(){
        this.goalsIndex++;
    }

     // check if monkey and box are in same room
     public boolean intGoalOneMet(WorldState worldState){
        if(worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBoxIn())){
            return true;
        }
        return false;
     }

     // check if box monkey and bananas are in the same room
     public boolean intGoalTwoMet(WorldState worldState){
        if(worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBoxIn()) && worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBananasIn())){
            return true;
        }
        return false;
     }

     // check if monkey is at height high and in the same room as the bananas
     public boolean intGoalThreeMet(WorldState worldState){
        if(worldState.isMonkeyHeightAt(WorldState.HEIGHT_HIGH) && worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBananasIn())){
            return true;
        }
        return false;
     }

     // check if goal state has been reached
     public boolean goalStateMet(WorldState worldState){
        if(worldState.getMonkeyHasBananas()){
            return true;
        }
        return false;
     }

     // calls the current goal based on goalsIndex
     public boolean checkGoal(WorldState worldState){
        if(this.goalsIndex == 0){
            return intGoalOneMet(worldState);
        }
        else if(this.goalsIndex == 1){
            return intGoalTwoMet(worldState);
        }
        else if(this.goalsIndex == 2){
            return intGoalThreeMet(worldState);
        }
        else{
            return goalStateMet(worldState);
        }
     }
}
