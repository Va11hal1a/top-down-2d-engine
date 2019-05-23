package dialogue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class dialogue_system {
	static String text;
	static String source;
	static textprocess proc;
	public class textprocess extends Thread{
		int to;
		int i;
		public textprocess(String _source) {
			text = "";
			source = _source;
			i = 0;
		}
		public void run() {
			while(i < source.length()) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				text += source.toCharArray()[i];
				System.out.println(text);
				i++;
			}
		}
	}
	public class runner extends Thread{
		String[] lines;
		public runner(String path) {
			FileHandle file = Gdx.files.internal(path);
			String data = new String(file.readBytes());
			lines = data.split("\r\n");
		}
		public void run() {
			for(int i = 0; i < lines.length; i++) {
				proc = new textprocess(lines[i].split(" ")[1]);
				proc.start();
				try {
				   proc.join();
				}catch(Exception e) {
					
				}
			}
		}
	}
	public void run(String path) {
		runner runner = new runner(path);
		runner.run();
		try {
			runner.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void render(SpriteBatch batch) {
		
	}
}
