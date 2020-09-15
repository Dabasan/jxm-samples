package com.github.dabasan.jxm_samples;

import java.io.IOException;

import com.github.dabasan.jxm.properties.character.CharacterData;
import com.github.dabasan.jxm.properties.weapon.WeaponData;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

/**
 * XOPSの実行ファイルから武器情報・キャラクター情報を取得するサンプルコード
 * 
 * @author Daba
 *
 */
public class EXEManipulatorSample {
	public static void main(String[] args) {
		// XOPSの実行ファイルを開く。
		EXEManipulator manipulator;
		try {
			manipulator = new EXEManipulator("./Data/xops0975t.exe");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// 武器情報を取得する。
		WeaponData[] weapons = manipulator.getWeaponData();
		for (var weapon : weapons) {
			System.out.println(weapon);
		}

		// キャラクター情報を取得する。
		CharacterData[] characters = manipulator.getCharacterData();
		for (var character : characters) {
			System.out.println(character);
		}

		// 武器情報とキャラクター情報を実行ファイルに上書きする。
		// 第2引数にnull以外の値を指定すると、上書きする前にバックアップを作成する。
		manipulator.write("./Data/xops0975t.exe", "./Data/xops0975t_backup.exe");
	}
}
