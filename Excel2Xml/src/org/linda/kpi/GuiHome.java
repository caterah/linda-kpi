package org.linda.kpi;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class GuiHome extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	
	private JFileChooser jfc;
	private GuiHome gui;

	public GuiHome() throws HeadlessException {
		setSize(WIDTH, HEIGHT);
		setTitle("KPI指标生产系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		gui=this;
		
		jfc=new JFileChooser();
		jfc.setAcceptAllFileFilterUsed(true);
		jfc.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "仅支持符合规格的Excel文件";
			}
			
			@Override
			public boolean accept(File f) {
				return f.isFile()&&f.getName().indexOf(".xlsx")>=0;
			}
		});
		jfc.setDialogTitle("选择符合规格的Excel文件");
		
		JButton browse=new JButton();
		browse.setAction(new Action() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int flag=jfc.showDialog(gui, "选择合适的Excel文件并导入");
				if (flag==JFileChooser.APPROVE_OPTION) {
					File file=jfc.getSelectedFile();
					System.out.print(file.getAbsolutePath());
				}
			}
			
			@Override
			public void setEnabled(boolean b) {
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {
			}
			
			@Override
			public void putValue(String key, Object value) {
			}
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public Object getValue(String key) {
				return null;
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {
			}
		});
		browse.setLocation(900, 130);
		browse.setSize(100, 30);
		browse.setText("点击打开Excel文件");
		browse.setToolTipText("点击打开Excel文件");
		add(browse);
		
		JTextField input=new JTextField("输入文本");
		input.setLocation(180, 30);
		input.setSize(200, 30);
		add(input);
	}

	public GuiHome(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public GuiHome(String arg0) throws HeadlessException {
		super(arg0);
	}

	public GuiHome(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

}
