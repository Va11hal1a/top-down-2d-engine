package com.example.xzxzx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Camera {
		public OrthographicCamera cam;
		public SpriteBatch batch;
		public person target;
		public Camera(SpriteBatch batch) {
			cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			cam.position.set(cam.viewportWidth/2, cam.viewportHeight/2, 0);
			this.batch = batch;
			cam.update();
			batch.setProjectionMatrix(cam.combined);
		}
		public void upd() {
			if(target != null) follow(target.x, target.y);
			cam.update();
			batch.setProjectionMatrix(cam.combined);
		}
		public void follow(int x, int y) {
			float delX = (x - cam.position.x + 48) / 5;
			float delY = (y - cam.position.y + 48) / 5;
			cam.translate(delX, delY);
			//upd();
		}
		public Vector2 get_pos() {
			float x = cam.position.x - Gdx.graphics.getWidth()/2;
			float y = cam.position.y - Gdx.graphics.getHeight()/2;
			return new Vector2(x, y);
		}
	}
