package kr.hs.hcinfo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class MyWin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton exitButton;
	private JButton changeButton;
	private MyPanel canvas1;
	private JPanel southPane;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuHelp;
	private JMenuItem menuExit;
	
	//private MyPoint pt;
	public MyWin() {
		// TODO Auto-generated constructor stub
		menuHelp = new JMenuItem("help");
		menuExit = new JMenuItem("Exit");
		
		menu = new JMenu("Menu");
		menuBar = new JMenuBar();
		exitButton = new JButton("Exit");
		changeButton = new JButton("Add Point");
		canvas1 = new MyPanel();
		southPane = new JPanel();
	//	pt = new MyPoint();
	}
	public void showWin() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		setIconImage(tk.getImage("greenhat.ico"));
		add(canvas1);
		southPane.setLayout(new GridLayout(1, 2));
		southPane.add(changeButton);
		southPane.add(exitButton);
		menuExit.addActionListener(new ExitListener());
		menuHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame help = new JFrame("Help");
				JLabel text = new JLabel("본 프로그램은 PI의 근사치를 구합니다.");
				
				JButton btn = new JButton("종료");
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						help.setVisible(false);
					}
				});
				
				help.add(text);
				help.add(btn, BorderLayout.SOUTH);
				help.setSize(300, 100);
				
				help.setDefaultCloseOperation(EXIT_ON_CLOSE);
				help.setVisible(true);
			}
		});
		menu.add(menuHelp);
		menu.add(new JSeparator());
		menu.add(menuExit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		add(southPane, BorderLayout.SOUTH);
		exitButton.addActionListener(new ExitListener());
		changeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					canvas1.randPoint();
					canvas1.repaint();
				
			}
		});
		setTitle("Pi : 근차시구하기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,250);
		setVisible(true);
	}
}
