package com.github.dabasan.jxm_samples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.github.dabasan.jxm.properties.character.CharacterData;
import com.github.dabasan.jxm.properties.character.openxops.CharacterCodeParser;

/**
 * OpenXOPSのソースコードからキャラクター情報を取得するサンプルコード
 * 
 * @author Daba
 *
 */
public class CharacterCodeParserSample {
	public static void main(String[] args) {
		// テキストファイルからOpenXOPSのソースコードを読み込む。
		List<String> code;
		try {
			code = Files.readAllLines(Paths.get("./Data/character_code.txt"),
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// OpenXOPSのソースコードからキャラクター情報を取得する。
		var parser = new CharacterCodeParser();
		Map<Integer, CharacterData> characters = parser.parse(code);
		for (var entry : characters.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
