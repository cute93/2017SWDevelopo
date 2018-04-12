/**
 *  MyPoint객체는 점하나의 x좌표와, y좌표를 갖습니다.
 */
package kr.hs.hcinfo;

/**
 * @author 3인정 99번 김현준
 * @since 2018.03.26.
 * @version 0.0.1
 */
public class MyPoint {
	/**
	 * 멤버변수 정수형 x, y
	 */
	private int x;
	private int y;
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set(0~100)
	 */
	public void setX(int x) {
		if(x<0) this.x=0;
		else if(x>200) this.x=200;
		else this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param x
	 * @param y
	 */
	public MyPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	* @param 0, 0
	*/
	public MyPoint() {
		this.x=0;
		this.y=0;
	}
	/**
	 * @param y the y to set(0~100)
	 */
	public void setY(int y) {
		if (y<0) this.y=0;
		else if(y>200) this.y=200;
		else this.y = y;
	
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	public void showPoint() {
		System.out.println(toString());
	}
	public void setRandom() {
		int a = (int)(Math.random()*200);
		int b = (int)(Math.random()*200);
		setX(a);
		setY(b);
	}
	public double distToOrigin() {
		return Math.sqrt((x*x)+(y*y));
	}
}
