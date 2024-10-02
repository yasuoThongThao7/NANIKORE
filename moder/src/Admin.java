public class Admin {
    private String username = "admin";
    private String password = "123456789";

    private static Admin ADMIN_INSTANCE;

    public static Admin getInstance(){

        if(ADMIN_INSTANCE == null){

            ADMIN_INSTANCE = new Admin();

        }
       return ADMIN_INSTANCE;
    }

    public boolean check(String username, String password){
        if(this.username.equals(username) && this.password.equals(password))
            return true;

        return false;
    }

    public void setAdminInstance(String username, String password){
        this.password = password;
        this.username = username;
    }
}
class MakeID{
    private static String summaryName(String name){
        String[] s = name.split("\\s+");
        String summary = "";
        for(int i = 0; i < s.length; i++){
            summary += Character.toUpperCase(s[i].charAt(0));
        }
        return summary;
    }

    public static String makeID(String name,String suppliersName,int cnt){
        StringBuilder builder = new StringBuilder();
        builder.append(summaryName(name)).append("-").append(summaryName(suppliersName)).append(cnt);
        String ID = builder.toString();
        return ID;
    }

    public static String makeID(String suppliersName,int cnt){
        StringBuilder builder = new StringBuilder();
        builder.append("ID-").append(summaryName(suppliersName)).append("-").append(cnt);
        String ID = builder.toString();
        return ID;
    }
}
