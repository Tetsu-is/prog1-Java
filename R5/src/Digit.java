public class Digit extends MyFrame2 {

    public int getDigit(int n, int k) {
        // TODO: 正の整数 n の k 桁目を数字返す(※桁 k は 1 オリジン)
    	int m = n / (int)Math.pow(10, k-1);
		
		if (m == 0) {
			return -1;
		}
		
		else if (m > 0){
			int r = (int) m % 10;
			return r;
		}
		return k;
    }

    public void run() {
       // TODO: getDigit メソッドを呼び出す
    	for(int k=1; k<11; k++) {
    		int d = getDigit(37022497,k);
    		drawString(""+d,30*k+20,80,20);
    	}
    	
    }

    public static void main(String[] args) {
        new Digit();
    }

}