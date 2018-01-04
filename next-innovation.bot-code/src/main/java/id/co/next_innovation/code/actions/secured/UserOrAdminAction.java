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

@TgController(name = "Admin or User Action", description = "This action can be used by admins and users", regex = "\\/admin_user")
@RequiredArgsConstructor
public class UserOrAdminAction {

	private final TgMessageService messageService;

	@TgRequest
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public void adminOrUser(String command) {
		messageService.sendMessage("You are a user or an admin!");
	}

}
