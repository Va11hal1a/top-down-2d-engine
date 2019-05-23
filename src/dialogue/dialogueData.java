package dialogue;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class dialogueData {
	public static final String path = "dialogue/dialogue-conf.co";
	public static HashMap <String, String> map;
	public static void init() {
		FileHandle file = Gdx.files.internal(path);
		String data = new String(file.readBytes());
		map = new HashMap<String, String>();
		String[] lines = data.split("\r\n");
		if(lines.length % 4 != 0) {
			System.out.println("length of lines is not available");
			return;
		}
		for(int i = 0; i < lines.length; i += 4) {
			Person temp = new Person(); 
			String name = lines[i].split(" ")[1];
			temp.portrait = new Texture(Gdx.files.internal(lines[i+1].split(" ")[1]));
			if(lines[i + 2].split(" ")[1] == "default") {
				temp.clr = null;
			}
			else if(lines[i + 3].split(" ")[1] == "default") {
				temp.portrait = null;
			}
		}
	}
}
