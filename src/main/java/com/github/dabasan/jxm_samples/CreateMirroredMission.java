package com.github.dabasan.jxm_samples;

import java.io.IOException;

import com.github.dabasan.jxm.bd1.BD1Manipulator;
import com.github.dabasan.jxm.pd1.PD1Manipulator;

/**
 * 鏡像ミッションを作成するコード
 * 
 * @author Daba
 *
 */
public class CreateMirroredMission {
	public static void main(String[] args) {
		// BD1ファイルとPD1ファイルを読み込む。
		BD1Manipulator bd1Manipulator;
		PD1Manipulator pd1Manipulator;
		try {
			bd1Manipulator = new BD1Manipulator("./Data/map.bd1");
			pd1Manipulator = new PD1Manipulator("./Data/points.pd1");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// Z軸を反転する。
		bd1Manipulator.invertZ();
		pd1Manipulator.invertZ();

		// BD1とPD1を保存する。
		bd1Manipulator.saveAsBD1("./Data/mirrored_map.bd1");
		pd1Manipulator.saveAsPD1("./Data/mirrored_points.pd1");
	}
}
