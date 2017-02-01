package com.smssend;
import java.io.*;
import java.util.*;
import gnu.io.*;

public class SMSsender {
	static Enumeration portList;
	static CommPortIdentifier portId;
	static String messageString1 = "AT";
	static String messageString2 = "AT+CPIN=\"7078\"";
	static String messageString3 = "AT+CMGF=1";
	//static String messageString4 = "AT+CMGS=\"+841292723597\"";

	//static String messageString5 = "Xin chao, Day la tin nhan thu nghiem cua chuc nang nhan tin tu dong";
	static SerialPort serialPort;
	static OutputStream outputStream;
	static InputStream inputStream;
	static char enter = 13;

	static char CTRLZ = 26;

	
	public boolean SendSms(String phonenum, String messagetext) {
		boolean flag = true;
		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {

			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

				if (portId.getName().equals("COM4")) {

					try {
						serialPort = (SerialPort) portId.open("COM4", 2000);
					} catch (PortInUseException e) {
						System.out.println("Cant open port ");
						flag = false;
					}
					try {
						outputStream = serialPort.getOutputStream();
						inputStream = serialPort.getInputStream();
					} catch (IOException e) {
						e.printStackTrace();
						flag = false;
					}
					try {
						serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
								SerialPort.PARITY_NONE);
					} catch (UnsupportedCommOperationException e) {
						e.printStackTrace();
						flag = false;
					}
					try {

						outputStream.write((messageString1 + enter).getBytes());

						Thread.sleep(100);
						outputStream.flush();

						
						outputStream.write((messageString3 + enter).getBytes());

						Thread.sleep(100);
						outputStream.flush();

						outputStream.write(("\""+phonenum +"\"" + enter).getBytes());

						Thread.sleep(100);
						outputStream.flush();

						outputStream.write((messagetext + CTRLZ).getBytes());

						outputStream.flush();
						Thread.sleep(100);

						System.out.println("Sms send success to " + phonenum);
						Thread.sleep(3000);

						outputStream.close();
						serialPort.close();
						System.out.println("Port closed");

					} catch (IOException e) {
						e.printStackTrace();
						flag = false;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						flag = false;
					}
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
	}
}
