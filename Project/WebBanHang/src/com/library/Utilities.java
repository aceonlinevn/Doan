package com.library;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import net.htmlparser.jericho.*;
import org.apache.axis.encoding.Base64;

import javax.servlet.*;

public class Utilities {
	private static final String RANDOMSTRING = "0123456789abcdefghijklmnopqrswxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/*
	 * Tạo chuỗi random mật khẩu
	 */
	public static String randomString(int len){
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder( len );
       for( int i = 0; i<len; i++ ) 
          sb.append( RANDOMSTRING.charAt( rnd.nextInt(RANDOMSTRING.length()) ) );
       return sb.toString();
	}
	
	public static String fomatDate(Date date) {
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

		return ft.format(date);

	}
	public static String fomatDateForsql(Date date) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

		return ft.format(date);

	}
	public static String fomatDateTime(Date date) {
		SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
		return ft.format(date);
	}
	public static String getStringDateNowForSQL() {
		Date date = new Date();

		return Utilities.fomatDateForsql(date);
	}
	public static String encode(String strUNI) {
		return CharacterReference.encode(strUNI);
	}

	public static String decode(String strHTML) {
		return CharacterReference.decode(strHTML);
	}	
	
	public static Date parseStringtoDate(String date) {
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

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

	public static String getStringDateNow() {
		Date date = new Date();

		return Utilities.fomatDate(date);
	}

	public static String getMessage(String message) {
		String tmp = "<script>";
		tmp += "alert('" + message + "');";
		tmp += "</script>";

		return tmp;
	}
	public static String getMessageRedict(String message,String location) {
		String tmp = "<script>";
		tmp += "alert('" + message + "');";
		tmp += "window.location = '"+location+"';";
		tmp += "</script>";

		return tmp;
	}
	public static String convertMoney(int money) {
		String tmp = "";
		NumberFormat formatter = new DecimalFormat("#,###,###");
		tmp = formatter.format(money);
		tmp = tmp.replaceAll(",", ".");
		return tmp;
	}

	public static Date getDateNow() {
		Date date = new Date();
		return date;
	}

	public static int getIntParam(ServletRequest request, String name) {
		int value = -1;
		String strValue = request.getParameter(name);

		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Integer.parseInt(strValue);
		}
		return value;
	}

	public static int getIntAtt(ServletRequest request, String name) {
		int value = -1;
		String strValue = (String) request.getAttribute(name);

		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Integer.parseInt(strValue);
		}
		return value;
	}

	public static void HTMLToServlet(String FILENAME) {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			File file = new File("term.txt");
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {

				sCurrentLine = sCurrentLine.replace((char) 9, (char) 00);
				sCurrentLine = sCurrentLine.replace("\"", "\\\"");

				sCurrentLine = "out.print(\"" + sCurrentLine + "\");";
				bw.write(sCurrentLine + "\n");
			}
			bw.close();

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

	}

	public static String encodeString(String text) throws UnsupportedEncodingException {
		byte[] bytes = text.getBytes("UTF-8");
		String encodeString = Base64.encode(bytes);
		return encodeString;
	}

	public static String decodeString(String encodeText) throws UnsupportedEncodingException {
		byte[] decodeBytes = Base64.decode(encodeText);
		String str = new String(decodeBytes, "UTF-8");
		return str;
	}

	public static void main(String[] args) {
		Utilities.HTMLToServlet("/Volumes/Data/github/Doan/Project/WebBanHang/WebContent/adv/layout.html");
	}

}
