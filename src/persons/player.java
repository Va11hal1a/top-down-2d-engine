package persons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.example.xzxzx.AssetLoader;
import com.example.xzxzx.person;
import com.example.xzxzx.scene;

public class player extends person{

	public player(int x, int y, scene scr) {
		super(x, y, scr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		DOWN_frames.add(AssetLoader.playerregs[0][0], AssetLoader.playerregs[0][1], AssetLoader.playerregs[0][2]);
		DOWN_stay = AssetLoader.playerregs[0][1];
		L_frames.add(AssetLoader.playerregs[1][0], AssetLoader.playerregs[1][1], AssetLoader.playerregs[1][2]);
		L_stay = AssetLoader.playerregs[1][1];
		UP_frames.add(AssetLoader.playerregs[3][0], AssetLoader.playerregs[3][1], AssetLoader.playerregs[3][2]);
		UP_stay = AssetLoader.playerregs[3][1];
		R_frames.add(AssetLoader.playerregs[2][0], AssetLoader.playerregs[2][1], AssetLoader.playerregs[2][2]);
		R_stay = AssetLoader.playerregs[2][1];
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPostUpdate() {
	      if(Gdx.input.isKeyPressed(Input.Keys.A)) {
	    	  _is_move = true;
	            setAxis(-1, 0, true);}
	      else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
	        	 _is_move = true;
	           setAxis(1, 0, true);}
	      else if(Gdx.input.isKeyPressed(Input.Keys.W)) {
	        	 _is_move = true;
	           setAxis(0, 1, true);}
	      else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
	        	 _is_move = true;
	           setAxis(0, -1, true);}
	      else {
	    	  _is_move = false;
	      }
		
	}

	@Override
	public void onBeforeUpdate() {
		// TODO Auto-generated method stub
		
	}
	public void onDispose() {
		
	}

}
