package com.github.dabasan.jxm_samples;

import java.io.IOException;

import com.github.dabasan.jxm.mif.MIFManipulator;
import com.github.dabasan.jxm.mif.MissionInfo;

/**
 * MIFManipulatorを使用するサンプルコード
 * 
 * @author Daba
 *
 */
public class MIFManipulatorSample {
	public static void main(String[] args) {
		// MIFファイルを読み込む。
		MIFManipulator manipulator;
		try {
			manipulator = new MIFManipulator("./Data/test.mif", "Shift-JIS");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// ミッション情報を取得する。
		MissionInfo missionInfo = manipulator.getMissionInfo();
		System.out.println(missionInfo);

		// ミッションのタイトルを変更する。
		missionInfo.setMissionTitle("Mission Title");
		// マップのファイルパスを変更する。
		missionInfo.setPathnameOfBlock("./addon/test/map.bd1");

		// ミッション情報を設定する。
		manipulator.setMissionInfo(missionInfo);

		// MIFファイルを保存する。
		manipulator.saveAsMIF("./Data/test2.mif", "Shift-JIS");
	}
}
