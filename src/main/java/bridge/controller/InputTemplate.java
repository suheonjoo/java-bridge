package bridge.controller;

import java.util.function.Supplier;

import bridge.view.OutputView;

public class InputTemplate {

	private final OutputView outputView;

	public InputTemplate(OutputView outputView) {
		this.outputView = outputView;
	}

	public <T> T call(Supplier<T> serverStartCallback) {
		try {
			return serverStartCallback.get();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return call(serverStartCallback);
		}
	}

}
