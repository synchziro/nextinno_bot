/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.code.actions;

import id.co.next_innovation.action.CommandValidator;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.objects.Message;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class FooBarCommandValidator implements CommandValidator {

	private final AtomicBoolean state = new AtomicBoolean();

	@Override
	public boolean validate(Message message) {
		return message.hasText()
				&& message.getText().trim().equalsIgnoreCase("/foo")
				&& state.getAndSet(!state.get());
	}

}
