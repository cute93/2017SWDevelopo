package kr.hs.hcinfo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MyPoint> point;
	private int basicX, basicY, basicWidth, basicHeight;
	private int inP, totP;
	public MyPanel() {
		// TODO Auto-generated constructor stub
		point = new ArrayList<MyPoint>();
		basicX = 90;
		basicY = 35;
		basicWidth=100;
		basicHeight=100;
		inP=1;
		totP=1;
	}
	public void randPoint() {
		MyPoint temp = new MyPoint();
		temp.setRandom();
		point.add(temp);
		if(temp.distToOrigin()<=100.0) inP++;
		totP++;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawRect(basicX, basicY, basicWidth, basicHeight);
		g.drawArc(basicX-100, basicY-100, basicWidth+100, basicHeight+100, 270, 90);
		
		//g.drawLine(point.getX(), point.getY(), point.getX()+1, point.getY()+1);
		for(MyPoint pPoint:point) {
			if(pPoint.distToOrigin()<100.0) g.setColor(new Color(255, 0, 0));
			else g.setColor(new Color(0, 0, 255));
			g.drawOval(pPoint.getX()+basicX, pPoint.getY()+basicY, 1, 1);	
		}
		
		g.setColor(new Color(0, 0, 0));
		g.drawString("Pi : "+(4.0*(double)inP/(double)totP), 10, 20);
	}
	@Override
	public String toString() {
		return point.toString();
	}
}
