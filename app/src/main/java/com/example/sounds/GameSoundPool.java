package com.example.sounds;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import com.example.mybeatplane.MainActivity;
import com.example.mybeatplane.R;

public class GameSoundPool {
	private MainActivity mainActivity;
	private SoundPool soundPool;
	private HashMap<Integer,Integer> map;
	public GameSoundPool(MainActivity mainActivity){
		this.mainActivity = mainActivity;
		map = new HashMap<Integer,Integer>();
		soundPool = new SoundPool(8,AudioManager.STREAM_MUSIC,0);
	}
	public void initGameSound(){
		map.put(1, soundPool.load(mainActivity, R.raw.bgm, 1));
		map.put(2, soundPool.load(mainActivity, R.raw.explosion, 1));
		map.put(3, soundPool.load(mainActivity, R.raw.explosion2, 1));
		map.put(4, soundPool.load(mainActivity, R.raw.explosion3, 1));
		map.put(5, soundPool.load(mainActivity, R.raw.end, 1));
		map.put(6, soundPool.load(mainActivity, R.raw.upgrade, 1));
		map.put(7, soundPool.load(mainActivity, R.raw.button, 1));
	}
	//������Ч
	public void playSound(int sound,int loop){
		AudioManager am = (AudioManager)mainActivity.getSystemService(Context.AUDIO_SERVICE);
		float stramVolumeCurrent = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		float stramMaxVolumeCurrent = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		float volume = stramVolumeCurrent/stramMaxVolumeCurrent;
		soundPool.play(map.get(sound), volume, volume, 1, loop, 1.0f);	
	}
}
