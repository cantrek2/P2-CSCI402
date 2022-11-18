public class ClimbDown {
    private String operatorName = "CLIMBDOWN";

    // not sure if we will need the constructor
    // public ClimbDown(){

    // }

    public boolean checkPreconditions(WorldState worldState){
        // check that monkey and box are in the same room
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBoxIn())){
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
        // with monkey at height LOW
        WorldState newState = new WorldState(worldState.getRoomMonkeyIn(), worldState.getRoomBoxIn(), worldState.getRoomBananasIn(), WorldState.HEIGHT_LOW, worldState.getMonkeyHasBananas());
        return newState;
    }
}
