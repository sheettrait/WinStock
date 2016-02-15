package WinStock;
import java.io.*;
import java.net.*;
import java.net.URI;
public class Main{
	public static void main(String[] args){}
	}
}
/*
public class Main {
	public static void main(String[] args){
	public void Main(){
	/*	try {
	            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?s=2330.TW&f=gh");
	            InputStream is = url.openStream();
	            BufferedReader br = new BufferedReader(new InputStreamReader(is));
	            String line;
	            String[] temp=null;
	            StringBuilder aa = new StringBuilder();
	            while ( (line = br.readLine()) != null){
	                aa.append(line);
	                temp = aa.toString().split("\\,");
	            }
	            int i=0;
	     /*       while(temp[i]!=null) {
	            	System.out.println(temp[i]);
	            	i++;
	            }*/
	            for(int j=0;j<=6;j++){
	            	System.out.println(temp[j]);

	            }
	            br.close();
	            is.close();
	        }
		catch(Exception e){
			e.printStackTrace();
		}
	}
}