package com.github.dabasan.jxm_samples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.github.dabasan.jxm.properties.weapon.WeaponData;
import com.github.dabasan.jxm.properties.weapon.openxops.WeaponCodeParser;

/**
 * OpenXOPSのソースコードから武器情報を取得するサンプルコード
 * 
 * @author Daba
 *
 */
public class WeaponCodeParserSample {
	public static void main(String[] args) {
		// テキストファイルからOpenXOPSのソースコードを読み込む。
		List<String> code;
		try {
			code = Files.readAllLines(Paths.get("./Data/weapon_code.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// OpenXOPSのソースコードから武器情報を取得する。
		var parser = new WeaponCodeParser();
		Map<Integer, WeaponData> weapons = parser.parse(code);
		for (var entry : weapons.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
