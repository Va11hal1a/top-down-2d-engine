package windows;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.example.xzxzx.AssetLoader;
import com.example.xzxzx.timer;
import com.example.xzxzx.window;
import com.example.xzxzx.timer.task_type;

public class testwindow extends window{
	TextButton btn;
	@Override
	public void onStart() {
		btn = new TextButton("Exit", AssetLoader.skinUI);
		btn.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("click");
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
			}
		});
	}

	@Override
	public void onUpdate(SpriteBatch batch) {
		btn.act(0.1f);
		batch.begin();
		btn.draw(batch, 0.3f);
		batch.end();
	}

	@Override
	public void onDispose() {
		// TODO Auto-generated method stub
		
	}
	
}
