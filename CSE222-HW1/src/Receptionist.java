import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Receptionist extends Users {

    /**
     * User constructor
     *
     * @param stringNickname nickname of user
     * @param stringName     name of user
     * @param stringSurname  surname of user
     * @param stringPassword password of user
     */
    public Receptionist(String stringNickname, String stringPassword, String stringName, String stringSurname) {
        super(stringNickname, stringPassword, stringName, stringSurname);
    }


    /**
     * bookRoom
     * @param roomNumber
     * @param guestNickname
     */
    public boolean bookRoom(String roomNumber, String guestNickname) throws Exception {

        List<String> listOfRooms = new ArrayList<String>(); // rooms.csv den veriler alınıp bu arrayliste yazılır.
        List<String> listOfBooks = new ArrayList<String>(); // books.csv den veriler alınıp bu arrayliste yazılır.
        List<String> listOfCheckin = new ArrayList<String>(); // checkin.csv den veriler alınıp bu arrayliste yazılır.

        // rooms.csv den veriler alınır.
        File roomsFile = new File("rooms.csv");
        Scanner scannerForRooms = new Scanner(roomsFile).useDelimiter(";");
        while (scannerForRooms.hasNext())
            listOfRooms.add(scannerForRooms.next());

        // books.csv den veriler alınır.
        File booksFile = new File("books.csv");
        if(booksFile.exists()) {
            Scanner scannerForBooks = new Scanner(booksFile).useDelimiter(";");
            while (scannerForBooks.hasNext())
                listOfBooks.add(scannerForBooks.next());
        }
        else
            booksFile.createNewFile();

        // books.csv den veriler alınır.
        File checkinFile = new File("checkin.csv");
        if(checkinFile.exists()) {
            Scanner scannerForCheckin = new Scanner(checkinFile).useDelimiter(";");
            while (scannerForCheckin.hasNext())
                listOfCheckin.add(scannerForCheckin.next());
        }
        else
            booksFile.createNewFile();

        // Eğer rezervasyon edilmek istenilen oda books.csv de yoksa işlem yapılır, varsa exception fırlatılır.
        int isThereABook=0;
        boolean flag = false;
        for (int i=0; i<listOfRooms.size(); i++) {
            if(listOfRooms.get(i).equals(roomNumber)){
                for (int j = 0; j<listOfBooks.size(); j+=2) {
                    if (listOfBooks.get(j).equals(roomNumber))
                        isThereABook++;
                }

                for (int k=0; k<listOfCheckin.size(); k+=2){
                    if (listOfCheckin.get(k).equals(roomNumber))
                        isThereABook++;
                }

                if(isThereABook == 0){
                    listOfBooks.add(roomNumber);
                    listOfBooks.add(guestNickname);
                    flag = true;
                }
            }
        }

        int invalidRoomNumber = 0;
        for (int i=0; i<listOfRooms.size(); i++){
            if(!(listOfRooms.get(i).equals(roomNumber)))
                invalidRoomNumber++;
        }
        if(invalidRoomNumber == listOfRooms.size())
            System.err.println("Invalid room number");

        if( isThereABook != 0)
            System.err.println("This room is not suitable for bookings");

        if(flag == true)
            System.out.println("Booking was successful");

        // Rezervasyon işlemi tamamlandıktan sonra books.csv tekrar düzenlenir.
        PrintWriter pw = new PrintWriter("books.csv");
        for (int i=0; i<listOfBooks.size(); i++){
            pw.write(listOfBooks.get(i));
            pw.write(";");
        }
        pw.close();

        return flag;
    }

    /**
     * cancelReservation
     * @param roomNumber
     * @param guestNickname
     */
    public boolean cancelReservation(String roomNumber, String guestNickname) throws Exception {

        List<String> listOfBooks = new ArrayList<String>(); // books.csv den veriler alınıp bu arrayliste yazılır.
        boolean flag = false;

        // books.csv den veriler alınır.
        File booksFile = new File("books.csv");
        if(booksFile.exists()) {
            Scanner scannerForBooks = new Scanner(booksFile).useDelimiter(";");
            while (scannerForBooks.hasNext())
                listOfBooks.add(scannerForBooks.next());
        }
        else
            booksFile.createNewFile();

        for (int i=0; i<listOfBooks.size(); i+=2){
            if(listOfBooks.get(i).equals(roomNumber) && listOfBooks.get(i+1).equals(guestNickname)){
                listOfBooks.remove(i);
                listOfBooks.remove(i);
                flag = true;
            }
        }

        // Rezervasyon işlemi tamamlandıktan sonra books.csv tekrar düzenlenir.
        PrintWriter pw = new PrintWriter("books.csv");
        for (int i=0; i<listOfBooks.size(); i++){
            pw.write(listOfBooks.get(i));
            pw.write(";");
        }
        pw.close();

        return flag;
    }

    /**
     *
     * @param roomNumber
     * @param guestNickname
     * @return true or false
     * @throws Exception
     */
    public boolean chechin(String roomNumber, String guestNickname) throws Exception {

        List<String> listOfBooks = new ArrayList<String>(); // books.csv den veriler alınıp bu arrayliste yazılır.
        List<String> listOfCheckin = new ArrayList<String >(); // checkin.csv den verilre alınıp bu arrayliste yazılır.
        boolean flag = false;

        // books.csv den veriler alınır.
        File booksFile = new File("books.csv");
        if(booksFile.exists()) {
            Scanner scannerForBooks = new Scanner(booksFile).useDelimiter(";");
            while (scannerForBooks.hasNext())
                listOfBooks.add(scannerForBooks.next());
        }
        else
            booksFile.createNewFile();


        // checkin.csv den veriler alınır.
        File checkinFile = new File("checkin.csv");
        if(checkinFile.exists()) {
            Scanner scannerForCheckin = new Scanner(checkinFile).useDelimiter(";");
            while (scannerForCheckin.hasNext())
                listOfCheckin.add(scannerForCheckin.next());
        }
        else
            checkinFile.createNewFile();


        int count = 0;
        for (int i=0; i<listOfBooks.size(); i+=2){
            if(listOfBooks.get(i).equals(roomNumber) && listOfBooks.get(i+1).equals(guestNickname)){
                listOfCheckin.add(roomNumber);
                listOfCheckin.add(guestNickname);
                listOfBooks.remove(i);
                listOfBooks.remove(i);
                count++;
                flag = true;
            }
        }

        if(count == 0)
            System.err.println("This room is not reserved for you");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("books.csv", false);

            for (int i=0; i<listOfBooks.size(); i++) {
                fileWriter.append(listOfBooks.get(i));
                fileWriter.append(";");
            }

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check-in işlemi tamamlandıktan sonra checkin.csv tekrar düzenlenir.
        PrintWriter pw = new PrintWriter("checkin.csv");
        for (int i=0; i<listOfCheckin.size(); i++){
            pw.write(listOfCheckin.get(i));
            pw.write(";");
        }
        pw.close();

        return flag;
    }

    /**
     *
     * @param roomNumber
     * @param guestNickname
     * @return true or false
     * @throws Exception
     */
    public boolean checkout(String roomNumber, String guestNickname) throws Exception {

        List<String> listOfCheckin = new ArrayList<String >(); // checkin.csv den verilre alınıp bu arrayliste yazılır.
        boolean flag = false;

        // checkin.csv den veriler alınır.
        File checkinFile = new File("checkin.csv");
        if(checkinFile.exists()) {
            Scanner scannerForCheckin = new Scanner(checkinFile).useDelimiter(";");
            while (scannerForCheckin.hasNext())
                listOfCheckin.add(scannerForCheckin.next());
        }
        else
            checkinFile.createNewFile();


        for (int i=0; i<listOfCheckin.size(); i+=2){
            if(listOfCheckin.get(i).equals(roomNumber) && listOfCheckin.get(i+1).equals(guestNickname)){
                listOfCheckin.remove(i);
                listOfCheckin.remove(i);
                flag = true;
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("checkin.csv", false);

            for (int i = 0; i < listOfCheckin.size(); i++) {
                fileWriter.append(listOfCheckin.get(i));
                fileWriter.append(";");
            }

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * override toString method
     * @return
     */
    @Override
    public String toString()
    {
        return String.format(super.toString());
    }

    /**
     * shows checked-in rooms and reserverd rooms
     * @throws Exception
     */
    @Override
    public void showRooms() throws Exception{

        List<String> listOfCheckin = new ArrayList<String>();
        List<String> listOfBooks = new ArrayList<String >();

        File checkinFile = new File("checkin.csv");
        if(checkinFile.exists()) {
            Scanner scannerForCheckin = new Scanner(checkinFile).useDelimiter(";");
            while (scannerForCheckin.hasNext())
                listOfCheckin.add(scannerForCheckin.next());
        }

        File booksFile = new File("books.csv");
        if(booksFile.exists()) {
            Scanner scannerForBooks = new Scanner(booksFile).useDelimiter(";");
            while (scannerForBooks.hasNext())
                listOfBooks.add(scannerForBooks.next());
        }

        System.out.println("---- List Of Booked Rooms ----");
        for (int i=0; i<listOfBooks.size(); i+=2){
            System.out.println("Room " + listOfBooks.get(i) +  " was booked by " + listOfBooks.get(i+1));
        }

        System.out.println("---- List Of Checked-in Rooms ----");
        for (int i=0; i<listOfCheckin.size(); i+=2){
            System.out.println("Room " + listOfCheckin.get(i) + " was checked-in by " + listOfCheckin.get(i+1));
        }
    }
}
