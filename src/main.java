import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class main implements ActionListener {
    JFrame loginframe = new JFrame();
    JLabel loginlabel = new JLabel();
    JLabel passwordlabel = new JLabel();
    JTextField login = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton loginbtn = new JButton();
    JButton canclebtn = new JButton();

    public main(){
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setSize(500,500);
        loginframe.setResizable(false);
        loginframe.getContentPane().setBackground(Color.LIGHT_GRAY);
        loginframe.setLayout(null);
        loginframe.setTitle("login page");
        loginframe.setVisible(true);

        loginlabel.setBounds(100,150,100,50);
        loginlabel.setBackground(Color.LIGHT_GRAY);
        loginlabel.setForeground(new Color(37, 77, 37));
        loginlabel.setText("Login ID");
        loginlabel.setFont(new Font("Serif",Font.BOLD,20));
        loginframe.add(loginlabel);

        login.setBounds(200,160,150,30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        loginframe.add(login);

        passwordlabel.setBounds(100,200,100,50);
        passwordlabel.setBackground(Color.LIGHT_GRAY);
        passwordlabel.setForeground(new Color(37, 77, 37));
        passwordlabel.setText("Password");
        passwordlabel.setFont(new Font("Serif",Font.BOLD,20));
        loginframe.add(passwordlabel);

        password.setBounds(200,210,150,30);
        password.setBackground(Color.WHITE);
        password.setForeground(Color.BLACK);
        loginframe.add(password);

        loginbtn.setBounds(120,260,100,30);
        loginbtn.setText("login");
        loginbtn.setBackground(Color.WHITE);
        loginbtn.setForeground(Color.BLACK);
        loginbtn.addActionListener(this);
        loginframe.add(loginbtn);

        canclebtn.setBounds(230,260,100,30);
        canclebtn.setText("cancel");
        canclebtn.setForeground(Color.BLACK);
        canclebtn.setBackground(Color.WHITE);
        canclebtn.addActionListener(this);
        loginframe.add(canclebtn);


    }
    public static void main(String[] args) {
                new main();


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginbtn){
            String loginidval = login.getText();
            String passwordval = String.valueOf(password.getPassword());
           boolean ans =  loginserver(loginidval,passwordval);
           if(ans){
               loginframe.dispose();
                new quizclass();
           }
           else{
               JOptionPane.showMessageDialog(loginframe, "Sorry either of your login id or password is incorrect",
                       "Error", JOptionPane.WARNING_MESSAGE);
           }
        }
        if(e.getSource() == canclebtn){
            System.exit(0);
        }

    }

    private  boolean loginserver(String loginid ,String password){

        HashMap <String,String> map = new HashMap<>();
        map.put("saikrishna","sai12345");
        map.put("romeo","juliet");
        map.put("123456789","987654321");
        boolean ans = false;
        if(map.containsKey(loginid)){
            if(map.get(loginid).equals(password)){
                ans = true;
            }
        }
        return ans;
    }
}
