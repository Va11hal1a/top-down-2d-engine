package com.example.xzxzx;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class global {
	public static final String path = "global.co";
	public static HashMap <String, String> map;
	static FileHandle file;
	public static void init() {
		file = Gdx.files.internal(path);
		String data = new String(file.readBytes());
		map = new HashMap<String, String>();
		String[] lines = data.split("\r\n");
		for(int i = 0; i < lines.length; i++) {
			String[] args = lines[i].split(" ");
			map.put(args[0], args[1]);
		}
	}
	public static void upload() {
		FileHandle file = Gdx.files.local("/assets/" + path);
		//file.delete();
		String data = "";
		for(int i = 0; i < map.size(); i++) {
			data += map.keySet().toArray()[i] + " " + map.values().toArray()[i];
			if(i != map.size() - 1) data += "\r\n";
		}
		file.writeString(data, false);
	}
	public static void setInt(String key, int value) {
		map.replace(key, String.valueOf(value));
	}
	public static void setString(String key, String value) {
		map.replace(key, value);
	}
	public static void setBoolean(String key, boolean value) {
		map.replace(key, String.valueOf(value));
	}
	public static Boolean getBoolean(String key) {
		return Boolean.valueOf(map.get(key));
	}
	public static String getString(String key) {
		return map.get(key);
	}
	public static int getInt(String key) {
		return Integer.valueOf(map.get(key));
	}
}
