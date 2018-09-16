package buchong;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Maipingzi {
	public static void main(String[] args) {
		double a=0;
		int b=a++>0&&a--<0?1:(a==0?-1:0);
		System.out.println("a="+a+",b="+b);
	}	

}
