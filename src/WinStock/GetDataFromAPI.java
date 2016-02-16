package WinStock;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
public class GetDataFromAPI {
	String CSVLine,Name;
    String[] CSVData=null;
    float EPS,PERatio,ClosePrice;
    
    ArrayList<String> myList = new ArrayList<String>();
    public void ReadData(String StockNumber){
		try{
			String DataURL="http://finance.yahoo.com/d/quotes.csv?s="+StockNumber+".TW&f=gherl1n";
			//1.g   ,   2.h   ,   3.e=eps   ,   4.r=p/e ratio   ,   5.l1=close price, 6n=name
			URL url = new URL(DataURL);
			InputStream is = url.openStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ( (CSVLine = br.readLine()) != null){	
            	if(CSVLine!=null)  {
         //   		System.out.println(CSVLine);
            		for(String d : CSVLine.toString().split(",")){
            			if(d.equals("N/A")){
            				d="0";
            				myList.add(d);
            			}
            			else myList.add(d);
            		}
            	}
            }
            br.close();
   //         System.out.println(myList.get(2)+"   " +myList.get(3));
		}
		catch(Exception e){}
	}
	public float GetEPS(){
		EPS=Float.parseFloat(myList.get(2));
		return EPS;
	}
	public float GetPERatio(){
		PERatio=Float.parseFloat(myList.get(3));		//if ratio was little, the profit is better.
		return PERatio;
	}
	public float GetClosePrice(){
		ClosePrice=Float.parseFloat(myList.get(4));
		return ClosePrice;
	}
	public String GetName(){
		Name =myList.get(5);
		return Name;
	}

/*	public static void main(String args[]){
		GetDataFromAPI a = new GetDataFromAPI();
		a.ReadData("2891");
		float tex;
		tex = a.GetEPS();
		System.out.println(tex);
	}*/

	public GetDataFromAPI(String StockNumber){
		ReadData(StockNumber);
	}
	
}


/*public void GetData(String StockNumber){
		String Prewebsite = "http://finance.yahoo.com/d/quotes.csv?s="+StockNumber+".TW&f=ghe";
		try{
			URL url = new URL(Prewebsite);
			InputStream is = url.openStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        StringBuilder DataBuilder = new StringBuilder();
            while ( (CSVLine = br.readLine()) != null){
            	DataBuilder.append(CSVLine);
                CSVData = DataBuilder.toString().split("\\,");
            }
            LinkParameter = CSVData.length;
            for(int i=0 ; i < LinkParameter ; i++){
            	System.out.println(CSVData[i]);
            }
		}
		catch(Exception e){}
	}*/
