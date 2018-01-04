/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.code.actions;

import id.co.next_innovation.action.TgController;
import id.co.next_innovation.action.request.TgRequest;
import id.co.next_innovation.bot.TgMessageService;
import lombok.RequiredArgsConstructor;

@TgController(name = "FooBar", description = "Sends back Bar", commandValidator = FooBarCommandValidator.class)
@RequiredArgsConstructor
public class FooBar {

	private final TgMessageService messageService;

	@TgRequest
	public void foobar(String command) {
		messageService.sendMessage("bar");
	}

}
