package com.example.xzxzx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;

public abstract class person {
	public int w, h;
	public float speed = 0.33f;
	public boolean _is_move;
	int x, y;
	public Array<TextureRegion> L_frames;
	public TextureRegion L_stay;
	public Array<TextureRegion> R_frames;
	public TextureRegion R_stay;
	public Array<TextureRegion> UP_frames;
	public TextureRegion UP_stay;
	public Array<TextureRegion> DOWN_frames;
	public TextureRegion DOWN_stay;
	public int state;
	public Animation<TextureRegion> reg;
	public float time;
	private scene scrn;
	public person(int x, int y, scene scr) {
		L_frames = new Array<TextureRegion>();
		R_frames = new Array<TextureRegion>();
		DOWN_frames = new Array<TextureRegion>();
		UP_frames = new Array<TextureRegion>();
		init();
		reg = new Animation(speed, DOWN_frames, PlayMode.LOOP);
		time = 0.0f;
		this.x = x;
		this.y = y;
		state = 0;
		w = L_stay.getRegionWidth();
		h = L_stay.getRegionWidth();
		this.scrn = scr;
		onStart();
	}
	public void change(int x, int y) {
	    if(x >= 0 && y == 0) {
	    	reg = new Animation(speed, R_frames, PlayMode.LOOP);
	    	state = 3;
	    }
	    else if(x <= 0 && y == 0) {
	    	reg = new Animation(speed, L_frames, PlayMode.LOOP);
	    	state = 1;
	    }
	    else if(x == 0 && y >= 0) {
	    	reg = new Animation(speed, UP_frames, PlayMode.LOOP);
	    	state = 2;
	    }
	    else if(x == 0 && y <= 0) {
	    	reg = new Animation(speed, DOWN_frames, PlayMode.LOOP);
	    	state = 0;
	    }
	}
	public void update(SpriteBatch batch) {
		onPostUpdate();
		time += Gdx.graphics.getDeltaTime();
		if(_is_move) {
			batch.draw(reg.getKeyFrame(time) , x, y);
		}
		else {
			TextureRegion temp = new TextureRegion();
			switch(state) {
			   case 0:
				   temp = DOWN_stay;
				   break;
			   case 1:
				   temp = L_stay;
				   break;
			   case 2:
				   temp = UP_stay;
				   break;
			   case 3:
				   temp = R_stay;
				   break;
			}
			batch.draw(temp, x, y);
		}
		onBeforeUpdate();
	}
	public void setAxis(int x, int y, boolean solidcheck) {
		if(solidcheck && !scrn.pickedTileIsSolid(this.x + x, this.y + y)) {
		  this.x += x;
		  this.y += y;
		}
		change(x, y);
	}
	public void dispose() {
		onDispose();
	}
	public abstract void init();  //load resources for person
	public abstract void onStart();
	public abstract void onPostUpdate();
	public abstract void onBeforeUpdate();
	public abstract void onDispose();
}
