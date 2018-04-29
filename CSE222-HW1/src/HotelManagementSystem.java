import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HotelManagementSystem {

    public void run() {

        boolean status = true;

        Scanner input = new Scanner(System.in);
        while (status) {
            try {
                System.out.println("-----------------------------------");
                System.out.println("----- HOTEL MANAGEMENT SYSTEM -----");
                System.out.println("-----------------------------------");
                System.out.println("Press a or A for Admin\nPress r or R for Receptionist\nPress g or G Hotel Guest");
                System.out.print("Your choice: ");
                String choice = input.nextLine();

                if (choice.equals("a") || choice.equals("A")) {
                    Admin admin = new Admin("admin", "admin", "admin", "admin");
                    System.out.println("Information of Admin");
                    System.out.println("Username: admin");
                    System.out.println("Password: admin");
                    System.out.print("NICKNAME : ");
                    String nickname = input.nextLine();
                    System.out.print("PASSWORD : ");
                    String password = input.nextLine();

                    if (nickname.equals(admin.getNickname()) && password.equals(admin.getPassword())) {
                        System.out.println("1 --> Add recepcionist");
                        System.out.println("2 --> Add hotel guest");
                        choice = input.nextLine();
                        System.out.print("NICKNAME : ");
                        String userNickname = input.nextLine();
                        System.out.print("PASSWORD : ");
                        String userPassword = input.nextLine();
                        System.out.print("NAME : ");
                        String userName = input.nextLine();
                        System.out.print("SURNAME : ");
                        String userSurname = input.nextLine();
                        if (choice.equals("1")) {
                            List<String> listOfReceptionist = new ArrayList<String>();

                            File receptionistFile = new File("receptionist.csv");
                            if(receptionistFile.exists()) {
                                Scanner scannerForReceptionist = new Scanner(receptionistFile).useDelimiter(";");
                                while (scannerForReceptionist.hasNext())
                                    listOfReceptionist.add(scannerForReceptionist.next());
                            }
                            else
                                receptionistFile.createNewFile();
                            int count = 0;
                            for (int i=0; i<listOfReceptionist.size(); i+=4) {
                                if(listOfReceptionist.get(i).equals(userNickname))
                                    count++;
                            }
                            if(count == 0)
                                admin.addUsers(userNickname, userPassword, userName, userSurname, "receptionist.csv");
                            else
                                System.err.println("This nickname can not be used");
                        } else if (choice.equals("2")) {
                            List<String> listOfGuest = new ArrayList<String>();
                            File guestFile = new File("guests.csv");
                            if(guestFile.exists()) {
                                Scanner scannerForGuest = new Scanner(guestFile).useDelimiter(";");
                                while (scannerForGuest.hasNext())
                                    listOfGuest.add(scannerForGuest.next());
                            }
                            else
                                guestFile.createNewFile();
                            int count = 0;
                            for (int i=0; i<listOfGuest.size(); i+=4) {
                                if(listOfGuest.get(i).equals(userNickname))
                                    count++;
                            }
                            if(count == 0)
                                admin.addUsers(userNickname, userPassword, userName, userSurname, "guests.csv");
                            else
                                System.err.println("This nickname can not be used");

                        } else
                            throw new Exception("Invalid value");
                    }
                } else if (choice.equals("r") || choice.equals("R")) {
                    System.out.print("NICKNAME : ");
                    String nickname = input.nextLine();
                    System.out.print("PASSWORD : ");
                    String password = input.nextLine();

                    File receptionistFile = new File("receptionist.csv");
                    if (receptionistFile.exists()) {
                        Scanner scannerForEnterReceptionist = new Scanner(receptionistFile).useDelimiter(";");
                        List<String> listForReceptionist = new ArrayList<String>();

                        while (scannerForEnterReceptionist.hasNext())
                            listForReceptionist.add(scannerForEnterReceptionist.next());

                        int count = 0;
                        for (int i = 0; i<listForReceptionist.size(); i += 4) {
                            if (nickname.equals(listForReceptionist.get(i)) && password.equals(listForReceptionist.get(i + 1))) {
                                count++;
                                Receptionist receptionist = new Receptionist(listForReceptionist.get(i),
                                        listForReceptionist.get(i + 1),
                                        listForReceptionist.get(i + 2),
                                        listForReceptionist.get(i + 3));

                                System.out.println("1 --> Reservation");
                                System.out.println("2 --> Reservation cancel");
                                System.out.println("3 --> Check-in");
                                System.out.println("4 --> Check-out");
                                System.out.println("5 --> Show booked and checked-in rooms");
                                choice = input.nextLine();

                                if (choice.equals("1")) {
                                    System.out.println("Enter the room number you wish to reservation");
                                    String roomNumber = input.nextLine();
                                    System.out.println("Enter the guest nickname");
                                    String guestNick = input.nextLine();

                                    receptionist.bookRoom(roomNumber, guestNick);
                                } else if (choice.equals("2")) {
                                    System.out.println("Enter the room number you wish to cancel the reservation");
                                    String roomNumber = input.nextLine();
                                    System.out.println("Enter the guest nickname");
                                    String guestNick = input.nextLine();

                                    receptionist.cancelReservation(roomNumber, guestNick);
                                } else if (choice.equals("3")) {
                                    System.out.println("Enter the room number you wish to check-in");
                                    String roomNumber = input.nextLine();
                                    System.out.println("Enter the guest nickname");
                                    String guestNick = input.nextLine();

                                    receptionist.chechin(roomNumber, guestNick);
                                } else if (choice.equals("4")) {
                                    System.out.println("Enter the room number you wish to check-out");
                                    String roomNumber = input.nextLine();
                                    System.out.println("Enter the guest nickname");
                                    String guestNick = input.nextLine();

                                    receptionist.checkout(roomNumber, guestNick);
                                } else if(choice.equals("5")){
                                    receptionist.showRooms();
                                } else
                                    throw new Exception("Invalid value");
                            }


                        }
                    }
                } else if (choice.equals("g") || choice.equals("G")) {
                    System.out.print("NICKNAME : ");
                    String nickname = input.nextLine();
                    System.out.print("PASSWORD : ");
                    String password = input.nextLine();

                    File guestsFile = new File("guests.csv");
                    if (guestsFile.exists()) {
                        Scanner scannerForEnterGuest = new Scanner(guestsFile).useDelimiter(";");
                        List<String> listForGuest = new ArrayList<String>();

                        while (scannerForEnterGuest.hasNext())
                            listForGuest.add(scannerForEnterGuest.next());

                        int count = 0;
                        for (int i = 0; i< listForGuest.size(); i+=4) {
                            if (nickname.equals(listForGuest.get(i)) && password.equals(listForGuest.get(i + 1))) {
                                count++;
                                HotelGuest guest = new HotelGuest(listForGuest.get(i),
                                        listForGuest.get(i + 1),
                                        listForGuest.get(i + 2),
                                        listForGuest.get(i + 3));

                                System.out.println("1 --> Reservation");
                                System.out.println("2 --> Reservation cancel");
                                System.out.println("3 --> Show booked rooms");
                                choice = input.nextLine();

                                if (choice.equals("1")) {
                                    System.out.println("Enter the room number you wish to reservation");
                                    String roomNumber = input.nextLine();

                                    guest.bookRoom(roomNumber, guest.getNickname());
                                } else if (choice.equals("2")) {
                                    System.out.println("Enter the room number you wish to cancel the reservation");
                                    String roomNumber = input.nextLine();

                                    guest.cancelReservation(roomNumber, guest.getNickname());
                                }
                                else if(choice.equals("3")){
                                    guest.showRooms();
                                } else
                                    throw new Exception("Invalid value");
                            }
                        }
                    }
                } else
                    throw new Exception("Invalid value!");

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println("Do you want to do anything else? (y or n)");
            String continueChoice = input.nextLine();

            if(!continueChoice.equals("y") && !continueChoice.equals("Y"))
                status = false;
        }
    }
}
