package com.github.dabasan.jxm_samples;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.github.dabasan.ejml_3dtools.Matrix;
import com.github.dabasan.jxm.bd1.BD1Block;
import com.github.dabasan.jxm.bd1.BD1Manipulator;

/**
 * BD1Manipulatorを使用するサンプルコード
 * 
 * @author Daba
 *
 */
public class BD1ManipulatorSample {
	public static void main(String[] args) {
		// BD1ファイルを読み込む。
		BD1Manipulator manipulator;
		try {
			manipulator = new BD1Manipulator("./Data/map.bd1");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// ブロックの数を取得する。
		int numBlocks = manipulator.getNumBlocks();
		System.out.println(numBlocks);

		// テクスチャのファイル名をすべて取得する。
		Map<Integer, String> textureFilenames = manipulator.getTextureFilenames();
		for (var entry : textureFilenames.entrySet()) {
			System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
		}

		// テクスチャのファイル名を変更する。
		manipulator.setTextureFilename(0, "test.bmp");

		// マップを操作する。
		// ここでは、移動→Y軸回りの回転→スケールの変更
		manipulator.translate(0.0, 100.0, 0.0).rotY(Math.PI / 4.0).rescale(1.0, 2.0, 1.0);

		// Z軸反転 (鏡像マップの作成)
		manipulator.invertZ();

		// 行列を使用してマップを変形する。
		// ここでは、Z軸回りの回転→X軸回りの回転
		var rotX = Matrix.createRotationXMatrix(Math.PI / 4.0);
		var rotZ = Matrix.createRotationZMatrix(Math.PI / 4.0);
		var rot = rotX.mult(rotZ);
		manipulator.transform(rot);

		// マップに含まれる各ブロックを直接操作する。
		var random = new Random();
		List<BD1Block> blocks = manipulator.getBlocks();
		for (var block : blocks) {
			// 各面のテクスチャIDを乱数で変更する。
			int[] rands = new int[6];
			for (int i = 0; i < 6; i++) {
				rands[i] = random.nextInt(10);
			}

			block.setTextureIDs(rands);
		}

		// BD1形式で保存する。
		manipulator.saveAsBD1("./Data/map2.bd1");

		// OBJ形式で保存する。
		manipulator.saveAsOBJ("./Data/map2.obj", "./Data/map2.mtl", "map2.mtl", true);
	}
}
