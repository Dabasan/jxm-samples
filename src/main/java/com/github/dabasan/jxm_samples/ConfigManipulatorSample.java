package com.github.dabasan.jxm_samples;

import java.io.IOException;

import com.github.dabasan.jxm.properties.config.Config;
import com.github.dabasan.jxm.properties.config.ConfigManipulator;
import com.github.dabasan.jxm.properties.config.KeyCode;

/**
 * ConfigManipulatorを使用するサンプルコード
 * 
 * @author Daba
 *
 */
public class ConfigManipulatorSample {
	public static void main(String[] args) {
		// config.datを読み込む。
		ConfigManipulator manipulator;
		try {
			manipulator = new ConfigManipulator("./Data/config.dat");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// configを取得する。
		Config config = manipulator.getConfig();
		System.out.println(config);

		// ZOOMのキーを変更する。
		config.setZoom(KeyCode.KEY_MOUSE_R);
		// プレイヤー名を変更する。
		config.setName("TestPlayer");

		// configを設定する。
		manipulator.setConfig(config);

		// configを保存する。
		manipulator.saveAsDAT("./Data/config2.dat");
	}
}
