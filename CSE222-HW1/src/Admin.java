import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by amd3 on 4.03.2018.
 */
public class Admin extends Users {


    /**
     * User constructor
     *
     * @param stringNickname nickname of user
     * @param stringPassword password of user
     * @param stringName     name of user
     * @param stringSurname  surname of user
     */
    public Admin(String stringNickname, String stringPassword, String stringName, String stringSurname) {
        super(stringNickname, stringPassword, stringName, stringSurname);
    }

    /**
     *
     * @param nickname
     * @param password
     * @param name
     * @param surname
     * @param filename
     * @throws Exception
     */
    public void addUsers(String nickname, String password, String name, String surname, String filename) throws Exception {

        List<String> listForAddRecepcionist = new ArrayList<String>();

        File recepcionistFile = new File(filename);
        if(recepcionistFile.exists()){
            Scanner scannerForRecepcionist = new Scanner(recepcionistFile).useDelimiter(";");

            while (scannerForRecepcionist.hasNext())
                listForAddRecepcionist.add(scannerForRecepcionist.next());

            for (int i=0; i<listForAddRecepcionist.size(); i+=4){
                if(nickname.equals(listForAddRecepcionist.get(i)))
                    throw new Exception("Username is used.");
            }
        }

        listForAddRecepcionist.add(nickname);
        listForAddRecepcionist.add(password);
        listForAddRecepcionist.add(name);
        listForAddRecepcionist.add(surname);

        PrintWriter pw = new PrintWriter(filename);

        for (int i=0; i<listForAddRecepcionist.size(); i++){
            pw.write(listForAddRecepcionist.get(i));
            pw.write(";");
        }

        pw.close();

    }

    @Override
    public void showRooms() {

    }
}
