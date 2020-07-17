import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurtleTest {

    Turtle ipaja;
    Pen biro;

    @BeforeEach
    void setUp() {
        ipaja = new Turtle();
        biro = new Pen();
        ipaja.setTurtlePen(biro);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createTurtle(){
        assertEquals(0, ipaja.getxCoord());
        assertEquals(0, ipaja.getyCoord());
        assertEquals(PenPosition.UP, ipaja.getTurtlePen().getPositionOfThePen());
    }

    @Test
    void moveForwardWithPenUPTest(){
        assertEquals(0, ipaja.getxCoord());
        assertEquals(0, ipaja.getyCoord());
        assertEquals(PenPosition.UP, ipaja.getTurtlePen().getPositionOfThePen());
        assertEquals(CardinalDirection.NORTH, ipaja.getDirection());


        ipaja.moveForward(7);

        assertEquals(6, ipaja.getxCoord());
        assertEquals(0, ipaja.getyCoord());

    }

    @Test
    void draw(){
        int steps
        ipaja.changePenPosition(PenPosition.DOWN);
        ipaja.draw(pad.getFloor(), steps);

            for (int j = 0; j < steps; j ++){
                assertEquals(1, pad.getFloor()[0][j]);
            }

    }

    @Test
    void turtleRightWhenFacingNorth(){
        assertEquals(CardinalDirection.EAST, ipaja.getDirection());
    }

    @Test
    void turtleRightWhenFacingEast(){
        assertEquals(CardinalDirection.EAST, ipaja.getDirection());
        ipaja.turnRight();
        assertEquals(CardinalDirection.SOUTH, ipaja.getDirection());
    }

    @Test
    void turtleRightWhenFacingWest(){
        assertEquals(CardinalDirection.EAST, ipaja.getDirection());
        ipaja.turnRight();
        assertEquals(CardinalDirection.NORTH, ipaja.getDirection());
    }


    @Test
    void drawSquare(){
        assertEquals(CardinalDirection.NORTH, ipaja.getDirection());
        int steps = 12;
        ipaja.draw(pad.getFloor(), steps);

        ipaja.turnRight(); // East
        ipaja.draw(pad.getFloor(), steps);

        ipaja.turnRight(); // south
        ipaja.draw(pad.getFloor(), steps);

        ipaja.turnRight(); // West
        ipaja.draw(pad.getFloor(), steps);

        for (int i = 0; i < pad.getFloor().length; i ++){
            for (int j = 0; j < pad.getFloor().length; j++){
                if(pad.getFloor()[i][j] == 1){
                    System.out.print("*");
                } else{
                    System.out.print("");
                }
            }
        }
        System.out.print();

    }
    @Test
    void putPenDown(){
        assertEquals(PenPosition.UP, ipaja.getTurtlePen().getPositionOfThePen());
        ipaja.changePenPosition(PenPosition.DOWN);
        assertEquals(PenPosition.DOWN, ipaja.getTurtlePen().getPositionOfThePen());
    }




}