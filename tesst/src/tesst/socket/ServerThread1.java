package tesst.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread1 extends Thread{
	private InputStream is;
	private InputStreamReader isReader;
	private BufferedReader reader;
	private OutputStream os;
	private PrintWriter writer;
	private Socket socket=null;
	public ServerThread1(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			isReader=new InputStreamReader(is);
			reader=new BufferedReader(isReader);
			String str=null;
			while((str=reader.readLine())!=null) {
				System.out.println("我是服务端，客户端："+str);
				
			}
			socket.shutdownInput();
			
			os=socket.getOutputStream();
			writer=new PrintWriter(os);
			writer.write("我是服务端，欢迎你");
			writer.flush();//将所有的缓冲的数据都发送到目的地
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				isReader.close();
				is.close();
				socket.close();
//				os.close();
//				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
