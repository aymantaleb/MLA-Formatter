import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Menu extends JPanel implements ActionListener {
    private static JButton export;
    private static JPanel menu;
    private static JButton clear;
    private static JTextField First;
    private static JTextField Last;
    private static JTextField Teach;
    private static JTextField Class;
    private static JTextField Title;
    private static JTextField File;
    private static JTextField Date;
    private static JTextArea Essay;
    private static JLabel L1;
    private static JLabel L2;
    private static JLabel L3;
    private static JLabel L4;
    private static JLabel L5;
    private static JLabel L6;
    private static JLabel L7;
    private static String[] text;
    private String fname;
    private String lname;
    private String tname;
    private String cname;
    private String title;
    private String fileName;
    private String essay;
    private String date;
    private JFrame win;

    public Menu() {
        menu = new JPanel();
        this.fname = "";
        this.lname = "";
        this.tname = "";
        this.cname = "";
        this.title = "";
        this.fileName = "";
        this.essay = "";
        First = new JTextField(50);
        L1 = new JLabel("First Name:");
        menu.add(L1);
        menu.add(First);
        Last = new JTextField(50);
        L2 = new JLabel("Last Name:");
        menu.add(L2);
        menu.add(Last);
        Teach = new JTextField(50);
        L3 = new JLabel("Teacher's Name:");
        menu.add(L3);
        menu.add(Teach);
        Class = new JTextField(50);
        L4 = new JLabel("Class Name:");
        menu.add(L4);
        menu.add(Class);
        Date = new JTextField(50);
        L7 = new JLabel("Date: ");
        menu.add(L7);
        menu.add(Date);
        Title = new JTextField(50);
        L5 = new JLabel("Title: ");
        menu.add(L5);
        menu.add(Title);
        File = new JTextField(50);
        L6 = new JLabel("File Name:");
        menu.add(L6);
        menu.add(File);
        JLabel e1 = new JLabel("Input Essay Here:");
        Essay = new JTextArea(20, 50);
        JScrollPane scroll = new JScrollPane(Essay);
        e1.setLabelFor(Essay);
        Essay.setLineWrap(true);
        menu.add(e1);
        menu.add(scroll);
        export = new JButton();
        export.setText("Export Essay");
        export.setBounds(500, 500, 500, 500);
        export.addActionListener(this);
        menu.add(export);
        clear = new JButton();
        clear.setText("Clear Text");
        clear.addActionListener(this::ClearPerformed);
        menu.add(clear);
        this.win = new JFrame("MLA Formatter");
        this.win.setBounds(100, 50, 600, 800);
        this.win.setDefaultCloseOperation(3);
        this.win.setResizable(false);
        menu.setOpaque(true);
        menu.setBackground(Color.white);
        this.win.setContentPane(menu);
        this.win.setVisible(true);
        export.setEnabled(false);
        File.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                Menu.this.changed();
            }

            public void removeUpdate(DocumentEvent e) {
                Menu.this.changed();
            }

            public void changedUpdate(DocumentEvent e) {
                Menu.this.changed();
            }
        });
    }

    public void ClearPerformed(ActionEvent e) {
        First.setText("");
        Last.setText("");
        Teach.setText("");
        Teach.setText("");
        Class.setText("");
        Title.setText("");
        File.setText("");
        Essay.setText("");
        Date.setText("");
    }

    public void changed() {
        if (File.getText().equals("")) {
            export.setEnabled(false);
        } else {
            export.setEnabled(true);
        }

    }

    public void actionPerformed(ActionEvent e) {
        this.fname = First.getText();
        this.lname = Last.getText();
        this.tname = Teach.getText();
        this.cname = Class.getText();
        this.title = Title.getText();
        this.fileName = File.getText();
        this.essay = Essay.getText();
        this.date = Date.getText();
        text = new String[]{this.fname, this.lname, this.tname, this.cname, this.date, this.title, this.essay, this.fileName};

        try {
            new Format();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static String[] getInput() {
        return text;
    }

    public static void main(String[] args) {
        new Menu();
    }
}