import java.util.Stack;

public class xRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}



	public int MaxArea(int[][]mat) {
		int	n=mat.length;
		int	m=mat[0].length;
		int maxA=0;
		int area=0;
		int [] help = new int [m];
		for(int j=0;j<m;j++ ) help[j]=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(mat[i][j]==0) help[j]=0;
				else help[j]=help[j]+1;
			}
			area=HistArea(help);
			if(maxA<area)maxA=area;
		}

		return maxA;
	}

	public static int HistArea(int[]hist) {
		int maxarea=0;
		int n=hist.length;
		Stack<Integer> s = new Stack<>();
		int top;
		int tp=0;
		int i =0;
		int area;
		while(i<n) {
			if(s.isEmpty()||hist[i]>=hist[s.peek()]) { 
				s.push(i);
				i++;
			}
			else {
				tp = s.pop();
				if(s.isEmpty()) area=hist[tp]*i;
				else area= hist[tp]*(i-s.peek()-1);
				if (maxarea<area) maxarea=area;
			}
		}
		while(!s.empty()) {
			tp = s.pop();
			if(s.isEmpty()) area=hist[tp]*i;
			else area= hist[tp]*(i-s.peek()-1);
			if (maxarea<area) maxarea=area;
		}

		return maxarea;
	}


}
