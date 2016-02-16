package WinStock;
import java.util.*;

import WinStock.FunctionReadCSV;
public class HistoryData {
	String PrehistoryURL = "http://real-chart.finance.yahoo.com/table.csv?s=";
	String FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate;
	String historyURL=null;
	String StockNumber=null;
	float FivePrice,FifteenPrice,ThirtyPrice;

	public String thirtyQueryURL(){//(int Year,int Month,int date){
		Calendar calendar = Calendar.getInstance();
		int NowYear = calendar.get(Calendar.YEAR);
		int NowMonth = calendar.get(Calendar.MONTH);
		int NowDate = calendar.get(Calendar.DATE);
	//	System.out.println(NowYear+"  "+NowMonth+"  "+NowDate);
		calendar.add(Calendar.MONTH,-1);
		int PassYear = calendar.get(Calendar.YEAR);
		int PassMonth = calendar.get(Calendar.MONTH);
		int PassDate = calendar.get(Calendar.DATE);
//		System.out.println("30====" + PassYear+"  "+PassMonth+"  "+PassDate+String.valueOf(PassDate));
		historyURL = PrehistoryURL + StockNumber + ".TW&a=" + String.valueOf(PassMonth) + "&b=" + String.valueOf(PassDate) + "&c=" + String.valueOf(PassYear) + "&d=" + String.valueOf(NowMonth) + "&e=" + String.valueOf(NowDate)+ "&f="+String.valueOf(NowYear)+"2016&g=d&ignore=.csv";
	//	System.out.println(StockNumber+historyURL);
		return historyURL;
	}
	public String fifteenQueryURL(){
		Calendar calendar = Calendar.getInstance();
		int NowYear = calendar.get(Calendar.YEAR);
		int NowMonth = calendar.get(Calendar.MONTH);
		int NowDate = calendar.get(Calendar.DATE);
		calendar.add(Calendar.DATE,-15);
		int PassYear = calendar.get(Calendar.YEAR);
		int PassMonth = calendar.get(Calendar.MONTH);
		int PassDate = calendar.get(Calendar.DATE);
	//	System.out.println("fif=====" + PassYear+"  "+PassMonth+"  "+PassDate+String.valueOf(PassDate));
		historyURL = PrehistoryURL + StockNumber + ".TW&a=" + String.valueOf(PassMonth) + "&b=" + String.valueOf(PassDate) + "&c=" + String.valueOf(PassYear) + "&d=" + String.valueOf(NowMonth) + "&e=" + String.valueOf(NowDate)+ "&f="+String.valueOf(NowYear)+"2016&g=d&ignore=.csv";
	//	System.out.println(StockNumber+historyURL);
		return historyURL;
	}
	public String fiveQueryURL(){
		Calendar calendar = Calendar.getInstance();
		int NowYear = calendar.get(Calendar.YEAR);
		int NowMonth = calendar.get(Calendar.MONTH);
		int NowDate = calendar.get(Calendar.DATE);
		calendar.add(Calendar.DATE,-5);
		int PassYear = calendar.get(Calendar.YEAR);
		int PassMonth = calendar.get(Calendar.MONTH);
		int PassDate = calendar.get(Calendar.DATE);
	//	System.out.println("fif=====" + PassYear+"  "+PassMonth+"  "+PassDate+String.valueOf(PassDate));
		historyURL = PrehistoryURL + StockNumber + ".TW&a=" + String.valueOf(PassMonth) + "&b=" + String.valueOf(PassDate) + "&c=" + String.valueOf(PassYear) + "&d=" + String.valueOf(NowMonth) + "&e=" + String.valueOf(NowDate)+ "&f="+String.valueOf(NowYear)+"2016&g=d&ignore=.csv";
	//	System.out.println(StockNumber+historyURL);
		return historyURL;
	}
//**********************************end getting the url******************************

	public HistoryData(String Stock){
		FunctionReadCSV fifteen = new FunctionReadCSV();
		FunctionReadCSV thirty = new FunctionReadCSV();
		FunctionReadCSV five = new FunctionReadCSV();
		this.StockNumber = Stock;
		String temp = null;
		temp = fiveQueryURL();
		FivePrice = five.ReadData(temp);
		System.out.println("5 days average = " + five.ReadData(temp));
		temp = fifteenQueryURL();
		FifteenPrice =  fifteen.ReadData(temp);
		System.out.println("15 days average = " + fifteen.ReadData(temp));
		temp = thirtyQueryURL();
		ThirtyPrice =  thirty.ReadData(temp);
		System.out.println("30 days average = " + thirty.ReadData(temp));
	}
	public void JudgeTrend(float fivedays,float fifteendays,float thirtydays){
		
	}
	public static void main(String args[]){
		String tempstocknumber;
		Scanner scanner = new Scanner(System.in);
		tempstocknumber = scanner.nextLine();
		scanner.close();
		HistoryData Test = new HistoryData(tempstocknumber);
		
	}
}
/*
  //*****************************get the url from yahoo*******************************
	public String GetURL(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("FromYear:");
		FromYear = scanner.next();
		System.out.println("FromMonth:");
		FromMonth = scanner.next();
		System.out.println("FromDate:");
		FromDate = scanner.next();
		System.out.println("ToYear:");
		ToYear = scanner.next();
		System.out.println("ToMonth:");
		ToMonth = scanner.next();
		System.out.println("ToDate:");
		ToDate = scanner.next();
		System.out.println("StockNumber");
		StockNumber = scanner.next();
		JudgeMonth = Integer.valueOf(FromMonth);
		if(JudgeMonth>10){
			JudgeMonth = JudgeMonth-1;
			FromMonth = String.valueOf(JudgeMonth);
			System.out.println("hi"+FromMonth);
		}
		else{
			JudgeMonth = JudgeMonth-1;
			FromMonth = String.valueOf(JudgeMonth);
			FromMonth = "0" + FromMonth;
			System.out.println("hi"+FromMonth);

		}
		JudgeMonth = Integer.valueOf(ToMonth);
		if(JudgeMonth>10){
			JudgeMonth = JudgeMonth-1;
			ToMonth = String.valueOf(JudgeMonth);
		}
		else{
			JudgeMonth = JudgeMonth-1;
			ToMonth = String.valueOf(JudgeMonth);
			ToMonth = "0" + ToMonth;
		}
		historyURL = PrehistoryURL + StockNumber + ".TW&a=" + FromMonth + "&b=" + FromDate + "&c=" + FromYear + "&d=" + ToMonth + "&e=" + ToDate+ "&f="+ToYear+"2016&g=d&ignore=.csv";
		return historyURL;
	}*/
 