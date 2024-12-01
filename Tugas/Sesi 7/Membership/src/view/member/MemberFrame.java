package view.member;

import dao.JenisMemberDao;
import dao.MemberDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.JenisMember;
import model.Member;

public class MemberFrame extends JFrame {
  private List<JenisMember> jenisMemberList;
  private final List<Member> memberList = new ArrayList<>();
  private final JTextField textFieldNama;
  private final MemberTableModel tableModel;
  private final JComboBox<String> comboJenis;
  private final MemberDao memberDao;
  private final JenisMemberDao jenisMemberDao;

  public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    this.memberDao = memberDao;
    this.jenisMemberDao = jenisMemberDao;

    this.jenisMemberList = jenisMemberDao.findAll();

    JLabel labelInput = new JLabel("Nama");
    labelInput.setBounds(15, 40, 350, 10);

    textFieldNama = new JTextField();
    textFieldNama.setBounds(15, 60, 350, 30);

    JLabel labelJenis = new JLabel("Jenis Member");
    labelJenis.setBounds(15, 100, 350, 10);

    comboJenis = new JComboBox<>();
    comboJenis.setBounds(15, 120, 150, 30);

    JButton button = new JButton("Simpan");
    button.setBounds(15, 160, 100, 40);

    JTable table = new JTable();
    JScrollPane scrollableTable = new JScrollPane(table);
    scrollableTable.setBounds(15, 220, 350, 200);

    tableModel = new MemberTableModel(memberList);
    table.setModel(tableModel);

    MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);

    button.addActionListener(actionListener);

    this.add(button);
    this.add(textFieldNama);
    this.add(labelInput);
    this.add(labelJenis);
    this.add(comboJenis);
    this.add(scrollableTable);

    this.setSize(400, 500);
    this.setLayout(null);
  }

  public void populatedComboJenis() {
    this.jenisMemberList = this.jenisMemberDao.findAll();
    comboJenis.removeAllItems();
    for (JenisMember jenisMember : this.jenisMemberList) {
      comboJenis.addItem(jenisMember.getNama());
    }
  }

  public String getNama() {
    return textFieldNama.getText();
  }

  public JenisMember getJenisMember() {
    return jenisMemberList.get(comboJenis.getSelectedIndex());
  }

  public void addMember(Member member) {
    tableModel.add(member);
    textFieldNama.setText("");
  }

  public void showAlert(String message) {
    JOptionPane.showMessageDialog(this, message);
  }
}