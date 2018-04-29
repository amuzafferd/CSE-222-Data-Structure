import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by amd3 on 8.03.2018.
 */
class MainTest {
    @Test
    void main() throws Exception{
        final FileInputStream fis = new FileInputStream("cancelReservationTestForGuest.txt");

        System.setIn(fis);
        Main.main(null);

        System.setIn(System.in);
    }

}