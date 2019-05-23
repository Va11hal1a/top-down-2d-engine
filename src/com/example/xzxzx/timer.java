package com.example.xzxzx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class timer {
	public enum task_type{toend, repeat};
	public static Array<task> tasks;
	public static void init() {
		tasks = new Array<task>();
	}
	public static void update() {
		for(int i = 0; i < tasks.size; i++) {
			if(tasks.get(i)._done) {
				tasks.removeIndex(i);
				continue;
			}
			tasks.get(i).update();
			System.out.println(tasks.get(i).time);
		}
	}
	public static void add(float tm, Runnable run, task_type type, int count) {
		tasks.add(new task(tm, run, type, count));
	}
}
