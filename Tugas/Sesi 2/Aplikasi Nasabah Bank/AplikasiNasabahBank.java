/*

*Nama : Muhamad Rinaldi Agus Pratama
*NPM : 223040166
*Kelas : C

!yang nyontek dosa ditanggung sendiri mwehehehe.

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class AplikasiNasabahBank extends JFrame {
  private final JTextField namaField;
  private final JList<String> jenisTabunganList;
  private final JSpinner frekuensiTransaksiSpinner;
  private final JPasswordField passwordField;
  private final JPasswordField confirmPasswordField;
  private final JSpinner tanggalLahirSpinner;
  private final JTextArea outputArea;
  private final ArrayList<String> daftarNasabah;

  public AplikasiNasabahBank() {
    setTitle("Pendaftaran Nasabah Bank");
    setSize(500, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    daftarNasabah = new ArrayList<>();

    // Panel utama
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    // Nama
    JPanel namaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    namaPanel.add(new JLabel("Nama:"));
    namaField = new JTextField(20);
    namaPanel.add(namaField);
    mainPanel.add(namaPanel);

    // Jenis Tabungan
    JPanel tabunganPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    tabunganPanel.add(new JLabel("Jenis Tabungan:"));
    String[] jenisTabungan = { "Tabungan Biasa", "Tabungan Berjangka", "Tabungan Haji", "Tabungan Pendidikan" };
    jenisTabunganList = new JList<>(jenisTabungan);
    jenisTabunganList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jenisTabunganList.setVisibleRowCount(4);
    tabunganPanel.add(new JScrollPane(jenisTabunganList));
    mainPanel.add(tabunganPanel);

    // Frekuensi Transaksi
    JPanel frekuensiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    frekuensiPanel.add(new JLabel("Frekuensi Transaksi per Bulan:"));
    frekuensiTransaksiSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    frekuensiPanel.add(frekuensiTransaksiSpinner);
    mainPanel.add(frekuensiPanel);

    // Password
    JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    passwordPanel.add(new JLabel("Password:"));
    passwordField = new JPasswordField(20);
    passwordPanel.add(passwordField);
    mainPanel.add(passwordPanel);

    // Confirm Password
    JPanel confirmPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    confirmPasswordPanel.add(new JLabel("Konfirmasi Password:"));
    confirmPasswordField = new JPasswordField(20);
    confirmPasswordPanel.add(confirmPasswordField);
    mainPanel.add(confirmPasswordPanel);

    // Tanggal Lahir
    JPanel tanggalLahirPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    tanggalLahirPanel.add(new JLabel("Tanggal Lahir:"));
    SpinnerDateModel dateModel = new SpinnerDateModel();
    tanggalLahirSpinner = new JSpinner(dateModel);
    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tanggalLahirSpinner, "dd-MM-yyyy");
    tanggalLahirSpinner.setEditor(dateEditor);
    tanggalLahirPanel.add(tanggalLahirSpinner);
    mainPanel.add(tanggalLahirPanel);

    // Tombol Submit
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        submitForm();
      }
    });
    mainPanel.add(submitButton);

    // Area Output
    outputArea = new JTextArea(10, 40);
    outputArea.setEditable(false);
    mainPanel.add(new JScrollPane(outputArea));

    add(mainPanel, BorderLayout.CENTER);

    // Menu
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem resetMenuItem = new JMenuItem("Reset");
    resetMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        resetForm();
      }
    });
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    exitMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    menu.add(resetMenuItem);
    menu.add(exitMenuItem);
    menuBar.add(menu);
    setJMenuBar(menuBar);
  }

  private void submitForm() {
    StringBuilder output = new StringBuilder();
    String nama = namaField.getText();
    String jenisTabungan = jenisTabunganList.getSelectedValue();
    int frekuensiTransaksi = (Integer) frekuensiTransaksiSpinner.getValue();
    String password = new String(passwordField.getPassword());
    String confirmPassword = new String(confirmPasswordField.getPassword());
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String tanggalLahir = sdf.format((Date) tanggalLahirSpinner.getValue());

    output.append("Nama: ").append(nama).append("\n");
    output.append("Jenis Tabungan: ").append(jenisTabungan).append("\n");
    output.append("Frekuensi Transaksi: ").append(frekuensiTransaksi).append("\n");

    if (password.equals(confirmPassword)) {
      output.append("Password: Cocok\n");
    } else {
      output.append("Password: Tidak Cocok\n");
    }

    output.append("Tanggal Lahir: ").append(tanggalLahir).append("\n");

    // Menambahkan data nasabah ke dalam list
    String dataNasabah = String.format("%s, %s, %d, %s", nama, jenisTabungan, frekuensiTransaksi, tanggalLahir);
    daftarNasabah.add(dataNasabah);

    output.append("\nDaftar Nasabah:\n");
    for (int i = 0; i < daftarNasabah.size(); i++) {
      output.append(i + 1).append(". ").append(daftarNasabah.get(i)).append("\n");
    }

    outputArea.setText(output.toString());
  }

  private void resetForm() {
    namaField.setText("");
    jenisTabunganList.clearSelection();
    frekuensiTransaksiSpinner.setValue(1);
    passwordField.setText("");
    confirmPasswordField.setText("");
    tanggalLahirSpinner.setValue(new Date());
    outputArea.setText("");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new AplikasiNasabahBank().setVisible(true);
      }
    });
  }
}
