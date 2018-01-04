/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.action.request;

import id.co.next_innovation.action.TgActionRequestHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.api.objects.Message;

/**
 * A model class to group {@link TgActionRequestHandler} and hop count
 * @author Enis Ö.
 * @see TgParameterType
 * @see TgParameterType#getHops(Class, int)
 * @see TgParameterType#getHops(TgParameterType, Message)
 * @see id.co.next_innovation.bot.TgMessageDispatcher
 */
@Getter
@RequiredArgsConstructor
public class TgRequestHandlerHopsComposition implements Comparable<TgRequestHandlerHopsComposition> {

	private final TgActionRequestHandler handler;
	private final int hops;

	@Override
	public int compareTo(TgRequestHandlerHopsComposition o) {
		return Integer.compare(this.hops, o.hops);
	}
}
