
package cse.oop2.ch14.quiz;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer {
    
    private JTextArea display;
    private ArrayList cardList;
    private QuizCard currentCard;
    private Iterator cardIterator;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;
    
    public static void main(String[] args) {
        QuizCardPlayer qReader = new QuizCardPlayer();
        qReader.go();
    }
    
    
    public void go(){
        frame = new JFrame("Quiz Card Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif",Font.BOLD,24);
        
        display = new JTextArea(9,20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setEditable(false);
        
        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        nextButton = new JButton("Show Question");
        
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
        
    }
    
    public class NextCardListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if(isShowAnswer){
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            }else{
                if(cardIterator.hasNext()){
                    showNextCard();
                }else{
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }
    
    public class OpenMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
    
    public void loadFile(File file){
        cardList = new ArrayList();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))){
            
            String line = null;
            while((line = reader.readLine())!=null){
            makeCard(line);
        }
        }catch(Exception ex){
            System.out.println("couldn't read the card file");
            ex.printStackTrace();
        }
        cardIterator = cardList.iterator();
        showNextCard();
    }
    
    private void makeCard(String lineToParse){
        StringTokenizer parser = new StringTokenizer(lineToParse,"/");
        if(parser.hasMoreTokens()){
            QuizCard card = new QuizCard(parser.nextToken(),parser.nextToken());
            cardList.add(card);
        }
    }
    
    private void showNextCard(){
        currentCard = (QuizCard) cardIterator.next();
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}
