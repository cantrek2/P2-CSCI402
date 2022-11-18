public class Push {
    private String operatorName = "PUSH";
    private String pushFrom;
    private String pushTo;

    public Push(String from, String to){
        this.pushFrom = from;
        this.pushTo = to;
    }

    public boolean checkPreconditions(WorldState worldState){
        // check monkey and box are at pushFrom
        if(!worldState.isMonkeyAt(pushFrom) || !worldState.isBoxAt(pushFrom)){
            return false;
        }
        // check monkey height is low
        if(!worldState.isMonkeyHeightAt(WorldState.HEIGHT_LOW)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState){
        // create and return a new WorldState
        // with monkey and box at pushTo
        WorldState newState = new WorldState(pushTo, pushTo, worldState.getRoomBananasIn(), worldState.getMonkeyHeight(), worldState.getMonkeyHasBananas());
        return newState;
    }
}
