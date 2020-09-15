package com.github.dabasan.jxm_samples;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.github.dabasan.jxm.properties.character.CharacterData;
import com.github.dabasan.jxm.properties.character.openxops.CharacterCodeGenerator;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

/**
 * キャラクター情報をOpenXOPSのソースコード形式で出力するサンプルコード<br>
 * XOPSの実行ファイルから読み込んだキャラクター情報をOpenXOPSのソースコード形式で出力する。
 * 
 * @author Daba
 *
 */
public class CharacterCodeGeneratorSample {
	public static void main(String[] args) {
		// XOPSの実行ファイルからキャラクター情報を読み込む。
		EXEManipulator manipulator;
		try {
			manipulator = new EXEManipulator("./Data/xops0975t.exe");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		CharacterData[] arrCharacters = manipulator.getCharacterData();
		List<CharacterData> characters = Arrays.asList(arrCharacters);

		// OpenXOPSのソースコードを出力する。
		var generator = new CharacterCodeGenerator();
		String code = generator.generate(characters);
		System.out.println(code);
	}
}
