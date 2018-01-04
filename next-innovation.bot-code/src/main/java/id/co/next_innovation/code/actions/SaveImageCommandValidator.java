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

@Component
public class SaveImageCommandValidator implements CommandValidator {

	@Override
	public boolean validate(Message message) {
		return message.hasPhoto();
	}

}
