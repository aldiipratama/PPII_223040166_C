import java.awt.event.*;
import javax.swing.*;

public class HelloCheckBox extends JFrame {

  public HelloCheckBox() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelInput = new JLabel("Pilih Bahasa:");
    labelInput.setBounds(130, 40, 100, 30);

    JCheckBox checkBoxJava = new JCheckBox("Java");
    checkBoxJava.setBounds(130, 80, 100, 30);

    JCheckBox checkBoxPython = new JCheckBox("Python");
    checkBoxPython.setBounds(130, 120, 100, 30);

    JButton button = new JButton("Pilih");
    button.setBounds(130, 160, 100, 40);

    JLabel labelOutput = new JLabel();
    labelOutput.setBounds(130, 210, 200, 30);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String pilihan = "";
        if (checkBoxJava.isSelected()) {
          pilihan += "Java ";
        }
        if (checkBoxPython.isSelected()) {
          pilihan += "Python ";
        }
        labelOutput.setText("Anda memilih: " + pilihan);
      }
    });

    this.add(button);
    this.add(checkBoxJava);
    this.add(checkBoxPython);
    this.add(labelInput);
    this.add(labelOutput);

    this.setSize(400, 300);
    this.setLayout(null);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        HelloCheckBox h = new HelloCheckBox();
        h.setVisible(true);
      }
    });
  }
}
