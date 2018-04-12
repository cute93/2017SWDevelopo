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
		JOptionPane.showMessageDialog(rootPane, mvp+"님이 세운 "+mvpscore+"점 입니다.. \n도전해 보세요!!!", "현재 최고점!!", 1);
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
		//JOptionPane.showConfirmDialog(rootPane, "최종점수는 " + (end-start) +"점 입니다.");
		long currentScore = end - start;
		if(mvpscore > currentScore) {
			JOptionPane.showMessageDialog(rootPane, "최고점 도달에 실패했습니다.\n현재 최고점 : "+mvpscore+"\n획득점수 : "+currentScore, "게임오버-최고점획득 실패!!", 1);
		}else {
			String flag = JOptionPane.showInputDialog(rootPane,"축하합니다. 최고점 갱신!! \n이름을 입력하세요 : ", "최고점 갱신!!!", 1);
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




