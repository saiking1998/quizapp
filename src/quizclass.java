import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;


public class quizclass implements ActionListener{
    int numberofques= 5;
    public String[] questions =new String[numberofques];
    String[][] answers = new String[numberofques][4];
    char [] selections =new char[numberofques];

    char guess;
    char ans;
    int index;
    int correctans =0;
    int totalques = questions.length;
    int result;
    int seconds=10;
    JFrame frame = new JFrame();
    JTextField field = new JTextField();
    JTextArea area = new JTextArea();
    JButton buttona = new JButton();
    JButton buttonb = new JButton();
    JButton buttonc = new JButton();
    JButton buttond = new JButton();
    JLabel anslabela = new JLabel();
    JLabel anslabelb = new JLabel();
    JLabel anslabelc = new JLabel();
    JLabel anslabeld = new JLabel();
    JLabel timelabel = new JLabel();
    JLabel secondlabel = new JLabel();
    JTextField numright = new JTextField();
    JTextField percentage = new JTextField();
    boolean yes  =true;
    Timer time = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            seconds--;
            secondlabel.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayans();
            }
        }
    });
     public quizclass(){

         questoions ques = new questoions();
         if(yes == true){
             ques.setpaper(questions,answers,selections,numberofques);
             yes = false;
         }
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(750,750);
         frame.getContentPane().setBackground(new Color(55,55,55));
         frame.setLayout(null);
         frame.setResizable(false);
         field.setBounds(20,0,700,50);
         field.setBackground(new Color(29, 64, 99));
         field.setForeground(Color.BLACK);
         field.setFont(new Font("Ink Free",Font.BOLD,33));
         field.setBorder(BorderFactory.createBevelBorder(1));
         field.setHorizontalAlignment(JTextField.CENTER);
         field.setEditable(false);;
         frame.add(field);

         area.setBounds(20,50,700,100);
         area.setLineWrap(true);
         area.setWrapStyleWord(true);
         area.setBackground(Color.BLACK);
         area.setForeground(Color.green);
         area.setFont(new Font("MV Boli",Font.BOLD,33));
         area.setBorder(BorderFactory.createBevelBorder(1));
         frame.add(area);


         buttona.setBounds(5,160,100,100);
         buttona.setFont(new Font("Ink Free",Font.BOLD,40));
         buttona.setFocusable(false);
         buttona.addActionListener(this);
         buttona.setText("A");
         frame.add(buttona);


         buttonb.setBounds(5,270,100,100);
         buttonb.setFont(new Font("Ink Free",Font.BOLD,40));
         buttonb.setFocusable(false);
         buttonb.addActionListener(this);
         buttonb.setText("B");
         frame.add(buttonb);


         buttonc.setBounds(5,380,100,100);
         buttonc.setFont(new Font("Ink Free",Font.BOLD,40));
         buttonc.setFocusable(false);
         buttonc.addActionListener(this);
         buttonc.setText("C");
         frame.add(buttonc);


         buttond.setBounds(5,490,100,100);
         buttond.setFont(new Font("Ink Free",Font.BOLD,40));
         buttond.setFocusable(false);
         buttond.addActionListener(this);
         buttond.setText("D");
         frame.add(buttond);

         anslabela.setBounds(125,160,600,100);
         anslabela.setBackground(Color.BLACK);
         anslabela.setForeground(Color.GREEN);
         anslabela.setFont(new Font("Ink Free",Font.PLAIN,25));
         frame.add(anslabela);

         anslabelb.setBounds(125,270,600,100);
         anslabelb.setBackground(Color.BLACK);
         anslabelb.setForeground(Color.GREEN);
          anslabelb.setFont(new Font("Ink Free",Font.PLAIN,25));
         frame.add(anslabelb);

         anslabelc.setBounds(125,380,600,100);
         anslabelc.setBackground(Color.BLACK);
         anslabelc.setForeground(Color.GREEN);
         anslabelc.setFont(new Font("Ink Free",Font.PLAIN,25));
         frame.add(anslabelc);

         anslabeld.setBounds(125,490,600,100);
         anslabeld.setBackground(Color.BLACK);
         anslabeld.setForeground(Color.GREEN);
         anslabeld.setFont(new Font("Ink Free",Font.PLAIN,25));
         frame.add(anslabeld);

         secondlabel.setBounds(550,610,100,100);
         secondlabel.setBackground(new Color(168, 113, 50));
         secondlabel.setForeground(new Color(227, 0, 0));
         secondlabel.setBorder(BorderFactory.createStrokeBorder( new BasicStroke(6.0f)));
         secondlabel.setFont(new Font("Ink Free",Font.ROMAN_BASELINE,70));
         secondlabel.setHorizontalAlignment(JTextField.CENTER);
         secondlabel.setVerticalAlignment(JTextField.CENTER);
         secondlabel.setText(String.valueOf(seconds));
         frame.add(secondlabel);

         timelabel.setBounds(540,585,100,30);
         timelabel.setBackground(Color.BLACK);
         timelabel.setForeground(Color.red);
         timelabel.setFont(new Font("Ink Free",Font.ITALIC,25));

         timelabel.setHorizontalAlignment(JTextField.CENTER);
         timelabel.setText("Timer");
         frame.add(timelabel);

         numright.setBounds(300,325,250,100);
         numright.setBackground(Color.LIGHT_GRAY);
         numright.setForeground(new Color(35, 84, 30));
         numright.setFont(new Font("Dialog BOLDITALIC",Font.PLAIN,40));
         numright.setBorder(BorderFactory.createBevelBorder(1));
         numright.setHorizontalAlignment(JTextField.CENTER);
         numright.setEditable(false);
//         numright.setText("your score: 5");
//         frame.add(numright);

         percentage.setBounds(300,425,250,100);
         percentage.setBackground(Color.LIGHT_GRAY);
         percentage.setForeground(new Color(35, 84, 30));
         percentage.setFont(new Font("Dialog BOLDITALIC",Font.PLAIN,40));
         percentage.setBorder(BorderFactory.createBevelBorder(1));
         percentage.setHorizontalAlignment(JTextField.CENTER);
         percentage.setEditable(false);
//         percentage.setText("65.232");
//         frame.add(percentage);

         area.setEditable(false);;
         frame.setVisible(true);
         nextques();
    }
    public void nextques(){
     if(index>=totalques){
         results();
     }
     else{
         field.setText("Question"+(index+1));
         area.setText(questions[index]);
         anslabela.setText(answers[index][0]);
         anslabelb.setText(answers[index][1]);
         anslabelc.setText(answers[index][2]);
         anslabeld.setText(answers[index][3]);
         time.start();
     }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttona.setEnabled(false);
        buttonb.setEnabled(false);
        buttonc.setEnabled(false);
        buttond.setEnabled(false);

        if(e.getSource()==buttona){
            ans = 'A';
            if(ans == selections[index]){
                correctans++;
            }
        }
        if(e.getSource()==buttonb){
            ans = 'B';
            if(ans == selections[index]){
                correctans++;
            }
        }
        if(e.getSource()==buttonc){
            ans = 'C';
            if(ans == selections[index]){
                correctans++;
            }
        }
        if(e.getSource()==buttond){
            ans = 'D';
            if(ans == selections[index]){
                correctans++;
            }
        }
        displayans();
    }

    public void displayans(){
         time.stop();
        buttona.setEnabled(false);
        buttonb.setEnabled(false);
        buttonc.setEnabled(false);
        buttond.setEnabled(false);

        if(selections[index]!='A'){
            anslabela.setForeground(Color.red);
        }
        if(selections[index]!='B'){
            anslabelb.setForeground(Color.red);
        }
        if(selections[index]!='C'){
            anslabelc.setForeground(Color.red);
        }
        if(selections[index]!='D'){
            anslabeld.setForeground(Color.red);
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                anslabela.setForeground(Color.green);
                anslabelb.setForeground(Color.green);
                anslabelc.setForeground(Color.green);
                anslabeld.setForeground(Color.green);
                ans =' ';
                seconds =10;
                secondlabel.setText(String.valueOf(seconds));
                buttona.setEnabled(true);
                buttonb.setEnabled(true);
                buttonc.setEnabled(true);
                buttond.setEnabled(true);
                index++;
                nextques();

            }
        });
        pause.setRepeats(false);
    pause.start();
    }
    public void results(){
       buttona.setEnabled(false);
        buttonb.setEnabled(false);
        buttonc.setEnabled(false);
        buttond.setEnabled(false);
        result =(int)((correctans/(double)totalques) *100);
         field.setText("*** RESULTS ***");

         if(result == 100){
             area.setText("!wow you got it all right");
         }
         else if(result>=75 && result<100){
             area.setText("you are on track keep learning");
         }
         else if(result>=50 && result<75){
             area.setText("you are doing ok but need more practice");
         }
         else if(result>=25 && result<50){
             area.setText("you are lagging behind prepare well for next test");
         }
         else{
             area.setText("oh no you are not performing good concentrate on studies !!!");
         }
         anslabela.setText("");
        anslabelb.setText("");
        anslabelc.setText("");
        anslabeld.setText("");
          timelabel.setVisible(false);
          secondlabel.setVisible(false);
        numright.setText("("+correctans+"/"+totalques+")");
        percentage.setText(result+"%");
        frame.add(percentage);
        frame.add(numright);
    }

}
