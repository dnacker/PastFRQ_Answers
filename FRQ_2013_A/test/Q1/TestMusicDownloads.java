package Q1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by david on 1/23/2017.
 */
public class TestMusicDownloads {
    private MusicDownloads webMusic;

    @Before
    public void init() {
        DownloadInfo jude = new DownloadInfo("Hey Jude", 5);
        DownloadInfo sister = new DownloadInfo("Soul Sister", 3);
        DownloadInfo lung = new DownloadInfo("Aqualung", 10);
        List<DownloadInfo> songs = new ArrayList<DownloadInfo>();
        songs.add(jude);
        songs.add(sister);
        songs.add(lung);
        webMusic = new MusicDownloads(songs);
    }

    @Test
    public void testGetDownoadInfoThere() {
        Assert.assertEquals("[Soul Sister, 3]", webMusic.getDownLoadInfo("Soul Sister").toString());
    }

    @Test
    public void testGetDownloadInfoNotThere() {
        Assert.assertEquals(null, webMusic.getDownLoadInfo("My Iron Lung"));
    }

    @Test
    public void testUpdateDownloads() {
        List<String> songTitles = Arrays.asList("Lights", "Aqualung", "Soul Sister", "Go Now", "Lights", "Soul Sister");
        webMusic.updateDownloads(songTitles);
        Assert.assertEquals("[[Hey Jude, 5], [Soul Sister, 5], [Aqualung, 11], [Lights, 2], [Go Now, 1]]", webMusic.toString());
    }


}
