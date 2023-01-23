package bridge.controller;

import java.util.function.Supplier;

import bridge.view.OutputView;

public class Template {

	private final OutputView outputView;

	public Template(OutputView outputView) {
		this.outputView = outputView;
	}

	public Object work(Supplier serverStartCallback) {
		try {
			return serverStartCallback.get();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return work(serverStartCallback);
		}
	}

}
