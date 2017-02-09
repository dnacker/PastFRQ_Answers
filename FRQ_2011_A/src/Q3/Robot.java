package Q3;

/**
 * Implementation of FuelRobot interface.
 */
public class Robot implements FuelRobot{
    private int position;
    private boolean isFacingRight;

    public Robot(int position, boolean faceRight) {
        this.position = position;
        isFacingRight = faceRight;
    }

    public int getCurrentIndex() {
        return position;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void changeDirection() {
        isFacingRight = !isFacingRight;
    }

    public void moveForward(int numLocs) {
        if (isFacingRight) {
            position += numLocs;
        } else {
            position -= numLocs;
        }
    }

    public String toString() {
        String dir = "left";
        if (isFacingRight) {
            dir = "right";
        }
        return "pos: " + position + ", dir: " + dir;
    }
}
