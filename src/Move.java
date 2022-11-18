public class Move {
    private String operatorName = "MOVE";
    private String moveFrom;
    private String moveTo;

    public Move(String from, String to){
        this.moveFrom = from;
        this.moveTo = to;
    }

    // add getters and setters for operatorName?

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(moveFrom)){
            return false;
        }

        if(!worldState.isMonkeyHeightAt(WorldState.HEIGHT_LOW)){
           return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        //create and return a new WorldState
        //with the monkey’s updated location
        WorldState newState = new WorldState(moveTo, worldState.getRoomBoxIn(), worldState.getRoomBananasIn(), worldState.getMonkeyHeight(), worldState.getMonkeyHasBananas());

        return newState;
    }
}
