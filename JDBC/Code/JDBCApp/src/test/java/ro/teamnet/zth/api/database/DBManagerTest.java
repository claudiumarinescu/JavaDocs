package ro.teamnet.zth.api.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Claudiu.Marinescu on 7/13/2017.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection() {
        Connection conn = DBManager.getConnection();
        Assert.assertNotNull("Connection should not be null!", conn);
    }

    @Test
    public void testCheckConnection() {
        Connection conn = DBManager.getConnection();
        Assert.assertEquals("CheckConnection should return 0!", 0, DBManager.checkConnection(conn));
    }

}
