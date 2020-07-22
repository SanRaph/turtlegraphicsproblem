public class SketchPad {
    //TODO: creates a 20 * 20 grid
    private int[][] floor = new int[20][20];

    public void setFloor(int[][] newfloor){

        floor = newfloor;
    }

    public int[][] getFloor(){

        return floor;
    }
}
