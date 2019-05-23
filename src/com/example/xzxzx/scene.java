package com.example.xzxzx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;

public abstract class scene {
	public boolean pause = false;
	public final byte solid_layer = 1;
	public final int wt = 32, ht = 32;
	public TiledMap map;
	public OrthogonalTiledMapRenderer render;
	//public OrthographicCamera cam;
	public Camera cam;
	public TiledMapTileLayer solidlayer;
	public SpriteBatch batch;
	public Array<object> objects;
	public Array<person> persons;
	public window currentWindow;
	public boolean person_pause = false;
	public scene(String mapx, SpriteBatch batch) {
		map = new TmxMapLoader().load(mapx);
		render = new OrthogonalTiledMapRenderer(map);
		//cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);
		this.batch = batch;
		cam = new Camera(this.batch);
		//cam.update();
		//batch.setProjectionMatrix(cam.combined);
		solidlayer = (TiledMapTileLayer)map.getLayers().get(1);
		objects = new Array<object>();
		persons = new Array<person>();
		onStart();
	}
	public void update(float delta) {
		if(!pause) {
		 cam.upd();
		 //batch.setProjectionMatrix(cam.combined);
		 Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 render.setView(cam.cam);
		 render.render();
		 batch.begin();
		 if(!person_pause) {
		     for(int i = 0; i < persons.size; i++) {
			    persons.get(i).update(batch);
		     }
		 }
		 for(int i = 0; i < objects.size; i++) {
			 objects.get(i).update(batch);
		 }
		 batch.end();
		 onUpdate();
		}
		else if(currentWindow != null){
			if(currentWindow.quit == false) currentWindow.onUpdate(batch);
			else {
				currentWindow.onDispose();
				currentWindow = null;
				pause = false;
				batch.setColor(1,1,1,1);
			}
		}
	}
	public void setWindow(window win) {
		this.currentWindow = win;
		pause = true;
		this.currentWindow.onStart();
	}
	public void dispose() {
		map.dispose();
		render.dispose();
		batch.dispose();
		onDispose();
	}
	public boolean pickedTileIsSolid(int x, int y) {
		int x1 = (int)(x / wt);
		int y1 = (int)(y / ht);
		return (solidlayer.getCell(x1, y1) != null);
	}
	public object pick_object(int x, int y) {
		for(int i = 0; i < objects.size; i++) {
			if(objects.get(i).x < x &&
					objects.get(i).x + objects.get(i).w > x &&
					objects.get(i).y < y &&
					objects.get(i).y + objects.get(i).h > y) {
				return objects.get(i);
			}
		}
		return null;
	}
	public person pick_person(int x, int y) {
		for(int i = 0; i < persons.size; i++) {
			if(objects.get(i).x < x &&
					objects.get(i).x + objects.get(i).w > x &&
					objects.get(i).y < y &&
					objects.get(i).y + objects.get(i).h > y) {
				return persons.get(i);
			}
		}
		return null;
	}
	public abstract void onStart();
	public abstract void onUpdate();
	public abstract void onDispose();
}
