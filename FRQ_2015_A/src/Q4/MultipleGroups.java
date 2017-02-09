package Q4;

import java.util.List;

/**
 *
 */
public class MultipleGroups {
    private List<NumberGroup> groupList;

    public MultipleGroups(List<NumberGroup> groups) {
        groupList = groups;
    }

    /** Returns true if at least one of the number groups in this multiple group contains num;
     * false otherwise.
     */
    public boolean contains(int num) {
        for (NumberGroup group: groupList) {
            if (group.contains(num)) {
                return true;
            }
        }
        return false;
    }
}
