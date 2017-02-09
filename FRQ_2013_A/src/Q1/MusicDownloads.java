package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MusicDownloads Class.
 * Write solutions here.
 */
public class MusicDownloads {
    /** The list of downloaded information.
     * Guaranteed not to be null and not to contain duplicate titles.
     */
    private List<DownloadInfo> downloadList;

    /** Creates the list of downloaded information. */
    public MusicDownloads(List<DownloadInfo> songs) {
        downloadList = songs;
    }

    /** Returns a reference to the DownloadInfo object with the requested title if it exists.
     * @param title the requested title
     * @return a reference to the DownloadInfo object with the
     * title that matches the parameter title if it exists in the list;
     * null otherwise.
     * Postcondition:
     * - no changes were made to downloadList.
     */
    public DownloadInfo getDownLoadInfo(String title) {
        for (DownloadInfo dl : downloadList) {
            if (dl.getTitle().equals(title)) {
                return dl;
            }
        }
        return null;
    }

    /** Updates downloadList with information from titles.
     * @param titles a list of song titles
     * Postcondition:
     * - there are no duplicate titles in downloadList.
     * - no entries were removed from downloadList.
     * - all songs in titles are represented in downloadList.
     * - for each existing entry in downloadList, the download count is increased by
     * the number of times its title appeared in titles.
     * - the order of the existing entries in downloadList is not changed.
     * - the first time an object with a title from titles is added to downloadList, it
     * is added to the end of the list.
     * - new entries in downloadList appear in the same order
     * in which they first appear in titles.
     * - for each new entry in downloadList, the download count is equal to
     * the number of times its title appeared in titles.
     */
    public void updateDownloads(List<String> titles) {
        for (String title : titles) {
            if (getDownLoadInfo(title) == null) {
                downloadList.add(new DownloadInfo(title));
            } else {
                getDownLoadInfo(title).incrementTimesDownloaded();
            }
        }
    }

    public String toString() {
        return downloadList.toString();
    }

    /*
    public static void main(String[] args) {
        DownloadInfo jude = new DownloadInfo("Hey Jude");
        for (int i = 0; i < 4; i++) {
            jude.incrementTimesDownloaded();
        }
        DownloadInfo sister = new DownloadInfo("Soul Sister");
        for (int i = 0; i < 2; i++) {
            sister.incrementTimesDownloaded();
        }
        DownloadInfo lung = new DownloadInfo("Aqualung");
        for (int i = 0; i < 9; i++) {
            lung.incrementTimesDownloaded();
        }
        List<DownloadInfo> songs = new ArrayList<DownloadInfo>();
        songs.add(jude);
        songs.add(sister);
        songs.add(lung);

        MusicDownloads webMusicA = new MusicDownloads(songs);

        System.out.println(webMusicA);
        System.out.println(webMusicA.getDownLoadInfo("Soul Sister"));
        System.out.println(webMusicA.getDownLoadInfo("Buggy"));

        List<String> songTitles = Arrays.asList("Lights", "Aqualung", "Soul Sister", "Go Now", "Lights", "Soul Sister");
        webMusicA.updateDownloads(songTitles);
        System.out.println(webMusicA);
    }
    */
}
