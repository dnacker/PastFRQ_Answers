package Q2;

/**
 * Created by daackerman on 1/24/2017.
 */
public class LogMessage {
    private String machineId;
    private String description;

    /** Precondition: message is a valid log message. */
    public LogMessage(String message) {
        machineId = message.substring(0, message.indexOf(":"));
        description = message.substring(message.indexOf(":") + 1);
    }

    /** Returns true if the description in this log message properly contains keyword
     *          false otherwise.
     */
    public boolean containsWord(String keyword) {
        if (description.equals(keyword)) {
            return true;
        } else if (description.indexOf(keyword + " ") == 0){
            return true;
        } else if (description.indexOf(" " + keyword) == description.length() - keyword.length() - 1) {
            return true;
        } else if (description.indexOf(" " + keyword + " ") != -1) {
            return true;
        }
        return false;
    }


    public String getMachineId() {
        return machineId;
    }
    public String getDescription() {
        return description;
    }
    public String toString() {
        return machineId + ":" + description;
    }
}
