// Source code is decompiled from a .class file using FernFlower decompiler.
package view.member;

import dao.MemberDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import model.JenisMember;
import model.Member;

public class MemberButtonSimpanActionListener implements ActionListener {
  private final MemberFrame memberFrame;
  private final MemberDao memberDao;

  public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
    this.memberFrame = memberFrame;
    this.memberDao = memberDao;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String nama = this.memberFrame.getNama();
    if (nama.isEmpty()) {
      this.memberFrame.showAlert("Nama Tidak Boleh Kosong");
    } else {
      JenisMember jenisMember = this.memberFrame.getJenisMember();
      Member member = new Member();
      member.setId(UUID.randomUUID().toString());
      member.setNama(nama);
      member.setJenisMember(jenisMember);

      this.memberFrame.addMember(member);
      this.memberDao.insert(member);
    }
  }
}
