package tesst.socket;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8090);
			// ����������socket
			Socket waiting = null;
			int count = 0;
			while (true) {
				waiting = serverSocket.accept();// ���������˿ڣ��ȴ����ӵĿͻ���socket
				Thread t1 = new ServerThread1(waiting);
				t1.start();
				System.out.println("�ͻ������ӵ���Ŀ��" + (++count));
				InetAddress address = waiting.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP���͵�ַΪ��" + address.getHostName() + "  " + address.getHostAddress());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
