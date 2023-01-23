package bridge.config;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.GameController;
import bridge.controller.InputController;
import bridge.controller.InputTemplate;
import bridge.domain.Bridge;
import bridge.repository.UserBridgeRepository;
import bridge.service.BridgeGame;
import bridge.service.InputValidService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {
	public GameController config() {
		OutputView outputView = new OutputView();
		InputTemplate inputTemplate = new InputTemplate(outputView);
		InputController inputController = new InputController(new InputView(), new InputValidService(),
			inputTemplate);
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		BridgeGame bridgeGame = new BridgeGame(bridgeMaker, new UserBridgeRepository(), new Bridge());
		return new GameController(bridgeGame, outputView, inputController);
	}
}
