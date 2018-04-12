package kr.hs.hcinfo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PointPanel extends JPanel {
	private MyPoint mp1;
	private MyPoint enenmy;
	private int length;
	
	public PointPanel() {
		mp1 = new MyPoint(90,100);
		enenmy = new MyPoint();
		enenmy.setRandom();
		length=1;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(new Color(255, 0, 0));
		g.drawOval(mp1.getX(), mp1.getY(), 3*length, 3*length);
		g.setColor(new Color(0,0,255));
		g.drawOval(enenmy.getX(), enenmy.getY(), 3, 3);
	}
	public boolean moveUP() {
		mp1.setY(mp1.getY()-(2*length));
		return isCollision();
	}
	public boolean moveDown() {
		mp1.setY(mp1.getY()+(2*length));
		return isCollision();
	}
	public boolean moveRight() {
		mp1.setX(mp1.getX()+(2*length));
		return isCollision();
	}
	public boolean moveLeft() {
		mp1.setX(mp1.getX()-(2*length));
		return isCollision();
	}
	public boolean isCollision() {
		if(Math.abs(mp1.getX()-enenmy.getX())<(3*length) && Math.abs(mp1.getY()-enenmy.getY())<(3*length)) {
			enenmy.setRandom();
			length++;
		//	repaint();
			return true;
		}
		return false;
	}
}





