/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.bot.exceptions;

import id.co.next_innovation.bot.TgMessageDispatcher.TgDispatchException;
import id.co.next_innovation.bot.TgMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class TgDispatchExceptionHandler implements TgTypedExceptionHandler<TgDispatchException> {

	private final TgMessageService tgMessageService;

	@Override
	public Class<TgDispatchException> getExceptionType() {
		return TgDispatchException.class;
	}

	@Override
	public void handleTyped(TgDispatchException e) {
		tgMessageService.sendMessage(String.format("Error:%n%s", e.getMessage()));
	}

}
