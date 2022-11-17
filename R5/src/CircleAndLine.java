public class CircleAndLine extends MyFrame2 {
    
    public double abs(double a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
	
	
	
	
	public void drawline(double x0, double y0, double x1, double y1) {
    	double width = abs(x0-x1);
    	double height = abs(y0-y1);

    	
    	
    	for(int i = 0; i<width; i++) {
    		int xsign=0,ysign=0;
    		if(x1-x0>=0) {
    			xsign=1;
    		}
    		else if (x1-x0<0) {
    			xsign=-1;
    		}
    		
    		if(y1-y0>=0) {
    			ysign=1;
    		}
    		else if(y1-y0<0) {
    			ysign=-1;
    		}
    		fillRect(x0+i*xsign,y0+i*height/width*ysign,1,1);
    	}
    	
    }
	
	public void Hour(int cx, int cy, int r) {
		int R = 15;
		int count = 3;
		for(int i=0; i<12; i++) {
			double x = cx + (r+R)*Math.cos(Math.toRadians(i*30))-10;
			double y = cy + (r+R)*Math.sin(Math.toRadians(i*30))+10;
			drawString(""+count,(int)x,(int)y,15);
			count++;
			if(count==13){
				count=1;
			}
		}
	}
	
	public void Memori(int cx,int cy,int r) {
		int length=10;
		for(int deg=0;deg<60;deg++){
			double x=r*Math.cos(Math.toRadians(deg*6))+cx;
			double y=r*Math.sin(Math.toRadians(deg*6))+cy;
			if(deg%5==0){
				length=20;
			}
			else{
				length=10;
			}

			for(double i=0;i<length;i++){
				fillRect(x-i*Math.cos(Math.toRadians(deg*6)),y-i*Math.sin(Math.sin(Math.toRadians(deg*6))),1,1);

			}
		}
			
		
	}
	
	public void Hari(int cx, int cy, int h, int m) {
		int hour=30, minute=75;
		double hradian=-90+30+37*0.5;
		for(int i=0;i<hour;i++){
			fillRect(cx+i*Math.cos(Math.toRadians(hradian)),cy+i*Math.sin(Math.toRadians(hradian)),1,1);
		}

		for(int i=0;i<minute;i++){
			fillRect(cx+i*Math.cos(Math.toRadians(132)),cy+i*Math.sin(Math.toRadians(132)),1,1);
		}
	}
	

	public void drawCircle(int cx, int cy, int r) {
        // TODO: メソッドの中身を書く
    	for(int deg=0; deg<359; deg++) {
    			double x,y;
    			x = r * Math.cos(deg) + cx;
    			y = r * Math.sin(deg) + cy;
    			
    			fillRect(x,y,1,1);
    	}


    }
	
	public void drawClock(int cx, int cy, int r, int h, int m){
		Hour(cx, cy, r);
		Memori(cx, cy, r);
		Hari(cx, cy, h, m);
		drawCircle(cx, cy, r);
	}


	public void run(){
		int h=37022497%12, m=37022497%60;
		drawClock(200, 200, 100, h, m);
	}

	public static void main(String[] args) {
		new CircleAndLine();
	}

}


