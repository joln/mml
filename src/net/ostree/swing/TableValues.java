package net.ostree.swing;

import javax.swing.table.AbstractTableModel;

/**
 * 注意：一般使用AbstractTableModel创建TableModel的实现，只有少量数据时使用DefaultTableModel，
 * 
 * 显示的数据
 * 
 * ·表格的维数
 * 
 * ·表格中每一列所包含的数据类型
 * 
 * ·应该显示的列标题
 * 
 * ·是否允许编辑指定单元格的值
 * 
 * 
 */
public class TableValues extends AbstractTableModel {
	private static final long serialVersionUID = -8430352919270533604L;
	public final static int NAME = 0;
	public final static int GENDER = 1;
	public String[] columnNames= { "姓名", "性别" };
	public Object[][] values= { { "Cannel_2020", true }, { "Lucy", false },
			{ "韩梅", false }, { "李雷", true }, { "Jim", true } };
	
	public TableValues() {
		super();
		
		init();
		
	}

	public void init() {


		
	}

	//初始化table数据
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
	 * 设置列名
	 */
	public String getColumnName(int column) {
		return columnNames[column];
	}
}