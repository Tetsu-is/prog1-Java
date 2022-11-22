//R8_7
import java.util.Vector;
public class BallGameFailed extends MyFrame2 {
    public static void main(String[] args) {
        new BallGameFailed();
    }

    /** 中心座標 (cx, cy) および半径 r の円を描画(色を整数 c = 0, 1, 他で指定)*/
    public void fillCircleWithCC(int cx, int cy, int r, int c) {
    	if(c==0){
            setColor(255,0,0);
        }else if(c==1){
            setColor(0,255,0);
        }else{
            setColor(0,0,255);
        }

        fillOval(cx-r,cy-r,2*r,2*r);
    }

    public void run() {

        int r = 5;     // 移動する円の半径
        int c = 0;     // 移動する円の色(0 → 赤, 1 → 黄緑, 他 → 青)  
        int n = 7;
        //学籍番号の下一桁
        
        int x;
        int y;
      //四角形の左上座標
        int bx = 50;
        int by = 100;
        
        //幅と高さ
        int w = 300;
        int h = 230;
        
        //ballsの数
        int ballsCount = 0;
        
        
        int dx = 5;    // 単位時間あたりの x 座標の変化量

        int dy = 5;    // 単位時間あたりの y 座標の変化量

        int animeT = 300;   // アニメーションの総コマ数
        double wtime = 0.1; // sleep に与える待機時間(コマの切り替えの間隔)

        
        Vector<Ball> balls = new Vector<Ball>();
        
        for (int t = 0; t <= animeT; t++) {
        	//setColor(225,225,225);
            //fillRect(bx, by, w, h); // 円が移動する範囲を示す四角形を描画
        	clear();

            
            if(t==5) {
            	int randomx = (int)(Math.random()*60);
            	int randomy = (int)(Math.random()*46);
            	x = 5*randomx+50;
            	y = 5*randomy+100;
            	balls.add(new Ball(x,y,dx,dy,r,c));
            	
            	int deltatype = (int)(Math.random()*4);
            	switch(deltatype) {
            	case 0:
            		balls.get(ballsCount).dx = 5;
            		balls.get(ballsCount).dy = 5;
            		break;
            	case 1:
            		balls.get(ballsCount).dx = 5;
            		balls.get(ballsCount).dy = -5;
            		break;
            	case 2:
            		balls.get(ballsCount).dx = -5;
            		balls.get(ballsCount).dy = 5;
            		break;
            	case 3:
            		balls.get(ballsCount).dx = -5;
            		balls.get(ballsCount).dy = -5;
            		break;
            	}
            	ballsCount ++;
            	
            	for(int j=0;j<balls.size();j++) {
            		fillCircleWithCC(balls.get(j).x,balls.get(j).y,balls.get(j).r,balls.get(j).c);
                    balls.get(j).x += balls.get(j).dx;  // x 座標の変化
                    balls.get(j).y += balls.get(j).dy;  // y 座標の変化
            	}

            
            }
            sleep(wtime);
        }
    }
}