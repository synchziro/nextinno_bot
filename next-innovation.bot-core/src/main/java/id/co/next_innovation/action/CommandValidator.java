/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.action;

import org.telegram.telegrambots.api.objects.Message;

/**
 * used to implement a logic for resolving if an {@link TgController} is valid for a given command.
 * @author Enis Ö.
 * @see TgController
 * @see TgController#regex()
 * @see NoCommandValidator
 */
@FunctionalInterface
public interface CommandValidator {

	boolean validate(Message message);

}
