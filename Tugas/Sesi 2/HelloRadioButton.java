import java.awt.event.*;
import javax.swing.*;

public class HelloRadioButton extends JFrame {

  public HelloRadioButton() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelInput = new JLabel("Pilih Jenis Kelamin:");
    labelInput.setBounds(130, 40, 150, 30);

    JRadioButton radioButtonPria = new JRadioButton("Pria");
    radioButtonPria.setBounds(130, 80, 100, 30);

    JRadioButton radioButtonWanita = new JRadioButton("Wanita");
    radioButtonWanita.setBounds(130, 120, 100, 30);

    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(radioButtonPria);
    buttonGroup.add(radioButtonWanita);

    JButton button = new JButton("Pilih");
    button.setBounds(130, 160, 100, 40);

    JLabel labelOutput = new JLabel();
    labelOutput.setBounds(130, 210, 200, 30);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String pilihan = "";
        if (radioButtonPria.isSelected()) {
          pilihan = "Pria";
        } else if (radioButtonWanita.isSelected()) {
          pilihan = "Wanita";
        }
        labelOutput.setText("Anda memilih: " + pilihan);
      }
    });

    this.add(button);
    this.add(radioButtonPria);
    this.add(radioButtonWanita);
    this.add(labelInput);
    this.add(labelOutput);

    this.setSize(400, 300);
    this.setLayout(null);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        HelloRadioButton h = new HelloRadioButton();
        h.setVisible(true);
      }
    });
  }
}
