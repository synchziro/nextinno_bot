/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.code.actions.secured;


import id.co.next_innovation.action.TgController;
import id.co.next_innovation.action.request.TgRequest;
import id.co.next_innovation.bot.TgMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

@TgController(name = "User Action", description = "This action can only be used by users", regex = "\\/user")
@RequiredArgsConstructor
public class UserAction {

	private final TgMessageService messageService;

	@TgRequest
	@PreAuthorize("hasRole('ROLE_USER')")
	public void user(String command) {
		messageService.sendMessage("You are a user!");
	}

}
