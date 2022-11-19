package bridge.service;

import java.util.List;

import bridge.domain.BridgeMaker;
import bridge.repository.BridgeRepository;
import bridge.repository.UserBridgeRepository;

public class GameService {

	private final BridgeMaker bridgeMaker;
	private final BridgeRepository bridgeRepository;
	private final UserBridgeRepository userBridgeRepository;

	public GameService(BridgeMaker bridgeMaker, BridgeRepository bridgeRepository,
		UserBridgeRepository userBridgeRepository) {
		this.bridgeMaker = bridgeMaker;
		this.bridgeRepository = bridgeRepository;
		this.userBridgeRepository = userBridgeRepository;
	}

	public List<String> makeBridge(Integer bridgeSize) {
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
		bridgeRepository.initBridge(bridge, bridgeSize);
		userBridgeRepository.initUserBridge(bridgeSize);
		return bridge;
	}

	public boolean checkValidSpace(String userSpace, Integer currentSpace) {
		return bridgeRepository.checkValidSpace(userSpace, currentSpace);
	}

	public void saveUserSpace(String userMoving) {
		userBridgeRepository.saveUserSpace(userMoving);
	}

}
