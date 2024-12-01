import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiBiodataTemanLengkap extends JFrame {
  private JTextField namaField, nomorHPField;
  private JRadioButton lakiLakiRadio, perempuanRadio;
  private JCheckBox wnaCheckBox;
  private JTextArea outputArea;
  private JButton simpanButton;

  public AplikasiBiodataTemanLengkap() {
    setTitle("Aplikasi Biodata Teman Lengkap");
    setSize(400, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel mainPanel = new JPanel(new GridLayout(5, 2, 5, 5));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    mainPanel.add(new JLabel("Nama:"));
    namaField = new JTextField();
    mainPanel.add(namaField);

    mainPanel.add(new JLabel("Nomor HP:"));
    nomorHPField = new JTextField();
    mainPanel.add(nomorHPField);

    mainPanel.add(new JLabel("Jenis Kelamin:"));
    JPanel jenisKelaminPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    ButtonGroup jenisKelaminGroup = new ButtonGroup();
    lakiLakiRadio = new JRadioButton("Laki-Laki");
    perempuanRadio = new JRadioButton("Perempuan");
    jenisKelaminGroup.add(lakiLakiRadio);
    jenisKelaminGroup.add(perempuanRadio);
    jenisKelaminPanel.add(lakiLakiRadio);
    jenisKelaminPanel.add(perempuanRadio);
    mainPanel.add(jenisKelaminPanel);

    mainPanel.add(new JLabel());
    wnaCheckBox = new JCheckBox("Warga Negara Asing");
    mainPanel.add(wnaCheckBox);

    simpanButton = new JButton("Simpan");
    mainPanel.add(simpanButton);

    outputArea = new JTextArea();
    outputArea.setEditable(false);

    add(mainPanel, BorderLayout.NORTH);
    add(new JScrollPane(outputArea), BorderLayout.CENTER);

    simpanButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        simpanData();
      }
    });
  }

  private void simpanData() {
    String nama = namaField.getText();
    String nomorHP = nomorHPField.getText();
    String jenisKelamin = lakiLakiRadio.isSelected() ? "Laki-Laki" : "Perempuan";
    String wna = wnaCheckBox.isSelected() ? "Ya" : "Tidak";

    if (!nama.isEmpty() && !nomorHP.isEmpty()) {
      String data = "Nama: " + nama + "\n" +
          "Nomor HP: " + nomorHP + "\n" +
          "Jenis Kelamin: " + jenisKelamin + "\n" +
          "Warga Negara Asing: " + wna + "\n" +
          "============================\n";
      outputArea.append(data);
      resetForm();
    } else {
      JOptionPane.showMessageDialog(this, "Nama dan nomor HP harus diisi!");
    }
  }

  private void resetForm() {
    namaField.setText("");
    nomorHPField.setText("");
    lakiLakiRadio.setSelected(false);
    perempuanRadio.setSelected(false);

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new AplikasiBiodataTemanLengkap().setVisible(true);
      }
    });
  }
}