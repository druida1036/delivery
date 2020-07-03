package co.com.s4n.delivery.drone;

import co.com.s4n.delivery.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest({FileUtil.class, DroneOperator.class})
public class DroneOperatorTest {

    @Test
    public void processWithDroneAvailable() throws Exception {
        mockStatic(FileUtil.class);
        when(FileUtil.readDirectoryFiles(anyString())).thenReturn(Collections.singletonList("in01.txt"));
        when(FileUtil.readFile(anyString())).thenReturn(Collections.singletonList("AAAAA"));

        DroneOperator operator = PowerMockito.spy(new DroneOperator(20,"","",3));
        Drone dron = spy(new Drone(3));
        when(dron.deliver(anyList())).thenReturn(Collections.singletonList("result"));
        PowerMockito.when(operator, "getFreeDrone").thenReturn(dron);

        operator.process();
        PowerMockito.verifyStatic(VerificationModeFactory.times(1));
        FileUtil.readDirectoryFiles(anyString());

        PowerMockito.verifyStatic(VerificationModeFactory.times(1));
        FileUtil.readFile(anyString());

        PowerMockito.verifyStatic(VerificationModeFactory.times(1));
        FileUtil.writeFile(anyString(), anyString(), anyList());
    }

    @Test(expected = RuntimeException.class)
    public void processWhenNotDroneAvailable() throws Exception {
        mockStatic(FileUtil.class);

        when(FileUtil.readDirectoryFiles(anyString())).thenReturn(Collections.singletonList("in01.txt"));
        when(FileUtil.readFile(anyString())).thenReturn(Collections.singletonList("AAAA"));

        DroneOperator operator = PowerMockito.spy(new DroneOperator(20,"","",3));
        Drone dron = spy(new Drone(3));
        when(dron.deliver(anyList())).thenReturn(Collections.singletonList("result"));
        PowerMockito.when(operator, "getFreeDrone").thenThrow(new RuntimeException(""));

        operator.process();
    }

}