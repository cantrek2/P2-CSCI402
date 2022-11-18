public class Grab {
    private String operatorName = "GRAB";

    // not sure if we will need a constructor
    // public Grab(){

    // }

    public boolean checkPreconditions(WorldState worldState){
        // check that monkey and bananas are in the same room
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBananasIn())){
            return false;
        }
        // check that monkey is at height HIGH
        if(!worldState.isMonkeyHeightAt(WorldState.HEIGHT_HIGH)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState){
        // create and return a new WorldState
        // where monkey has bananas
        WorldState newState = new WorldState(worldState.getRoomMonkeyIn(), worldState.getRoomBoxIn(), worldState.getRoomBananasIn(), worldState.getMonkeyHeight(), true);
        return newState;
    }
}
