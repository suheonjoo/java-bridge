package bridge.view;

import java.util.List;

import bridge.util.InputViewConst;
import bridge.util.OutputViewConst;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	public void printGameStart() {
		System.out.println(InputViewConst.START_GAME_PHRASE);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(List<String> userMap, Integer bridgeSize) {
		System.out.println(OutputViewConst.USER_FINAL_RESULT_PHRASE);
		printBridge(userMap, bridgeSize, InputViewConst.MOVING_UP);
		printBridge(userMap, bridgeSize, InputViewConst.MOVING_DOWN);
	}

	private void printBridge(List<String> userMap, Integer bridgeSize, String moving) {
		System.out.print(OutputViewConst.RESULT_PREFIX);
		for (int i = 0; i < bridgeSize; i++) {
			if (userMap.get(i).equals(moving)) {
				System.out.print(OutputViewConst.USER_SPACE);
			}

			//Todo: X 처리도 해야한다 -> 일단 어느정도 완성후에 할 것

			if (!userMap.get(i).equals(moving)) {
				System.out.print(OutputViewConst.BLANK_SPACE);
			}

			if (i != bridgeSize - 1) {
				System.out.print(OutputViewConst.RESULT_PARTITION);
			}
		}
		System.out.println(OutputViewConst.RESULT_SUFFIX);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(String result, Integer count) {
		System.out.println(OutputViewConst.USER_FINAL_RESULT + result);
		System.out.println(OutputViewConst.USER_TRY_COUNT_PHRASE + count); // 여기서 string.format 이용해서 출력받기
	}

	public void printError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
