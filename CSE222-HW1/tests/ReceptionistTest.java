import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by amd3 on 7.03.2018.
 */
class ReceptionistTest {
    @Test
    void chechin() throws Exception {
        Receptionist receptionist = new Receptionist("muzo", "muzo", "muzo", "muzo");
        assertTrue(receptionist.chechin("103","fati"));
    }

    @Test
    void checkout() throws Exception {
        Receptionist receptionist = new Receptionist("muzo", "muzo", "muzo", "muzo");
        assertTrue(receptionist.checkout("103", "fati"));
    }

    @Test
    void bookRoom() throws Exception {
        Receptionist receptionist = new Receptionist("muzo", "muzo", "muzo", "muzo");
        assertTrue(receptionist.bookRoom("301", "ozgur"));
    }

    @org.junit.jupiter.api.Test
    void cancelReservation() throws Exception {
        Receptionist receptionist = new Receptionist("muzo", "muzo", "muzo", "muzo");
        assertTrue(receptionist.cancelReservation("301", "ozgur"));
    }

}