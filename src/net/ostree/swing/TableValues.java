package net.ostree.swing;

import javax.swing.table.AbstractTableModel;

/**
 * ע�⣺һ��ʹ��AbstractTableModel����TableModel��ʵ�֣�ֻ����������ʱʹ��DefaultTableModel��
 * 
 * ��ʾ������
 * 
 * ������ά��
 * 
 * �������ÿһ������������������
 * 
 * ��Ӧ����ʾ���б���
 * 
 * ���Ƿ�����༭ָ����Ԫ���ֵ
 * 
 * 
 */
public class TableValues extends AbstractTableModel {
	private static final long serialVersionUID = -8430352919270533604L;
	public final static int NAME = 0;
	public final static int GENDER = 1;
	public String[] columnNames= { "����", "�Ա�" };
	public Object[][] values= { { "Cannel_2020", true }, { "Lucy", false },
			{ "��÷", false }, { "����", true }, { "Jim", true } };
	
	public TableValues() {
		super();
		
		init();
		
	}

	public void init() {


		
	}

	//��ʼ��table����
	public void inittable(){
		
	}
	
	public int getColumnCount() {
		return values[0].length;
	}

	public int getRowCount() {
		return values.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return values[rowIndex][columnIndex];
	}

	/**
	 * ��������
	 */
	public String getColumnName(int column) {
		return columnNames[column];
	}
}