package WinStock;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.*;
import java.net.*;
import java.net.URI;
import com.opencsv.*;
import java.util.*;
public class FunctionReadCSV {
	String CSVLine;
    String[] CSVData;
    float [] ClosePrice = new float[999];
    float averageprice;
    int j=0;
    
    ArrayList<String> myList = new ArrayList<String>();
 
 //****************************read data and split from csv****************************
	public float ReadData(String DataURL){
		try{
			URL url = new URL(DataURL);
			InputStream is = url.openStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        int j=0;
            while ( (CSVLine = br.readLine()) != null){	
            	if(CSVLine!=null)  {
            		for(String d : CSVLine.toString().split(",")){
            			myList.add(d);
            		}
            	}
            }
            averageprice = AveragePrice(myList);
		}
		catch(Exception e){}
		return averageprice;
	}
//****************************end reading data and split from csv****************************

	public float AveragePrice(List Data){
		float Averageprice=0;
		for(int i=13;i<Data.size();i=i+7){
			Averageprice = Averageprice + Float.parseFloat(Data.get(i).toString());
		}
		Averageprice = Averageprice/((Data.size()/7)-1);
		return Averageprice;
		
	}

//****************************end reading data and split from csv****************************

}
