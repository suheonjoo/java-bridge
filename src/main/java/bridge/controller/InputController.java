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
		return (Integer)inputTemplate.call(() -> inputValidService.validBridgeSize(inputView.readBridgeSize()));
	}

	public String getUserMoving() {
		return (String)inputTemplate.call(() -> inputValidService.validUserMoving(inputView.readMoving()));
	}

	public String getUserRestartCommand() {
		return (String)inputTemplate.call(() -> inputValidService.validUserCommand(inputView.readGameCommand()));
	}

}
