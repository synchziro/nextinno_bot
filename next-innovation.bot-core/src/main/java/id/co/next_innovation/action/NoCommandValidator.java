/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.action;

import org.telegram.telegrambots.api.objects.Message;

/**
 * A useless {@link CommandValidator} that is just ignored by the {@link id.co.next_innovation.bot.TgMessageDispatcher}
 * when specified in {@link TgController} (which it is by default)
 *
 * @author Enis Ö.
 * @see CommandValidator
 * @see TgController
 * @see TgController#commandValidator()
 * @see id.co.next_innovation.bot.TgMessageDispatcher
 */
public final class NoCommandValidator implements CommandValidator {

	private NoCommandValidator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validate(Message message) {
		throw new UnsupportedOperationException();
	}

}
