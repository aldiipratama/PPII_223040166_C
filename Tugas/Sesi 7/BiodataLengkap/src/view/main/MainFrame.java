package view.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
  private final JTextField namaField, nomorHPField;
  private final JRadioButton lakiLakiRadio, perempuanRadio;
  private final JCheckBox wnaCheckBox;
  private final JTextArea outputArea;
  private final JButton simpanButton;

  public MainFrame() {
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
      
    });
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new MainFrame().setVisible(true);
    });
  }
}
