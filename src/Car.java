
public class Car {
	int x,y,w,h,vx,vy;
	public Car(int x,int y,int w,int h,int vx,int vy) { 
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.vx = vx;
		this.vy = vy;
	}
	public void draw(MyFrame2 frame){
		frame.fillRect(x-w/4,y-h/2,w/2,h/3);
		frame.fillRect(x-w/2,y-h/6,w,h/3);
		frame.fillOval(x+w/8,y+h/6,w/4,h/3);
		frame.fillOval(x-3*w/8,y+h/6,w/4,h/3);
	}
	public void move(){
		x += vx;
		y += vy;
	}
	public void stop(){
		vx = 0;
		vy = 0;
	}
	public boolean isMoving(){
		if (vx!=0||vy!=0){
			return true;
		}
		else {
			return false;
		}
	}
}
