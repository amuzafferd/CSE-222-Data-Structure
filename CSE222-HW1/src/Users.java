import java.io.FileNotFoundException;

/**
 * Created by amd3 on 22.02.2018.
 */
public abstract class Users implements UsersInterface {

    private String stringNickname = null;
    private String stringPassword = null;
    private String stringName = null;
    private String stringSurname = null;

    /**
     * User constructor
     * @param stringNickname nickname of user
     * @param stringName name of user
     * @param stringSurname surname of user
     * @param stringPassword password of user
     */
    public Users(String stringNickname, String stringPassword, String stringName, String stringSurname) {
        this.stringNickname = stringNickname;
        this.stringPassword = stringPassword;
        this.stringName = stringName;
        this.stringSurname = stringSurname;
    }

    /**
     * This method gets nickname
     * @return stringNickname
     */
    public String getNickname() { return stringNickname; }

    /**
     * This method gets password
     * @return stringPassword
     */
    public String getPassword() { return stringPassword; }

    /**
     * This method gets name
     * @return stringName
     */
    public String getName(){ return stringName; }

    /**
     * This method gets surname
     * @return stringSurname
     */
    public String getSurname() { return stringSurname; }

    @Override
    public String toString() {
        return  String.format(  "nickname: " + getNickname() + "\n" +
                                "password: " + getPassword() + "\n" +
                                "name    : " + getName() + "\n" +
                                "surname : " + getSurname()
                              );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users user = (Users) o;

        if (!stringNickname.equals(user.stringNickname)) return false;
        if (!stringName.equals(user.stringName)) return false;
        if (!stringSurname.equals(user.stringSurname)) return false;
        return stringPassword.equals(user.stringPassword);
    }

    /**
     Will be override
     */
    public abstract void showRooms() throws Exception;


}
