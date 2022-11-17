public class Animation_Test extends MyFrame2 {
	public static void main(String[] args) {
		new Animation_Test();
    }
	
	public void run() {
		int n = 37022493 % 5; // 学籍番号を5で割った余り
		int ne = 0; // 初めの円の数
		int ox = 200; // 軌道の中心座標
		int oy = 200;	
		int A = 10 * n + 100; // 軌道の大きさ	
		int animeT = 500; //アニメーションの総コマ数
		double wtime = 0.04; // sleep に与える待機時間(コマの切り替えの間隔)

		
		for (int t = 0; t < animeT; t++) {
			clear();
			int i = 0;
			int num = 0;
			if (t%51==0) {
				num+=1;
			}
			while (i < num) {
				int T = 50;
				int c = 1;
				double θx = 3.14 * (t-i) / T;
				double θy = 2 * 3.14 * (t - i) / T;
				double x = A * Math.sin(θx)+ox; // ラジアン
				double y = A * Math.sin(θy)+oy;
				fillCircleWithCC(x,y,4,c);
				i++;
			}
				sleep(wtime);
		}
	}
	public void fillCircleWithCC(double x, double y, int r, int c) {
        if (c==0) {
        	setColor(255,0,0);
        	fillOval(x-r,y-r,r*2,r*2);
        } else if (c==1) {
        	setColor(0,255,0);
        	fillOval(x-r,y-r,r*2,r*2);
        } else {
        	setColor(0,0,255);
        	fillOval(x-r,y-r,r*2,r*2);
        }
    }
}