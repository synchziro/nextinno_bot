/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.bot.exceptions;

public interface TgExceptionHandler {

	boolean accepts(Throwable e);

	void handle(Throwable e);

}
