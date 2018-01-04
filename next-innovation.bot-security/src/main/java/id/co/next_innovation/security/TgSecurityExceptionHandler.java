/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.security;

import id.co.next_innovation.bot.TgMessageService;
import id.co.next_innovation.bot.exceptions.TgTypedExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@Scope("tg")
@RequiredArgsConstructor
public class TgSecurityExceptionHandler implements TgTypedExceptionHandler<AccessDeniedException> {

	private final TgMessageService messageService;

	@Override
	public void handleTyped(AccessDeniedException e) {
		messageService.sendMessage("Insufficient Permissions!");
	}

	@Override
	public Class<AccessDeniedException> getExceptionType() {
		return AccessDeniedException.class;
	}

}
