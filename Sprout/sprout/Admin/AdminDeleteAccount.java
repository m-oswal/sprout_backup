package sprout.Admin;

import sprout.DBConnection;
import javax.swing.JOptionPane;

public class AdminDeleteAccount{
    int input;
    public AdminDeleteAccount(){
            input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(input == 0){
                try{
                    DBConnection c1 = new DBConnection();

                    String q = "Delete From Admin Where Adminid ='" + AdminLogin.currentAdminID + "'";

                    int x = c1.s.executeUpdate(q);
                    if(x == 0){
                        JOptionPane.showMessageDialog(null, "Got some error");
                    }else{
                        JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
                        
                    }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error deleting account. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                }
            }
        
        }
    public static void main(String[] args) {
        new AdminDeleteAccount();
    }
}