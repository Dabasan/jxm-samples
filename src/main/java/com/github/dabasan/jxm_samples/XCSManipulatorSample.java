package com.github.dabasan.jxm_samples;

import java.io.IOException;

import com.github.dabasan.jxm.properties.character.CharacterData;
import com.github.dabasan.jxm.properties.character.xcs.XCSManipulator;

/**
 * XCSManipulatorを使用するサンプルコード
 * 
 * @author Daba
 *
 */
public class XCSManipulatorSample {
	public static void main(String[] args) {
		// XCSファイルを読み込む。
		XCSManipulator manipulator;
		try {
			manipulator = new XCSManipulator("./Data/characters.xcs");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// キャラクター情報を取得する。
		CharacterData[] characters = manipulator.getCharacterData();
		for (var character : characters) {
			System.out.println(character);
		}

		// キャラクターの体力をすべて500にする。
		for (var character : characters) {
			character.setHP(500);
		}

		// キャラクター情報を設定する。
		manipulator.setCharacterData(characters);

		// XCSファイルを保存する。
		manipulator.saveAsXCS("./Data/characters2.xcs");
	}
}
