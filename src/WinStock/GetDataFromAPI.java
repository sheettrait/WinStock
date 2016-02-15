package WinStock;
import java.io.*;
import java.net.*;
import java.net.URI;
public class GetDataFromAPI {
	String CSVLine;
    String[] CSVData=null;
    int LinkParameter = 0;
	public void GetData(String StockNumber){
		String Prewebsite = "http://finance.yahoo.com/d/quotes.csv?s="+StockNumber+".TW&f=ghe7";
		try{
			URL url = new URL(Prewebsite);
			InputStream is = url.openStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        StringBuilder DataBuilder = new StringBuilder();
            while ( (CSVLine = br.readLine()) != null){
            	System.out.println("123");
            	DataBuilder.append(CSVLine);
                CSVData = DataBuilder.toString().split("\\,");
            }
            LinkParameter = CSVData.length;
            for(int i=0 ; i < LinkParameter ; i++){
            	System.out.println(CSVData[i]);
            }
		}
		catch(Exception e){}
	}
	public static void main(String args[]){
		GetDataFromAPI a = new GetDataFromAPI();
		a.GetData("2330");
	}
}
