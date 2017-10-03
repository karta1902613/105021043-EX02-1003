import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainJFrame extends JFrame {
    private Container cp;
    private JButton jbtnExam = new JButton("範例文");
    private JButton jbtnAddpw = new JButton("加密");
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnClear = new JButton("清除");
    private JLabel  jlab = new JLabel("Key");
    private JTextField jtf = new JTextField();
    private JTextArea jtaP = new JTextArea();
    private JTextArea jtaA = new JTextArea();
    private JScrollPane jspL = new JScrollPane(jtaP);
    private JScrollPane jspR = new JScrollPane(jtaA);
    private JPanel janC = new JPanel(new GridLayout(6,1,3,3));
    public MainJFrame(){
        init();
    }
    public void init(){
        setBounds(400,300,400,300);
        jtaA.setLineWrap(true);
        jtaP.setLineWrap(true);
        jspL.setPreferredSize(new Dimension(100,80));
        jspR.setPreferredSize(new Dimension(100,80));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        janC.add(jbtnExam);
        janC.add(jbtnAddpw);
        janC.add(jlab);
        janC.add(jtf);
        janC.add(jbtnClear);
        janC.add(jbtnExit);



        cp.add(jspR,BorderLayout.EAST);
        cp.add(janC,BorderLayout.CENTER);
        cp.add(jspL,BorderLayout.WEST);
        jlab.setHorizontalAlignment(JLabel.CENTER);
        jbtnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbtnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
                jtaP.setText("");
                jtaA.setText("");
            }
        });
        jbtnExam.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaP.setText("TEST123");
            }
        });
        jbtnAddpw.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              char data[]=jtaP.getText().toCharArray();
              int len = data.length;

              for(int i =0;i<len;i++){
                  data[i]+=Integer.parseInt(jtf.getText());
                  jtaA.setText(new String(data));
              }

            }
        });

    }
}
