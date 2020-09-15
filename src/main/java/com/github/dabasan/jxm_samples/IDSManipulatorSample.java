package com.github.dabasan.jxm_samples;

import java.io.IOException;

import com.github.dabasan.jxm.properties.weapon.WeaponData;
import com.github.dabasan.jxm.properties.weapon.ids.IDSManipulator;

/**
 * IDSManipulatorを使用するサンプルコード
 * 
 * @author Daba
 *
 */
public class IDSManipulatorSample {
	public static void main(String[] args) {
		// IDSファイルを読み込む。
		IDSManipulator manipulator;
		try {
			manipulator = new IDSManipulator("./Data/mp5.ids");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// 武器情報を取得する。
		WeaponData weapon = manipulator.getWeaponData();
		System.out.println(weapon);

		// 武器名を変更する。
		weapon.setName("Test");
		// 攻撃力を変更する。
		weapon.setAttacks(100);

		// 武器情報を設定する。
		manipulator.setWeaponData(weapon);

		// IDSファイルを保存する。
		manipulator.saveAsIDS("./Data/test.ids");
	}
}
