package tesst.socket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOTest {
	public IOTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		File file=new File("F:"+File.separator+"test.txt");
		/*FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			InputStreamReader reader=new InputStreamReader(fis, "gbk");
			StringBuffer sb=new StringBuffer();
			while(reader.ready()) {
				sb.append((char)reader.read());
			}
			System.out.println(sb.toString());
			reader.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			RandomAccessFile rFile=new RandomAccessFile(file, "rw");
			FileChannel channel=rFile.getChannel();
			ByteBuffer bb=ByteBuffer.allocate(48);
			int i=channel.read(bb);
			while(i!=-1) {
				System.out.println("read: "+i);
				bb.flip();
				while(bb.hasRemaining()) {
					StringBuffer sb=new StringBuffer();
					sb.append((char)bb.get());
					System.out.println(sb.toString());
				}
				bb.clear();
				i=channel.read(bb);
			}
			rFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
