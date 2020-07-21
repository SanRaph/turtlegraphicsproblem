import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: complete and review this test
class TurtleTest {
    Turtle ijapa;
    Pen biro;
    SketchPad pad;

    @BeforeEach
    void setUp() throws Exception {
        ijapa = new Turtle();
        biro = new Pen();
        ijapa.setTurtlePen(biro);
        pad = new SketchPad();
    }

    @Test
    void createTurtle() {
        assertEquals(0, ijapa.getxCoordinate());
        assertEquals(0, ijapa.getyCoordinate());
        assertEquals(PenPosition.UP, ijapa.getTurtlePen().getPositionOfThePen());
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
    }

    @Test
    void putPenDown() {
        assertEquals(PenPosition.UP, ijapa.getTurtlePen().getPositionOfThePen());
        ijapa.changePenPosition(PenPosition.DOWN);
        assertEquals(PenPosition.DOWN, ijapa.getTurtlePen().getPositionOfThePen());
    }

    @Test
    void draw() {
        int steps = 7;
        ijapa.draw(pad.getFloor(), steps);
        for(int i = 0; i < steps; i++) {
            assertEquals(1, pad.getFloor()[0][i]);
        }
    }

    @Test
    void turnRightWhenFacingNorth() {
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalDirection.EAST, ijapa.getDirection());
    }

    @Test
    void turnRightWhenFacingEast() {
        ijapa.setDirection(CardinalDirection.EAST);
        ijapa.turnRight();
        assertEquals(CardinalDirection.SOUTH, ijapa.getDirection());
    }

    @Test
    void turnRightWhenFacingSouth() {
        ijapa.setDirection(CardinalDirection.SOUTH);
        ijapa.turnRight();
        assertEquals(CardinalDirection.WEST, ijapa.getDirection());
    }

    @Test
    void turnRightWhenFacingWest() {
        ijapa.setDirection(CardinalDirection.WEST);
        ijapa.turnRight();
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
    }

    @Test
    void drawSquare() {
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
        int steps = 12;
        ijapa.draw(pad.getFloor(), steps);

        ijapa.turnRight();	//East
        ijapa.draw(pad.getFloor(), steps);

        ijapa.turnRight();	//South
        ijapa.draw(pad.getFloor(), steps);

        ijapa.turnRight();	//West
        ijapa.draw(pad.getFloor(), steps);

        for(int i = 0; i < pad.getFloor().length; i++) {
            for(int j = 0; j < pad.getFloor().length; j++) {
                if(pad.getFloor()[i][j] == 1) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
