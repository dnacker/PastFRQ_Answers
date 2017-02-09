package Q3;

import java.util.Arrays;

/**
 * Created by David on 1/21/2017.
 */
public class HorseBarn {
    /** The spaces in the barn. Each array element holds a reference to the horse
     * that is currently occupying the space. A null value indicates an empty space.
     */
    private Horse[] spaces;

    public HorseBarn(Horse[] horses) {
        spaces = horses;
    }

    /** Returns the index of the space that contains the horse with the specified name.
     * Precondition: No two horses in the barn have the same name.
     * @param name the name of the horse to find
     * @return the index of the space containing the horse with the specified name;
     * -1 if no horse with the specified name is in the barn.
     */
    public int findHorseSpace(String name) {
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] != null && spaces[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /** Consolidates the barn by moving horses so that the horses are in adjacent spaces,
     * starting at index 0, with no empty space between any two horses.
     * Postcondition: The order of the horses is the same as before the consolidation.
     */
    public void consolidate() {
        int indexToPut = 0;
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] == null) {
                indexToPut = i;
                boolean added = false;
                for (int j = indexToPut + 1; !added && j < spaces.length; j++) {
                    if (spaces[j] != null) {
                        spaces[indexToPut] = spaces[j];
                        spaces[j] = null;
                        added = true;
                    }
                }
            }
        }
    }

    public String toString() {
        return Arrays.toString(spaces);
    }

    /*
    public static void main(String[] args) {
        Horse a = new ActualHorse("Trigger", 1340);
        Horse b = new ActualHorse("Silver", 1210);
        Horse c = new ActualHorse("Lady", 1575);
        Horse d = new ActualHorse("Patches", 1350);
        Horse e = new ActualHorse("Duke", 1410);
        Horse[] horses = {a, null, b, null, null, d, e};
        HorseBarn horsies = new HorseBarn(horses);
        System.out.println(horsies);
        System.out.println(horsies.findHorseSpace("Trigger"));
        System.out.println(horsies.findHorseSpace("Duke"));
        System.out.println(horsies.findHorseSpace("Max"));
        horsies.consolidate();
        System.out.println(horsies);
    }
    */
}
