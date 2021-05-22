package com.wadi.share;

import java.security.SecureRandom;
import java.util.Random;

public class utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPABET = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";

	public String generateUserId(int length) {
		return generateRandomString(length);

	}

	public String generateRandomString(int length) {
		StringBuilder returnVal = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			returnVal.append(ALPABET.charAt(RANDOM.nextInt(ALPABET.length())));
		}

		return new String(returnVal);

	}

}
