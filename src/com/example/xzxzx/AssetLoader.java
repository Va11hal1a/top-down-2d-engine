package com.example.xzxzx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;

public class AssetLoader {
	public static Array<TextureRegion> base;
	public static BitmapFont font;
	public static Skin skinUI;
	public static Texture player;
	public static TextureRegion[][] playerregs;
	public static void init() {
		Texture texture = new Texture(Gdx.files.internal("font.png"));
		font = new BitmapFont(Gdx.files.internal("font.fnt"), new TextureRegion(texture));
		skinUI = new Skin(Gdx.files.internal("uiskin.jsonUI"));
		player = new Texture(Gdx.files.internal("test.png"));
		playerregs = TextureRegion.split(player, 48, 48);
	}
	private static void load(Texture texture, short w, short h) {
		TextureRegion[][] reg = TextureRegion.split(texture, w, h);
		for(int x = 0; x < reg[0].length; x++) {
			for(int y = 0; y < reg.length; y++) {
				base.add(reg[y][x]);
			}
	    }
	}
	private static void load_asset(int j) {
		for(int i = 1; i < j; i++) {
			load(new Texture(Gdx.files.internal(String.valueOf(i) + ".png")), (short)32, (short)32);
		}
	}
}
