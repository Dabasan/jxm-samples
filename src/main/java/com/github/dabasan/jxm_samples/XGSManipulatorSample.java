package com.github.dabasan.jxm_samples;

import java.io.IOException;

import com.github.dabasan.jxm.properties.weapon.WeaponData;
import com.github.dabasan.jxm.properties.weapon.xgs.XGSManipulator;

/**
 * XGSManipulatorを使用するサンプルコード
 * 
 * @author Daba
 *
 */
public class XGSManipulatorSample {
	public static void main(String[] args) {
		// XGSファイルを読み込む。
		XGSManipulator manipulator;
		try {
			manipulator = new XGSManipulator("./Data/weapons.xgs");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// 武器情報を取得する。
		WeaponData[] weapons = manipulator.getWeaponData();
		for (var weapon : weapons) {
			System.out.println(weapon);
		}

		// 武器名を変更する。
		for (int i = 0; i < weapons.length; i++) {
			var weapon = weapons[i];
			weapon.setName(String.valueOf(i));
		}

		// 武器情報を設定する。
		manipulator.setWeaponData(weapons);

		// XGSファイルを保存する。
		manipulator.saveAsXGS("./Data/weapons2.xgs");
	}
}
