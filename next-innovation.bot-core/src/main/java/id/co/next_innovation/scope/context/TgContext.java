/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.scope.context;

import lombok.EqualsAndHashCode;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;

/**
 * The Telegram context. It holds {@link User} information.
 * @author Enis Ö.
 * @see TgContextHolder
 * @see User
 */
@EqualsAndHashCode(of = {"userId", "chatId"})
public class TgContext {

	private User user;
	private Chat chat;
	private long userId;
	private long chatId;

	public void setUser(User user) {
		this.user = user;
		this.userId = user.getId();
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
		this.chatId = chat.getId();
	}

	public long getChatId() {
		return chatId;
	}

	public User getUser() {
		return user;
	}

	public long getUserId() {
		return userId;
	}

}
