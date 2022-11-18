public class WorldState {
    private String roomMonkeyIn;
    private String roomBoxIn;
    private String roomBananasIn;
    private String monkeyHeight;
    private boolean monkeyHasBananas;

    public static final String ROOM_A = "A";
    public static final String ROOM_B = "B";
    public static final String ROOM_C = "C";
    public static final String HEIGHT_LOW = "LOW";
    public static final String HEIGHT_HIGH = "HIGH";

    public WorldState(String roomMonkeyIn, String roomBoxIn, String roomBananasIn, String monkeyHeight, boolean monkeyHasBananas){
        this.roomMonkeyIn = roomMonkeyIn;
        this.roomBoxIn = roomBoxIn;
        this.roomBananasIn = roomBananasIn;
        this.monkeyHeight = monkeyHeight;
        this.monkeyHasBananas = monkeyHasBananas;
    }

    // roomMonkeyIn helper methods
    public String getRoomMonkeyIn(){
        return this.roomMonkeyIn;
    }

    public void setRoomMonkeyIn(String room){
        this.roomMonkeyIn = room;
    }

    public boolean isMonkeyAt(String room) {
        return this.roomMonkeyIn.equalsIgnoreCase(room);
    }

    // roomBoxIn helper methods
    public String getRoomBoxIn(){
        return this.roomBoxIn;
    }

    public void setRoomBoxIn(String room){
        this.roomBoxIn = room;
    }

    public boolean isBoxAt(String room){
        return this.roomBoxIn.equalsIgnoreCase(room);
    }

    // roomBananasIn helper methods
    public String getRoomBananasIn(){
        return this.roomBananasIn;
    }

    public void setRoomBananasIn(String room){
        this.roomBananasIn = room;
    }

    public boolean isBananasAt(String room){
        return this.roomBananasIn.equalsIgnoreCase(room);
    }

    // monkeyHeight helper methods
    public String getMonkeyHeight(){
        return this.monkeyHeight;
    }

    public void setMonkeyHeight(String height){
        this.monkeyHeight = height;
    }

    public boolean isMonkeyHeightAt(String height){
        return this.monkeyHeight.equalsIgnoreCase(height);
    }

    // monkeyHasBananas helper methods
    public boolean getMonkeyHasBananas(){
        return this.monkeyHasBananas;
    }

    public void setMonkeyHasBananas(boolean hasBananas){
        this.monkeyHasBananas = hasBananas;
    }

    // print world state
    public void printWorldState(){
        System.out.println("Monkey is in Room: " + roomMonkeyIn);
        System.out.println("Box is in Room: " + roomBoxIn);
        System.out.println("Bananas are in Room: " + roomBananasIn);
        System.out.println("Monkey is at height: " + monkeyHeight);
        System.out.println("Monkey has bananas: " + monkeyHasBananas);
    }
}
