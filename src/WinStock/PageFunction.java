package WinStock;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
public class PageFunction {
	int ElementNumber=0;
	int number=0;
	String line;
	ArrayList<ArrayList<Float>> FinalResult = new ArrayList<ArrayList<Float>>();
	ArrayList<Float> innerResult;
    ArrayList<String> DisPlayNameList = new ArrayList<String>();
    ArrayList<Float> EPSList = new ArrayList<Float>();
    ArrayList<Float> PERatioList = new ArrayList<Float>();
    ArrayList<Float> ClosePriceList = new ArrayList<Float>();
    ArrayList<String> NameList = new ArrayList<String>();

//***********************************get the stock number***********************************

	public void getStockNumber(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("D:\\fian.txt")); 
			while((line = br.readLine())!=null){
				GetDataFromAPI search = new GetDataFromAPI(line);	//call the function
				EPSList.add(search.GetEPS());
				PERatioList.add(search.GetPERatio());
				ClosePriceList.add(search.GetClosePrice());
				NameList.add(search.GetName());
				ElementNumber++;
			}
			br.close();
		}
		catch(Exception e){}
	}
//***********************************end getting the stock number***********************************
	public void SelectStock(){
		for(int j=0;j<this.ElementNumber;j++){
			innerResult= new ArrayList<Float>();		//restart
			if(EPSList.get(j)>1){
				if(PERatioList.get(j)<25){
					if(ClosePriceList.get(j)>15){
						innerResult.add(EPSList.get(j));
						innerResult.add(PERatioList.get(j));
						innerResult.add(ClosePriceList.get(j));
						FinalResult.add(number,innerResult);
						DisPlayNameList.add(number,NameList.get(j));
						number++;
					}
				}
			}
			
		}
		
			for(int y=0;y<FinalResult.size();y++){
				for(int z=0;z<=2;z++){
				System.out.println(FinalResult.get(y).get(z));
			}
		}
	}
	public int displaynumber(){
		return number;
	}
	public ArrayList<ArrayList<Float>> displaydata(){
		return FinalResult;
	}
	public ArrayList<String> displayname(){
		return DisPlayNameList;
	}
	public PageFunction(){
		getStockNumber();
		SelectStock();
	}	
//	public static void main(String[] args){
	//	PageFunction a = new PageFunction();
//		a.getStockNumber();
//		a.SelectStock();
//	}
}
