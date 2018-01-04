/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.bot.exceptions;

public interface TgTypedExceptionHandler<T extends Throwable> extends TgExceptionHandler {

	@Override
	default boolean accepts(Throwable e) {
		return getExceptionType().isAssignableFrom(e.getClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	default void handle(Throwable e) {
		handleTyped((T) e);
	}

	void handleTyped(T e);

	Class<T> getExceptionType();
}
