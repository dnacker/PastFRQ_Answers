package Q1;

/**
 * DownloadInfo Class
 */
public class DownloadInfo {
    private String title;
    private int timesDownloaded;

    /** Creates a new instance with the given unique title and sets the
     * number of times downloaded to 1.
     * @param title the unique title of the downloaded song
     */
    public DownloadInfo(String title) {
        this.title = title;
        timesDownloaded = 1;
    }

    /** @return the title */
    public String getTitle() {
        return title;
    }

    /** Increment the number times downloaded by 1 */
    public void incrementTimesDownloaded() {
        timesDownloaded++;
    }



    /**IGNORE CODE BELOW (for testing purposes) */
    public String toString() {
        return "[" + title + ", " + timesDownloaded + "]";
    }
    public DownloadInfo(String title, int times) {
        this.title = title;
        timesDownloaded = times;
    }
}
