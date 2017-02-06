package com.library;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


public class Utilities {
	public static String fomatDate(Date date){
		SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
		
		return ft.format(date);
		
	}
	public static String fomatDateTime(Date date){
		SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
		return ft.format(date);
	}
	
	public static Date parseStringtoDate(String date){
		SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy"); 

	      String input = date.length() == 0 ? "11-11-1818" : date; 

	      Date t = null; 
	      try {
			t = ft.parse(input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return t;
	}
	public static String getStringDateNow(){
		Date date = new Date();
		
		return Utilities.fomatDate(date);
	}
	
	public static Date getDateNow(){
		Date date = new Date();
		return date;
	}
	
	public static int getIntParam(HttpServletRequest request, String name){
		 int value =-1;
	        String strValue = request.getParameter(name);

	        if(strValue != null && !strValue.equalsIgnoreCase("")){
	            value = Integer.parseInt(strValue);
	        }
	        return value;
	}
	public static int getIntAtt(HttpServletRequest request, String name){
		 int value =-1;
	        String strValue = (String)request.getAttribute(name);

	        if(strValue != null && !strValue.equalsIgnoreCase("")){
	            value = Integer.parseInt(strValue);
	        }
	        return value;
	}
	
	public static ArrayList<String> HTMLToServlet(String FILENAME){
		ArrayList<String> line = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				
				sCurrentLine=sCurrentLine.replace((char)9, (char)00);
				sCurrentLine = sCurrentLine.replace("\"", "\\\"" );
		
				//sCurrentLine = "\""+sCurrentLine + "\"";
				line.add(sCurrentLine);
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return line;
	}
	public static void main(String[] args){
		Utilities.HTMLToServlet("test.html");
	}
	
}
