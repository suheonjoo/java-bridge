package bridge.controller;

import bridge.service.GameService;
import bridge.util.InputViewConst;
import bridge.util.OutputViewConst;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final InputController inputController;
	private final GameService gameService;
	private final OutputView outputView;

	public BridgeGame(InputController inputController, GameService gameService, OutputView outputView
	) {
		this.inputController = inputController;
		this.gameService = gameService;
		this.outputView = outputView;

	}

	public void startApplication() {
		inputController.startGame();
		Integer attemptCount = 0;
		Integer bridgeSize = inputController.getBridgeSize();
		gameService.makeBridge(bridgeSize);
		String userResult;
		do {
			userResult = move(bridgeSize);
			attemptCount++;
			if (userResult.equals(OutputViewConst.SUCCESS)) {
				break;
			}
		} while (!retry());
		outputView.printMap(gameService.getUserBridgeStatusDto());
		outputView.printResult(userResult, attemptCount);
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public String move(Integer bridgeSize) {
		boolean validMove;
		Integer currentLocation = 0;
		do {
			String userLocation = inputController.getUserMoving();
			validMove = gameService.checkValidSpace(userLocation, currentLocation);
			if (validMove == false) {
				gameService.saveUserSpace(false, userLocation);
				return OutputViewConst.FAIL;
			}
			gameService.saveUserSpace(true, userLocation);
			currentLocation++;
			outputView.printMap(gameService.getUserBridgeStatusDto());
		} while (currentLocation != bridgeSize);
		return OutputViewConst.SUCCESS;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		String userRestartCommand = inputController.getUserRestartCommand();
		return userRestartCommand.equals(InputViewConst.QUIT);
	}
}
