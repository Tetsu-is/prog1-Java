import java.util.Vector;
public class BallGame extends MyFrame2 {
    public static void main(String[] args) {
        new BallGame();
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
        int w = 300;
        int h = 230;

        int x0 = 50;   // 左端の x 座標(移動する円の中心 x 座標の最小値)
        int x1 = x0 + w;  // 右端の x 座標(移動する円の中心 x 座標の最大値)
        int y0 = 100;   // 上端の y 座標(移動する円の中心 x 座標の最小値)
        int y1 = y0 + h;  // 下端端の y 座標(移動する円の中心 y 座標の最大値)

        int dx = 5;    // 単位時間あたりの x 座標の変化量

        int dy = 5;    // 単位時間あたりの y 座標の変化量
        
        //ballsの数
        int ballsCount = 0;

        int animeT = 300;   // アニメーションの総コマ数
        double wtime = 0.1; // sleep に与える待機時間(コマの切り替えの間隔)

		int RedCount=0;
		int BlueCount=0;
		int GreenCount=0;

		int RightColision=0;
		int LeftColision=0;
		int AboveColison=0;
		int UnderColison=0;

        
        Vector<Ball> balls = new Vector<Ball>(); 

        
        
        for (int t = 0; t <= animeT; t++) {
        	
        	//generate balls
        	if(t%5==0) {
        		int x = (int)(Math.random()*58)*5+55;
        		int y = (int)(Math.random()*44)*5+105;
        		balls.add(new Ball(x,y,dx,dy,r,c));
        		
        		int deltatype = (int)(Math.random()*4);
        		if(balls.get(ballsCount).x==55) {
        			if(deltatype%2==0) {
        				deltatype = 0;
        			}
        			if(deltatype%2==1) {
        				deltatype = 1;
        			}
        		}
        		else if(balls.get(ballsCount).x==345) {
        			if(deltatype%2==0) {
        				deltatype = 3;
        			}
        			if(deltatype%2==1) {
        				deltatype = 4;
        			}
        		}
        		
        		if(balls.get(ballsCount).y==105) {
        			if(deltatype%2==0) {
        				deltatype = 0;
        			}
        			if(deltatype%2==1) {
        				deltatype = 2;
        			}
        		}
        		else if(balls.get(ballsCount).y==325) {
        			if(deltatype%2==0) {
        				deltatype = 1;
        			}
        			if(deltatype%2==1) {
        				deltatype = 3;
        			}
        		}
        		
        		//decide dx and dy
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
        	}
        	//Animation
            clear();   

            setColor(225,225,225);
            fillRect(x0, y0, w, h); // 円が移動する範囲を示す四角形を描画
			

            for(int j=0;j<balls.size();j++) {
            	fillCircleWithCC(balls.get(j).x, balls.get(j).y, r, balls.get(j).c);  // 中心座標(x, y) および半径 r の円を描画(色の設定が変わるので注意)
                
            	balls.get(j).x += balls.get(j).dx;  // x 座標の変化
            	balls.get(j).y += balls.get(j).dy;  // y 座標の変化

                if(balls.get(j).y == y0 + h - r) {
                	balls.get(j).dy = -5;
                	balls.get(j).c = 1;
					UnderColison++;
                }
                
                if(balls.get(j).x == x0 + w -r) {
                	balls.get(j).dx = -5;
                	balls.get(j).c = 2;
					RightColision++;
                }
                
                if(balls.get(j).y == y0 + r) {
                	balls.get(j).dy = 5;
                	balls.get(j).c = 0;
					AboveColison++;
                }
                
                if(balls.get(j).x == x0 + r) {
                	balls.get(j).dx = 5;
                	balls.get(j).c = 1;
					LeftColision++;
                }

				//Count Color
				if(balls.get(j).c==0){
					RedCount++;
				}
				else if(balls.get(j).c==1){
					GreenCount++;
				}
				else{
					BlueCount++;
				}
            }
			setColor(0,0,0);
			drawString("赤"+""+RedCount+"青"+BlueCount+"緑"+""+GreenCount,100,90,20);
			drawString("上　"+""+AboveColison+"下　"+""+UnderColison+"右　"+""+RightColision+"左　"+""+LeftColision,100,140+h,20);
			RedCount=0;
			GreenCount=0;
			BlueCount=0;
            sleep(wtime);
			
        }
    }
}