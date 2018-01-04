/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.action;

import id.co.next_innovation.action.request.TgParameterType;
import id.co.next_innovation.action.request.TgParameterType.NonMatchingTypeException;
import id.co.next_innovation.action.request.TgRequestHandlerHopsComposition;
import id.co.next_innovation.action.request.TgRequestResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.api.objects.Message;

import java.lang.reflect.Method;
import java.util.List;

/**
 * contains data of {@link id.co.next_innovation.action.request.TgRequest}s in {@link TgController}s ({@link TgAction})
 *
 * @author Enis Ö.
 * @see TgAction
 * @see TgActionRegisterer
 */
@Getter
@Setter
@RequiredArgsConstructor
public final class TgActionRequestHandler {

	private final String name;
	private final Method method;
	private final TgParameterType[] parameters;

	public TgRequestResult execute(Object instance, List<Message> messages) {

		Object[] data = new Object[parameters.length];
		for (int i = 0; i < messages.size(); i++) {
			Message message = messages.get(i);
			TgParameterType parameterType = parameters[i];
			Object datum = parameterType.getData(message);
			data[i] = datum;
		}

		try {
			Object result = method.invoke(instance, data);

			if (result instanceof TgRequestResult) {
				return (TgRequestResult) result;
			}
		} catch (ReflectiveOperationException e) {
			throw new TgActionRequestHandlerException(e);
		}

		return TgRequestResult.OK;
	}

	public TgRequestHandlerHopsComposition getHops(List<Message> messages) throws NonMatchingTypeException {
		int hopsOverall = 0;

		for (int i = 0; i < messages.size(); i++) {
			hopsOverall += TgParameterType.getHops(parameters[i], messages.get(i));
		}

		return new TgRequestHandlerHopsComposition(this, hopsOverall);
	}

	public int getParameterCount() {
		return parameters.length;
	}

}
