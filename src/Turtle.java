import jdk.jfr.StackTrace;

import java.math.BigInteger;

public class Turtle {

    private int xCoord;
    private int yCoord;
    private CardinalDirection direction = CardinalDirection.NORTH;

    private Pen turtlePen;


    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public Pen getTurtlePen() {
        return turtlePen;
    }

    public void setTurtlePen(Pen turtlePen) {
        this.turtlePen = turtlePen;
    }


    public void moveForward(int numberOfSteps){
        this.xCoord = numberOfSteps - 1;
    }

    public void changePenPosition(PenPosition newPosition){
        turtlePen.setPositionOfThePen(newPosition);
    }

    public void turnRight(){
        if(direction == CardinalDirection.NORTH){
            direction = CardinalDirection.EAST;
        } else if(direction == CardinalDirection.EAST){
            direction = CardinalDirection.SOUTH;
        } else if(direction == CardinalDirection.SOUTH){
            direction = CardinalDirection.WEST;
        } else if(direction == CardinalDirection.WEST){
            direction = CardinalDirection.NORTH;
        }
    }

    public  void draw(int[][] canvas, int numberOfSteps){
        this.turtlePen.setPositionOfThePen(PenPosition.DOWN);

        if(this.direction == CardinalDirection.NORTH){
            for (int i =0; i < numberOfSteps; i ++){
                //avoid magic numbers like figure 1
                canvas[yCoord][i] = BigInteger.ONE.intValue();
            }
            this.xCoord = numberOfSteps - 1;
        } else if(this.direction == CardinalDirection.EAST){
            for (int i =0; i < numberOfSteps; i ++){
                canvas[i][xCoord] = BigInteger.ONE.intValue();
            }
            this.yCoord = numberOfSteps - 1;

        } else if(this.direction == CardinalDirection.SOUTH){
            for (int i = numberOfSteps - 1; i >= 0; i --){
                canvas[yCoord][i] = BigInteger.ONE.intValue();
            }
            this.xCoord = xCoord -  (numberOfSteps - 1);

        } else if(this.direction == CardinalDirection.WEST){
            for (int i = numberOfSteps - 1; i >=0 ; i --){
                canvas[0][i] = BigInteger.ONE.intValue();
            }
             this.yCoord = numberOfSteps - 1;
        }


    }


    public CardinalDirection getDirection() {
        return direction;
    }

    public void setDirection(CardinalDirection direction) {
        this.direction = direction;
    }
}
