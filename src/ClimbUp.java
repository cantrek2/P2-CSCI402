public class ClimbUp {
    private String operatorName = "CLIMBUP";

    // not sure if we will need this constructor
    // public ClimbUp(){

    // }

    public boolean checkPreconditions(WorldState worldState){
        // check that monkey and box are in same room
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBoxIn())){
            return false;
        }
        
        // check monkey is at height LOW
        if(!worldState.isMonkeyHeightAt(WorldState.HEIGHT_LOW)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState){
        // create and return a new WorldState
        // with monkeys height at HIGH
        WorldState newState = new WorldState(worldState.getRoomMonkeyIn(), worldState.getRoomBoxIn(), worldState.getRoomBananasIn(), WorldState.HEIGHT_HIGH, worldState.getMonkeyHasBananas());
        return newState;
    }
}
