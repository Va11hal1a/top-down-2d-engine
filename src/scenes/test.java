package scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer.Task;
import com.example.xzxzx.scene;
import com.example.xzxzx.timer;
import com.example.xzxzx.timer.task_type;

import persons.player;
import windows.testwindow;

public class test extends scene{
	player plr;
	public test(SpriteBatch batch) {
		super("asdasd.tmx", batch);
	}

	public void onStart() {
		plr = new player(0, 0, this);
		super.cam.target = plr;
		persons.add(plr);
	}
	public void onUpdate() {
		
	}
	public void onDispose() {
		
	}

}
