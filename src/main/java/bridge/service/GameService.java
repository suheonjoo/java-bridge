package bridge.service;

import java.util.List;

import bridge.domain.BridgeMaker;
import bridge.repository.BridgeRepository;
import bridge.repository.UserBridgeRepository;
import bridge.repository.UserBridgeStatusDto;
import bridge.util.OutputViewConst;

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
		bridgeRepository.initBridge(bridge);
		return bridge;
	}

	public boolean checkValidSpace(String userSpace, Integer currentSpace) {
		return bridgeRepository.checkValidSpace(userSpace, currentSpace);
	}

	public void saveUserSpace(boolean isCorrectMoving, String userLocation) {
		if (isCorrectMoving) {
			userBridgeRepository.saveUserSpace(userLocation, OutputViewConst.USER_CORRECT_SPACE);
			return;
		}
		userBridgeRepository.saveUserSpace(userLocation, OutputViewConst.USER_WRONG_SPACE);
	}

	public UserBridgeStatusDto getUserBridgeStatusDto() {
		return userBridgeRepository.findUserBridgeStatusDto();
	}

	public void clearUserBridge() {
		userBridgeRepository.clear();
	}

}
