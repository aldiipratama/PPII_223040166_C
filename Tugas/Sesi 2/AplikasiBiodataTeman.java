import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiBiodataTeman extends JFrame {
    private JTextField namaField, teleponField;
    private JTextArea biodataArea;
    private JButton tambahButton;

    public AplikasiBiodataTeman() {
        setTitle("Aplikasi Biodata Teman");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        inputPanel.add(namaField);
        inputPanel.add(new JLabel("Nomor Telepon:"));
        teleponField = new JTextField();
        inputPanel.add(teleponField);
        tambahButton = new JButton("Tambah");
        inputPanel.add(tambahButton);

        biodataArea = new JTextArea();
        biodataArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(biodataArea), BorderLayout.CENTER);

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String telepon = teleponField.getText();
                if (!nama.isEmpty() && !telepon.isEmpty()) {
                    biodataArea.append(nama + " - " + telepon + "\n");
                    biodataArea.append("============================\n");
                    namaField.setText("");
                    teleponField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Nama dan nomor telepon harus diisi!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AplikasiBiodataTeman().setVisible(true);
            }
        });
    }
}
