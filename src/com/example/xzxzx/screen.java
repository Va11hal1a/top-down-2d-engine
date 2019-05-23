package com.example.xzxzx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dialogue.dialogueData;
import dialogue.dialogue_system;
import scenes.test;

public class screen extends ScreenAdapter{
	SpriteBatch batch;
	test test;
	dialogue_system sys;
	public screen() {
		sys = new dialogue_system();
		sys.run("dialogue/test-dialogue.co");
		timer.init();
		dialogueData.init();
		AssetLoader.init();
		batch = new SpriteBatch();
		test = new test(batch);
	}
	public void render(float delta) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		test.update(delta);
		timer.update();
	}
}
