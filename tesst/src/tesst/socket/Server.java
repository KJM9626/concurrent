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
			// 创建服务器socket
			Socket waiting = null;
			int count = 0;
			while (true) {
				waiting = serverSocket.accept();// 创建监听端口，等待连接的客户端socket
				Thread t1 = new ServerThread1(waiting);
				t1.start();
				System.out.println("客户端连接的数目：" + (++count));
				InetAddress address = waiting.getInetAddress();
				System.out.println("当前客户端的IP名和地址为：" + address.getHostName() + "  " + address.getHostAddress());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
