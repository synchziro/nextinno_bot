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

@TgController(name = "Admin Action", description = "This action can only be used by admins", regex = "\\/admin")
@RequiredArgsConstructor
public class AdminAction {

	private final TgMessageService messageService;

	@TgRequest
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void admin(String command) {
		messageService.sendMessage("You are an admin!");
	}

}
