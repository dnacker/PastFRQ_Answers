package Q2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestSystemLog {
    List<String> messages;

    @Before
    public void init() {
        messages = new ArrayList<String>();
        messages.add("CLIENT3:security alert - repeated login failures");
        messages.add("Webserver:disk offline");
        messages.add("SERVER1:file not found");
        messages.add("SERVER2:read error on disk DSK1");
        messages.add("SERVER1:write error on disk DSK2");
        messages.add("Webserver:error on /dev/disk");
    }

    @Test
    public void testLogMessageConstructor() {
        for (String msg : messages) {
            LogMessage log = new LogMessage(msg);
            Assert.assertEquals(msg, log.getMachineId() + ":" + log.getDescription());
        }
    }

    @Test
    public void testLogMessageContainsWord() {
        LogMessage log1 = new LogMessage(messages.get(4));
        LogMessage log2 = new LogMessage(messages.get(5));
        Assert.assertTrue(log1.containsWord("disk"));
        Assert.assertTrue(log1.containsWord("DSK2"));
        Assert.assertFalse(log2.containsWord("disk"));
        Assert.assertTrue(log2.containsWord("error"));
    }

    @Test
    public void testRemoveMessagesAfter() {
        SystemLog log = new SystemLog(messages);
        log.removeMessages("disk");
        String correct = "CLIENT3:security alert - repeated login failures\n" +
                "SERVER1:file not found\n" +
                "Webserver:error on /dev/disk\n";
        Assert.assertEquals(correct, log.toString());
    }

    @Test
    public void testRemoveMessagesReturn() {
        SystemLog log = new SystemLog(messages);
        List<LogMessage> disks = log.removeMessages("disk");
        List<String> messages = new ArrayList<String>();
        for (LogMessage msg : disks) {
            messages.add(msg.toString());
        }
        String correct = "Webserver:disk offline\n" +
                "SERVER2:read error on disk DSK1\n" +
                "SERVER1:write error on disk DSK2\n";
        SystemLog log2 = new SystemLog(messages);
        Assert.assertEquals(correct, log2.toString());
    }

}
