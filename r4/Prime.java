
public class Prime extends MyFrame2{
	public void run() {
		int n=97+50,x=50,y=40;
		
		
		if(n>=50 && n<=150) {
			for(int i=0;i<n;i++) {
				if(i<2) {
					setColor(255,0,0);
					fillRect(x,y,10,10);
					x += 20;
				}
				else {
					setColor(0,0,0);
					fillRect(x,y,10,10);
					x += 20;
					
					if(i%10==9) {
						x -= 200;
						y += 20;
					}
				}
			}
			for(int k=0;k<n;k++) {
				for(int j=0;j<n-1;j++) {
					int kj = k*j;
					if(kj>=k*k && kj<=n-1 && k>=2) {
						setColor(255,0,0);
						fillRect(kj%10*20+50,kj/10*20+40,10,10);
					}
				}
			}
		}
		else {
			System.out.println("エラー");
		}
		
		
	}
	public static void main(String[]args) {
		MyFrame2 frame1 = new Prime();
	}

}
