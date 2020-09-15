package com.github.dabasan.jxm_samples;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.github.dabasan.jxm.properties.weapon.WeaponData;
import com.github.dabasan.jxm.properties.weapon.openxops.WeaponCodeGenerator;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

/**
 * OpenXOPSのソースコードから武器情報を出力するサンプルコード<br>
 * XOPSの実行ファイルから読み込んだ武器情報をOpenXOPSのソースコード形式で出力する。
 * 
 * @author Daba
 *
 */
public class WeaponCodeGeneratorSample {
	public static void main(String[] args) {
		// XOPSの実行ファイルから武器情報を読み込む。
		EXEManipulator manipulator;
		try {
			manipulator = new EXEManipulator("./Data/xops0975t.exe");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		WeaponData[] arrWeapons = manipulator.getWeaponData();
		List<WeaponData> weapons = Arrays.asList(arrWeapons);

		// OpenXOPSのソースコードを出力する。
		var generator = new WeaponCodeGenerator();
		String code = generator.generate(weapons);

		System.out.println(code);
	}
}
