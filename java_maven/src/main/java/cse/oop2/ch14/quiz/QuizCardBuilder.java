/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch14.quiz;

import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;



public class QuizCardBuilder {
    
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;
    
    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }
    
     public void go(){
         
         frame = new JFrame("Quiz Card Bilder");
         JPanel mainPanel = new JPanel(); ///메인 Panel이다.
         Font bigFont = new Font("sanserif",Font.BOLD,24);
         question = new JTextArea(6,20); //6줄의 20칸으로 구성 
         question.setLineWrap(true); //question에 대한 속성을 연결
         question.setWrapStyleWord(true);
         question.setFont(bigFont);
         
         JScrollPane qScroller = new JScrollPane(question);
         qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //수직 방향의 스크롤 바는 보이고
         qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // 수평 방향의 스크롧 바는 보이지 않는다. 
         
         answer = new JTextArea(6,20); //6줄의 20칸으로 구성
         answer.setLineWrap(true); //answer에 대한 속성을 연결
         answer.setWrapStyleWord(true);
         answer.setFont(bigFont);
         
         JScrollPane aScroller = new JScrollPane(answer);
         aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         
         JButton nextButton = new JButton("Next Card");
         
         cardList = new ArrayList<QuizCard>(); //카드의 목록들은 arrayList으로 해서 관리를 할것이다. 
         
         JLabel qLabel = new JLabel("Question:");
         JLabel aLabel = new JLabel("Answer:");
         
         mainPanel.add(qLabel); //라벨 --> 스크롤바 --> 라벨 --> 스크롤바 --> 다음 버튼 
         mainPanel.add(qScroller);
         mainPanel.add(aLabel);
         mainPanel.add(aScroller);
         mainPanel.add(nextButton);
         
         nextButton.addActionListener(new NextCardListener()); //버튼을 눌렀을때 액션을 취하기 위해서 
         
         JMenuBar menuBar = new JMenuBar();
         JMenu fileMenu = new JMenu("File");
         
         JMenuItem newMenuItem = new JMenuItem("New");
         JMenuItem saveMenuItem = new JMenuItem("Save");
         newMenuItem.addActionListener(new NewMenuListener()); //각각의 버튼에 대한 기능들을 연결 시켜준다.
         
         saveMenuItem.addActionListener(new SaveMenuListener());
         fileMenu.add(newMenuItem);
         fileMenu.add(saveMenuItem);
         menuBar.add(fileMenu);
         frame.setJMenuBar(menuBar);;
         frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
         frame.setSize(500,600);
         frame.setVisible(true);
     }
    
    public class NextCardListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText()); //quiz에 있는 text와 answer에 있는 text를 가지고 와서 List에 넣는다. 넣고 나서 화면을 clear 시킨다. 
            cardList.add(card);
            clearCard();
        }
    }

    public class SaveMenuListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card); //현재 입력된 카드의 정보들을 List에 넣는다.

            JFileChooser fileSave = new JFileChooser(); //저장할 파일의 이름을 가지고 온다. 
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    public class NewMenuListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus(); //clear를 하면 question부터 입력을 할 수 있게끔 해준다. 
    }

    private void saveFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(                          //선택된 디렉토리의 파일로 test2.txt를 저장한다.
                        new FileOutputStream(file), "UTF-8"))) { //카드를 파일로 저장을 하려고 한다. OutputStreamWriter는 인코딩을 지정해서 저장할 수 있다.
  //*교재에서는 * BufferedWriter writer = new BufferedWriter(new FileWriter(file)); 이렇게 하면 인코딩을 지정할 수 없다.
            for (var card : cardList) {
                writer.write(card.getQuestion() + "/"); //파일에 퀴즈의 질문과 정답만 입력한다.
                writer.write(card.getAnswer() + "\n");
            }

        } catch (IOException ex) {
            System.out.println("couldn't write the cardList out");
            ex.printStackTrace();
        }
    }

}
