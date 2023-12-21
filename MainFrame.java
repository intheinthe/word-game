import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfNextWord; 
    JLabel lbList;
    private static ArrayList<String> words = new ArrayList<String>();
    private static String nextWord = new String("");
    int scoreInt = 0;
    // String randLet;
    // Create a Random object
    Random random = new Random();

    // ASCII values for uppercase letters 'A' to 'Z'
    int asciiA = (int) 'A';
    int asciiZ = (int) 'Z';

    char randLet;

    public static ArrayList<String> getWords(){
        return words;
    }

    public static String getNextWord(){
        return nextWord;
    }

    public void initialize() {
        //***FORM PANEL***
        JLabel lbNextWord = new JLabel("Next Word");
        lbNextWord.setFont(mainFont);

        tfNextWord = new JTextField();
        tfNextWord.setFont(mainFont);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbNextWord);
        formPanel.add(tfNextWord);

        //***LIST LABEL***
        JTextArea textArea = new JTextArea(20, 20);
        // JTextArea textArea2 = new JTextArea(20, 20);
        JScrollPane scrollTextArea1 = new JScrollPane(textArea);
        // JScrollPane scrollTextArea2 = new JScrollPane(textArea2);

        JPanel scrollTextPanel = new JPanel();
        scrollTextPanel.setLayout(new GridLayout(1, 2, 5, 5));
        scrollTextPanel.setOpaque(false);
        scrollTextPanel.add(scrollTextArea1);
        // scrollTextPanel.add(scrollTextArea2);


        //***TEXT PANELS*** 
        JLabel guide = new JLabel();
        guide.setFont(mainFont);

        JLabel score = new JLabel();
        score.setText("Score: " + "\n");
        score.setFont(mainFont);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 2, 5, 5));
        textPanel.setOpaque(false);
        textPanel.add(score);
        textPanel.add(guide);
    

        //***BUTTONS PANEL***
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(mainFont);
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { //what action the button performs
                // TODO Auto-generated method stub
                nextWord = tfNextWord.getText().toLowerCase();
                int x = 0;
                if(nextWord.charAt(0)==randLet+32){
                    for(int j=0; j<words.size(); j++){
                        if(nextWord.equals(words.get(j).toLowerCase())){
                            j=words.size();
                            guide.setText("Word is already in list.");
                            x++;
                        } 
                    } if(x==0){
                        words.add(nextWord);
                        textArea.append(nextWord + "\n");
                        //score function
                        if(nextWord.length()<=4 && nextWord.length()>0){
                            scoreInt+=20;
                            score.setText("Score: " + Integer.toString(scoreInt));
                        } else if(nextWord.length()>4 && nextWord.length()<=6){
                            scoreInt+=40;
                            score.setText("Score: " + Integer.toString(scoreInt));
                        } else if(nextWord.length()>6 && nextWord.length()<=8){
                            scoreInt+=60;
                            score.setText("Score: " + Integer.toString(scoreInt));
                        } else if(nextWord.length()>8){
                            scoreInt+=100;
                            score.setText("Score: " + Integer.toString(scoreInt));
                        }

                        guide.setText("");
                    }
                    tfNextWord.setText("");
                } else{
                    guide.setText("Word does not start with " + String.valueOf(randLet));
                }
            }
        });

        JLabel letter = new JLabel();

        JButton btnRandomize = new JButton("Generate Letter");
        btnRandomize.setFont(mainFont);
        btnRandomize.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                // TODO Auto-generated method stub
                
                // Generate a random ASCII value within the range of uppercase letters
                int randomAscii = random.nextInt(asciiZ - asciiA + 1) + asciiA;

                // Convert the random ASCII value to a character
                char randomLetter = (char) randomAscii;

                letter.setText(String.valueOf(randomLetter));
                randLet = randomLetter;
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnSubmit);
        buttonsPanel.add(btnRandomize);
        buttonsPanel.add(letter);

        //***MAIN PANEL***
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(71, 198, 230));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        mainPanel.add(scrollTextPanel, BorderLayout.EAST);
        mainPanel.add(textPanel, BorderLayout.WEST);
        // mainPanel.add(lbWelcome, BorderLayout.CENTER);
        // mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Word Game");
        setSize(800, 500);
        setMinimumSize(new Dimension(300, 400));
        setLocationRelativeTo(null); //sets frame in center of screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //why can "JFrame" can be replaced w "WindowConstants"?
        setVisible(true);
        //setting JFrame parameters

    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }



}
