package Q3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 1/21/2017.
 */
public class FuelDepot {
    /** The robot used to move the filling mechanism */
    private FuelRobot filler;
    /** The list of fuel tanks */
    private List<FuelTank> tanks;

    public FuelDepot(FuelRobot f, List<FuelTank> tanks) {
        filler = f;
        this.tanks = tanks;
    }

    /**Determines and returns the index of the next tank to be filled.
     * @param threshold fuel tanks with a fuel level <= threshold may be filled.
     * @return index of the next tank to fill.
     */
    public int nextTankToFill(int threshold) {
        int index = filler.getCurrentIndex();
        int smallest = threshold;
        for (int i = 0; i < tanks.size(); i++) {
            int currentTankLevel = tanks.get(i).getFuelLevel();
            if (currentTankLevel < smallest) {
                smallest = currentTankLevel;
                index = i;
            }
        }
        return index;
    }

    /**
     * Moves the robot to location locIndex.
     * @param locIndex the index of the location of the tank to move to.
     *                 Precondition: 0 <= locIndex < tanks.size();
     *                 Postcondition: the current location of the robot is locIndex.
     */
    public void moveToLocation(int locIndex) {
        int numMoves = locIndex - filler.getCurrentIndex();
        if (numMoves != 0) {
            if (numMoves > 0 && !filler.isFacingRight()) {
                filler.changeDirection();
            } else if (numMoves < 0 && filler.isFacingRight()) {
                filler.changeDirection();
            }
            filler.moveForward(Math.abs(numMoves));
        }
    }

    public String toString() {
        return "Tanks: " + tanks + "\nFiller: " + filler;
    }

    /*
    public static void main(String[] args) {
        List<FuelTank> tanks = new ArrayList<FuelTank>();
        tanks.add(new Tank(80));
        tanks.add(new Tank(55));
        tanks.add(new Tank(50));
        tanks.add(new Tank(75));
        tanks.add(new Tank(30));
        FuelRobot myBot = new Robot(2, true);
        FuelDepot myDepot = new FuelDepot(myBot, tanks);
        System.out.println(myDepot);
        int firstIndex = myDepot.nextTankToFill(50);
        int secondIndex = myDepot.nextTankToFill(15);
        System.out.println(firstIndex);
        System.out.println(secondIndex);
        myDepot.moveToLocation(firstIndex);
        System.out.println(myDepot);
        myDepot.moveToLocation(secondIndex);
        System.out.println(myDepot);
    }
    */
}
