/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.bot.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

/**
 * takes care of dispatching exceptions to the right {@link TgExceptionHandler}s
 *
 * @author Enis Ö.
 * @see id.co.next_innovation.bot.TgBot
 */
@Component
@Scope("tg")
@RequiredArgsConstructor
public final class TgExceptionDispatcher {

	private final Set<TgExceptionHandler> tgExceptionHandlers;

	/**
	 * tries to find the first matching {@link TgExceptionHandler} and let it handle the given {@link Throwable}
	 *
	 * @param e the {@link Throwable} that should be handled
	 * @return true if it found a matching {@link TgExceptionHandler}, false otherwise
	 * @see TgExceptionHandler
	 * @see TgTypedExceptionHandler
	 */
	public boolean dispatchException(final Throwable e) {

		Optional<TgExceptionHandler> handlerOptional =
				tgExceptionHandlers
						.stream()
						.filter(h -> h.accepts(e))
						.findFirst();

		if (handlerOptional.isPresent()) {
			handlerOptional.get().handle(e);
			return true;
		}

		return false;

	}

}
