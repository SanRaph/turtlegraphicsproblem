public class SketchPad {
    private int[][] floor = new int[20][20];

    public void setFloor(int[][] newfloor){
        floor = newfloor;
    }

    public int[][] getFloor(){
        return floor;
    }
}
