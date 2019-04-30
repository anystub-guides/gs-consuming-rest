package hello;

import org.anystub.AnyStubId;
import org.anystub.Base;
import org.anystub.RequestMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.anystub.mgmt.BaseManagerImpl.getStub;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AnyStubId(filename = "stub")
public class DataProcessorTest {

    @Autowired
    private DataProcessor dataProcessor;

    @Test
    public void processDataTest() {
        assertEquals(131, dataProcessor.processData());
    }

    @Test
    @AnyStubId
    public void processDataTest2() {
        assertEquals(131, dataProcessor.processData());

        Base base = getStub();

        assertEquals(1, base.times("GET"));
        assertTrue(base.history().findFirst().get().matchEx_to(null, null, ".*gturnquist-quoters.cfapps.io.*"));
    }

    @Test
    @AnyStubId(requestMode = RequestMode.rmTrack)
    public void processDataTest3() {
        assertEquals(79, dataProcessor.processData());
        assertEquals(79, dataProcessor.processData());
        assertEquals(168, dataProcessor.processData());
        assertEquals(79, dataProcessor.processData());

        Base base = getStub();

        assertEquals(4, base.times("GET"));

    }


}