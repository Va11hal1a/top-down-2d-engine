package com.example.xzxzx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class object{
		int x,y;
		int w,h;
		Texture base;
		public ClickListener clck_listener;
		
		interface ClickListener{
			public void click();
		}
		public object(int x, int y, Texture arg) {
			this.x = x;
			this.y = y;
			this.base = arg;
			this.w = arg.getWidth();
			this.h = arg.getHeight();
		}
		public void addListener(ClickListener add) {
			clck_listener = add;
		}
		public void update(SpriteBatch batch) {
			if(base != null) {
				batch.draw(base, x, y);
			}
		}
		public boolean TestClick(int px, int py) {
			return px > x && px < x + w && py > y && py < y + h;
		}
		public void dispose() {
			onDispose();
		}
		public abstract void onStart();
		public abstract void onUpdate();
		public abstract void onDispose();
	}
