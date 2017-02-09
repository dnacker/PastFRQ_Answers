package Q3;

/**
 * Implementation of Horse interface.
 * IGNORE THIS CLASS.
 */
public class ActualHorse implements Horse {
    private String name;
    private int weight;

    public ActualHorse(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "[" + name + ", " + weight + "]";
    }
}
