package bridge.controller;

import bridge.service.InputValidService;
import bridge.view.InputView;

public class InputController {

	private final InputView inputView;
	private final InputValidService inputValidService;
	private final InputTemplate inputTemplate;

	public InputController(InputView inputView, InputValidService inputValidService,
		InputTemplate inputTemplate) {
		this.inputView = inputView;
		this.inputValidService = inputValidService;
		this.inputTemplate = inputTemplate;
	}

	public Integer getBridgeSize() {
		return inputTemplate.call(() -> inputValidService.validBridgeSize(inputView.readBridgeSize()));
	}

	public String getUserMoving() {
		return inputTemplate.call(() -> inputValidService.validUserMoving(inputView.readMoving()));
	}

	public String getUserRestartCommand() {
		return inputTemplate.call(() -> inputValidService.validUserCommand(inputView.readGameCommand()));
	}

}
