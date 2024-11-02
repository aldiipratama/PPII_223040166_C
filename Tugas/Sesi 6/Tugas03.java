import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tugas03 extends JFrame {

  private final DefaultTableModel model;
  private final JTable tabelKelompok;
  private final JTextField namaKelompokField;
  private final JTextArea deskripsiKelompokArea;
  private final JRadioButton rb1, rb2, rb3;
  private final JButton tombolTambah;
  private final JSpinner jumlahAnggotaSpinner;

  public Tugas03() {
    setTitle("Pengelolaan Kelompok");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Menu Bar
    JMenuBar menuBar = new JMenuBar();
    JMenu menuKelompok = new JMenu("Menu Kelompok");
    JMenuItem itemTambahKelompok = new JMenuItem("Tambah Kelompok");
    JMenuItem itemLihatKelompok = new JMenuItem("Lihat Kelompok");
    itemTambahKelompok.addActionListener((ActionEvent e) -> {
      tambahKelompok();
    });
    itemLihatKelompok.addActionListener((ActionEvent e) -> {
      lihatKelompok();
    });
    menuKelompok.add(itemTambahKelompok);
    menuKelompok.add(itemLihatKelompok);
    menuBar.add(menuKelompok);
    setJMenuBar(menuBar);

    // Main Panel
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    // Nama Kelompok
    JPanel namaKelompokPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    namaKelompokPanel.add(new JLabel("Nama Kelompok"));
    namaKelompokField = new JTextField(20);
    mainPanel.add(namaKelompokPanel);
    mainPanel.add(namaKelompokField);

    // Deskripsi Kelompok
    JPanel deskripsiKelompokPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    deskripsiKelompokPanel.add(new JLabel("Deskripsi Kelompok"));
    deskripsiKelompokArea = new JTextArea(5, 20);
    mainPanel.add(deskripsiKelompokPanel);
    mainPanel.add(deskripsiKelompokArea);

    // Jenis Kelompok
    JPanel jenisKelompokPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jenisKelompokPanel.add(new JLabel("Jenis Kelompok"));
    rb1 = new JRadioButton("Siswa");
    rb2 = new JRadioButton("Mahasiswa");
    rb3 = new JRadioButton("Umum");
    ButtonGroup bg = new ButtonGroup();
    bg.add(rb1);
    bg.add(rb2);
    bg.add(rb3);
    mainPanel.add(jenisKelompokPanel);
    mainPanel.add(rb1);
    mainPanel.add(rb2);
    mainPanel.add(rb3);

    // JSpinner
    JPanel spinnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    spinnerPanel.add(new JLabel("Jumlah Anggota"));
    jumlahAnggotaSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    spinnerPanel.add(jumlahAnggotaSpinner);
    mainPanel.add(spinnerPanel);

    add(mainPanel, BorderLayout.CENTER);

    // Tombol Tambah dan Edit
    tombolTambah = new JButton("Tambah ke Tabel");
    tombolTambah.addActionListener((ActionEvent e) -> {
      tambahKelompok();
    });
    mainPanel.add(tombolTambah);

    // Tabel Kelompok
    model = new DefaultTableModel();
    model.addColumn("Nama Kelompok");
    model.addColumn("Deskripsi Kelompok");
    model.addColumn("Jenis Kelompok");
    model.addColumn("Jumlah Anggota");
    tabelKelompok = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(tabelKelompok);
    mainPanel.add(scrollPane);
  }

  private void tambahKelompok() {
    String namaKelompok = namaKelompokField.getText();
    String deskripsiKelompok = deskripsiKelompokArea.getText();
    String jenisKelompok = getSelectedJenisKelompok();
    int jumlahAnggota = (int) jumlahAnggotaSpinner.getValue();
    if (!namaKelompok.isEmpty() && !deskripsiKelompok.isEmpty() && !jenisKelompok.isEmpty() && jumlahAnggota > 0) {
      model.addRow(new Object[] { namaKelompok, deskripsiKelompok, jenisKelompok, jumlahAnggota });
      clearFields();
    } else {
      JOptionPane.showMessageDialog(this, "Tidak boleh ada field yang kosong atau jumlah anggota harus lebih dari 0.");
    }
  }

  private void lihatKelompok() {
    int selectedRow = tabelKelompok.getSelectedRow();
    if (selectedRow != -1) {
      String namaKelompok = (String) model.getValueAt(selectedRow, 0);
      String deskripsiKelompok = (String) model.getValueAt(selectedRow, 1);
      String jenisKelompok = (String) model.getValueAt(selectedRow, 2);
      int jumlahAnggota = (int) model.getValueAt(selectedRow, 3);
      String detailKelompok = "Nama Kelompok: " + namaKelompok + "\n" +
          "Deskripsi Kelompok: " + deskripsiKelompok + "\n" +
          "Jenis Kelompok: " + jenisKelompok + "\n" +
          "Jumlah Anggota: " + jumlahAnggota;
      JOptionPane.showMessageDialog(this, detailKelompok, "Detail Kelompok", JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(this, "Tidak ada baris yang dipilih.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private String getSelectedJenisKelompok() {
    if (rb1.isSelected())
      return "Siswa";
    if (rb2.isSelected())
      return "Mahasiswa";
    if (rb3.isSelected())
      return "Umum";
    return "";
  }

  private void clearFields() {
    namaKelompokField.setText("");
    deskripsiKelompokArea.setText("");
    rb1.setSelected(false);
    rb2.setSelected(false);
    rb3.setSelected(false);
    jumlahAnggotaSpinner.setValue(1);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new Tugas03().setVisible(true);
    });
  }
}