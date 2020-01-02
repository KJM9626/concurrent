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
				System.out.println("���Ƿ���ˣ��ͻ��ˣ�"+str);
				
			}
			socket.shutdownInput();
			
			os=socket.getOutputStream();
			writer=new PrintWriter(os);
			writer.write("���Ƿ���ˣ���ӭ��");
			writer.flush();//�����еĻ�������ݶ����͵�Ŀ�ĵ�
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
