package contralar;

import java.util.Enumeration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class Contralar implements SerialPortEventListener {

	private static final String PORT_NAMES[] = { "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
			"/dev/tty.usbmodem", // Mac OS X
			"/dev/usbdev", // Linux
			"/dev/tty", // Linux
			"/dev/serial", // Linux
			"COM10", "COM11", "COM12" };
	private String PortUsed;
	private SerialPort ThePort;
	private static final int DATA_RATE = 9600;
	private static final int TIME_OUT = 2000;
	private CommPortIdentifier portId;
	private BufferedReader input;
	private OutputStream output;

	public Contralar() {
		PortUsed = FindPort();

		inisieted();

	}
	
	public String GetPort() {
		return PortUsed;

	}

	private String FindPort() {
		// System.out.println(java.library.path);

		CommPortIdentifier serialPortId;
		// static CommPortIdentifier sSerialPortId
		Enumeration<?> enumComm;
		// SerialPort serialPort;

		enumComm = CommPortIdentifier.getPortIdentifiers();
		while (enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			for (String portName : PORT_NAMES) {

				if (serialPortId.getName().equals(portName)) {
					portId = serialPortId;
					break;
				}
			}

			return serialPortId.getName();
		}
		return "num";
	}

	public void inisieted() {

		try {

			// open serial port, and use class name for the appName.
			ThePort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

			// set port parameters
			ThePort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(ThePort.getInputStream()));
			output = ThePort.getOutputStream();

			// add event listeners
			//ThePort.addEventListener((SerialPortEventListener) this);
			ThePort.notifyOnDataAvailable(true);

		} catch (Exception e) {
			System.out.println(e.toString());
			if (ThePort != null) {
				ThePort.close();
				ThePort = null;
			}
		}
	}

	private void SendIformation(String word) {
		try {
			
			output.write(word.getBytes());
		
		} catch (Exception e) {

		}
	}

	public SerialPort ReturnPort() {
		return ThePort;
	}

	public void TurnlightOn() {
		try {

			SendIformation("1");

		} catch (Exception e) {

		}
	}

	public void TurnlightOff() {
		try {

			SendIformation("0");

		} catch (Exception e) {

		}
	}

	public void ChangeButton1(String f) {
		SendIformation("a" + f);

	}

	public void ChangeButton2(String f) {
		SendIformation("b" + f);

	}

	public void ChangeButton3(String f) {
		SendIformation("c" + f);
	}

	public synchronized void close() {
		if (ThePort != null) {
			ThePort.removeEventListener();
			ThePort.close();
		}
	}

	public String butenbrees() {
		try {
			return input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		return "";
	}

	public void serialEvent(SerialPortEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
