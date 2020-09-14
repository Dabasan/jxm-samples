package com.github.dabasan.jxm_samples;

import java.io.IOException;
import java.util.List;

import com.github.dabasan.ejml_3dtools.Matrix;
import com.github.dabasan.jxm.pd1.PD1Manipulator;
import com.github.dabasan.jxm.pd1.PD1Point;

/**
 * PD1Manipulatorを使用するサンプルコード
 * 
 * @author Daba
 *
 */
public class PD1ManipulatorSample {
	public static void main(String[] args) {
		// PD1ファイルを読み込む。
		PD1Manipulator manipulator;
		try {
			manipulator = new PD1Manipulator("./Data/points.pd1");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// ポイントの数を取得する。
		int numPoints = manipulator.getNumPoints();
		System.out.println(numPoints);

		// 人の数(第1パラメータが1か6のポイントの数)を取得する。
		int numCharacters = manipulator.getNumPoints(0, 1) + manipulator.getNumPoints(0, 6);
		System.out.println(numCharacters);

		// ポイントを操作する。
		// ここでは、移動→Y軸回りの回転→スケールの変更
		manipulator.translate(0.0, 100.0, 0.0).rotY(Math.PI / 4.0).rescale(1.0, 2.0, 1.0);

		// ポイントの向きを回転させる。
		manipulator.rotateDirection(Math.PI / 4.0);

		// Z軸反転 (鏡像ミッションの作成)
		manipulator.invertZ();

		// 行列を使用してポイントを変形する。
		// ここでは、Z軸回りの回転→X軸回りの回転
		var rotX = Matrix.createRotationXMatrix(Math.PI / 4.0);
		var rotZ = Matrix.createRotationZMatrix(Math.PI / 4.0);
		var rot = rotX.mult(rotZ);
		manipulator.transform(rot);

		// 各ポイントを直接操作する。
		List<PD1Point> points = manipulator.getPoints();
		for (var point : points) {
			// 武器のポイントだけ45度回転させる。
			if (point.getParameters()[0] == 2) {
				double rotAngle = point.getRotation();
				rotAngle += Math.PI / 4.0;
				point.setRotation(rotAngle);
			}
		}

		// PD1形式で保存する。
		manipulator.saveAsPD1("./Data/points2.pd1");
	}
}
