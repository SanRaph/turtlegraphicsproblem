public class Pen {
    private PenPosition positionOfThePen;

    public Pen(){
        //TODO: the pen position is up by default
        this.positionOfThePen = PenPosition.UP;
    }

    public void setPositionOfThePen(PenPosition newPosition){
        //TODO: set the incoming newPosition
        positionOfThePen = newPosition;
    }

    public PenPosition getPositionOfThePen() {

        return positionOfThePen;
    }
}
