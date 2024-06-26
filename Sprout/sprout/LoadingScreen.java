package sprout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class LoadingScreen extends JFrame{
    JPanel mainPanel;
    JProgressBar loadingBar;
    JLabel backgroundPic, upperPic, textLbl, loadingLbl, percentageLbl;
    public LoadingScreen(){
        super("E-Learning System");
        setSize(1280,720);
        setLocation(35,30);
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel, BorderLayout.CENTER);

        loadingLbl = new JLabel("Loading...");
        loadingLbl.setHorizontalAlignment(JLabel.LEFT);
        loadingLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        loadingLbl.setForeground(Color.WHITE);
        loadingLbl.setBounds(5, 630, 250, 30);

        percentageLbl = new JLabel("0 %");
        percentageLbl.setHorizontalAlignment(JLabel.RIGHT);
        percentageLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        percentageLbl.setForeground(Color.WHITE);
        percentageLbl.setBounds(1160, 630, 100, 30);

        mainPanel.add(loadingLbl);
        mainPanel.add(percentageLbl);

        textLbl = new JLabel("Welcome To E-Learning System");
        textLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 55));
        textLbl.setForeground(Color.WHITE);
        textLbl.setBounds(245, 420, 850, 80);
        mainPanel.add(textLbl);

        backgroundPic = new JLabel();
        backgroundPic.setIcon(new ImageIcon(ClassLoader.getSystemResource("sprout/icons/logo-color.png")));
        backgroundPic.setBounds(0, 0, getWidth(), getHeight()); // Set bounds to match JFrame size
        mainPanel.add(backgroundPic);


        loadingBar = new JProgressBar();
        loadingBar.setPreferredSize(new Dimension(0, 25));
        loadingBar.setValue(0);
        loadingBar.setStringPainted(true);
        loadingBar.setForeground(Color.GREEN);
        add(loadingBar, BorderLayout.SOUTH);

        // Settings for the frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Run();
    }
    public void Run(){
        try{
            for(int i=0; i<=100; i++){
                Thread.sleep(10);
                loadingBar.setValue(i);
                percentageLbl.setText(i+ " %");

                if(i==10){
                    loadingLbl.setText("Turning On Modules...");
                }
                else if(i==20){
                    loadingLbl.setText("Loading Modules...");
                }
                else if(i==50){
                    loadingLbl.setText("Connecting to Database...");
                }
                else if(i==70){
                    loadingLbl.setText("Connection Successfull !");
                }
                else if(i==80){
                    loadingLbl.setText("Lauching Application...");
                }
                else if(i==100){
                    new Main();
                    dispose();
                }
            }
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception);
        }
    }
    public static void main(String[] args) {
        new LoadingScreen();
    }

}
