package view.member;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Member;

public class MemberTableModel extends AbstractTableModel {
  private static final String[] COLUMN_NAMES = { "Nama", "Jenis Member" };
  private final List<Member> data;

  public MemberTableModel(List<Member> data) {
    this.data = data;
  }

  @Override
  public int getColumnCount() {
    return COLUMN_NAMES.length;
  }

  @Override
  public int getRowCount() {
    return data.size();
  }

  @Override
  public String getColumnName(int col) {
    return COLUMN_NAMES[col];
  }

  @Override
  public Object getValueAt(int row, int col) {
    Member rowItem = data.get(row);
    String value = "";
    switch (col) {
      case 0 -> value = rowItem.getNama();
      case 1 -> value = rowItem.getJenisMember().getNama();
    }
    return value;
  }

  @Override
  public boolean isCellEditable(int row, int col) {
    return false;
  }

  public void add(Member value) {
    data.add(value);
    fireTableRowsInserted(data.size() - 1, data.size() - 1);
  }

  public void remove(int row) {
    data.remove(row);
    fireTableRowsDeleted(row, row);
  }

  public void update(int row, Member value) {
    data.set(row, value);
    fireTableRowsUpdated(row, row);
  }
}