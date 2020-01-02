package tesst.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		OutputStream os;
		PrintWriter pw;
		InputStream is;
		InputStreamReader isReader;
		BufferedReader reader;
		try {
			Socket lining=new Socket("localhost", 8090);
			os=lining.getOutputStream();
			pw=new PrintWriter(os);
			pw.write("我是客户端2，请求连接");
			pw.flush();
			lining.shutdownOutput();
			is=lining.getInputStream();
			isReader=new InputStreamReader(is);
			reader=new BufferedReader(isReader);
			String str=null;
			while((str=reader.readLine())!=null) {
				System.out.println(str);
			}
			lining.shutdownInput();
			reader.close();
			isReader.close();
			is.close();
//			pw.close();
//			os.close();
			lining.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
