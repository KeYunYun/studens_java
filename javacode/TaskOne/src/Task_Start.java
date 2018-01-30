import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.nio.channels.FileChannel;

public class Task_Start {

    public  long getFileSize(File file) throws IOException {  
    	  
        FileInputStream fis = new FileInputStream(file);  
        FileChannel fc = fis.getChannel();  
        return fc.size();  
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream file=null;
		FileWriter outfile=null;
		ReadJson readjson=new ReadJson();
		try {
			int linenum=0;
			int filenum=1;
			file=new FileInputStream("F:/计算机/wikidata-latest-all.json/wikidata-latest-all.json");
			InputStreamReader isr 
			=new InputStreamReader(file,"utf-8");
			
			BufferedReader br 
			=new BufferedReader(isr);
			//outfile=new FileWriter("E:/json/1.json");
			String str=null;
			while((str=br.readLine())!=null){
				if(str.equals("[")){
					continue;
				}
				str=str.substring(0,str.length()-1);
				readjson.writejson(str);
				System.out.println(linenum++);
		/*		linenum++;
				outfile.write(str);
				if (linenum>=1){
					outfile.flush();
					filenum++;
					linenum=0;
					System.out.println(filenum);
					outfile=new FileWriter("E:/json/"+filenum+".json");
					continue;
			}*/
				
			}
		
			
			br.close();
			isr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}finally {
		
		}
			
	}

}
