package view.member;  

import javax.swing.table.AbstractTableModel;  
import java.util.List;  
import model.Member;  

class MemberTableModel extends AbstractTableModel {  
    private String[] columnNames = {"Nama", "Jenis Member"};  
    private List<Member> data;  

    public MemberTableModel(List<Member> data) {  
        this.data = data;  
    }  

    public int getColumnCount() {  
        return columnNames.length;  
    }  

    public int getRowCount() {  
        return data.size();  
    }  

    public String getColumnName(int col) {  
        return columnNames[col];  
    }  

    public Object getValueAt(int row, int col) {  
        Member rowItem = data.get(row);  
        String value = "";  
        switch (col) {  
            case 0:  
                value = rowItem.getNama();  
                break;  
            case 1:  
                value = rowItem.getJenisMember().getNama();  
                break;  
        }  
        return value;  
    }  

    public boolean isCellEditable(int row, int col) {  
        return false;  
    }  

    public void add(Member value) {  
        data.add(value);  
        fireTableRowsInserted(data.size() - 1, data.size() - 1);  
    } 
    public void update(int rowIndex, Member member) {
        data.set(rowIndex, member);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    // Remove Member dari tabel
    public void remove(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    } 
}