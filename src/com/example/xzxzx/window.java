package com.example.xzxzx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class window {
	public boolean quit = false;
	public abstract void onStart();
	public abstract void onUpdate(SpriteBatch batch);
	public abstract void onDispose();
}
