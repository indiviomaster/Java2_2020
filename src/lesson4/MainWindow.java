package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainWindow extends JFrame {
    protected JPanel panel = new JPanel();;
    protected JTextField msgText = new JTextField(80);
    protected JTextArea textArea = new JTextArea();
    protected JButton btnSend = new JButton("Send");
    protected JLabel msgLabel = new JLabel("Message:");
    protected int rowNum=0;
    public MainWindow(){
        int i=0;
        setTitle("CHAT");
        setBounds(500, 200, 600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());

        msgText.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        msgText.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER)
                {
                    if (msgText.getText().length()>0)
                    {    rowNum++;
                        textArea.append(rowNum+": "+msgText.getText()+"\n");
                        msgText.setText("");
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(600,500));
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.WHITE);
        textArea.setBackground(Color.BLACK);

        panel.add(new JScrollPane(textArea), BorderLayout.PAGE_START);
        panel.add(msgLabel, BorderLayout.LINE_START);
        panel.add(msgText, BorderLayout.CENTER);
        panel.add(btnSend, BorderLayout.LINE_END);
        add(panel);

        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem mFileExit = new JMenuItem("Exit");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mFile.add(mFileExit);


        btnSend.addActionListener(e -> {
            if (msgText.getText().length()>0)
            {   rowNum++;
                textArea.append(rowNum+": "+msgText.getText()+"\n");
                msgText.setText("");
            }
        });
        mFileExit.addActionListener(e -> System.exit(0));
        setVisible(true);
    }
}
