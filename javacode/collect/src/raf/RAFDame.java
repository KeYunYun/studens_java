package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFDame {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile src
		=new RandomAccessFile("src.jpg", "r");
		RandomAccessFile des 
		=new RandomAccessFile("copy.jpg", "rw");
		int d=-1;
		while((d=src.read()) !=-1){
			des.write(d);
		}
		System.out.println("Íê³É");
		src.close();
		des.close();
	}

}
