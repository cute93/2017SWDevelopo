package kr.hs.hcinfo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PointWin extends JFrame {
	private JButton up;
	private JButton left;
	private JButton right;
	private JButton down;
	private PointPanel centerPanel;
	private int score;
	private long start;
	private long end;
	private final int EndScore = 200;
	private String mvp;
	private int mvpscore;
	public PointWin() {
		up = new JButton("Up");
		left = new JButton("Left");
		right = new JButton("Right");
		down = new JButton("Down");
		centerPanel = new PointPanel();
		score = 0;
		start = System.currentTimeMillis();
		try {
			BufferedReader br = new BufferedReader(new FileReader("./score.txt"));
			mvp = br.readLine();
			mvpscore = Integer.parseInt(br.readLine());
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(rootPane, mvp+"���� ���� "+mvpscore+"�� �Դϴ�.. \n������ ������!!!", "���� �ְ���!!", 1);
	}
	
	public void showWindow() {
		setTitle("Catch The Fly : Score["+score+"]");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		up.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(centerPanel.moveUP()) score += 10;
				setTitle("Catch The Fly : Score["+score+"]");
				if(score > EndScore)
					endProgram();
				centerPanel.repaint();
			}
		});
		down.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(centerPanel.moveDown()) score += 10;
				setTitle("Catch The Fly : Score["+score+"]");
				if(score > EndScore)
					endProgram();
				centerPanel.repaint();
			}
		});
		left.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(centerPanel.moveLeft()) score += 10;
				setTitle("Catch The Fly : Score["+score+"]");
				if(score > EndScore)
					endProgram();
				centerPanel.repaint();
			}
		});
		right.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(centerPanel.moveRight()) score += 10;
				setTitle("Catch The Fly : Score["+score+"]");
				if(score > EndScore)
					endProgram();
				centerPanel.repaint();
			}
		});
		
		
		
		add(up, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(down, BorderLayout.SOUTH);
		add(centerPanel);
		setSize(340,299);
		setVisible(true);
	}

	protected void endProgram() {
		// TODO Auto-generated method stub
		end = System.currentTimeMillis();
		//JOptionPane.showConfirmDialog(rootPane, "���������� " + (end-start) +"�� �Դϴ�.");
		long currentScore = end - start;
		if(mvpscore > currentScore) {
			JOptionPane.showMessageDialog(rootPane, "�ְ��� ���޿� �����߽��ϴ�.\n���� �ְ��� : "+mvpscore+"\nȹ������ : "+currentScore, "���ӿ���-�ְ���ȹ�� ����!!", 1);
		}else {
			String flag = JOptionPane.showInputDialog(rootPane,"�����մϴ�. �ְ��� ����!! \n�̸��� �Է��ϼ��� : ", "�ְ��� ����!!!", 1);
			BufferedWriter fr;
			try {
				fr = new BufferedWriter(new FileWriter("score.txt"));
				fr.write(flag);
				fr.flush();
				fr.write("\n"+currentScore+"");
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.exit(0);
	}
}




