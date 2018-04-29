import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by amd3 on 7.03.2018.
 */
class HotelGuestTest {
    @Test
    void bookRoom() throws IOException {
        HotelGuest guest = new HotelGuest("muzo", "muzo", "muzo", "muzo");
        guest.bookRoom("202", guest.getNickname());

    }

    @Test
    void cancelReservation() throws IOException {
        HotelGuest guest = new HotelGuest("muzo", "muzo", "muzo", "muzo");
        guest.cancelReservation("202", guest.getNickname());
    }

}