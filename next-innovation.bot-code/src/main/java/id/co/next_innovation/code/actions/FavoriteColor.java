/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.code.actions;

import id.co.next_innovation.action.TgController;
import id.co.next_innovation.action.TgPostAction;
import id.co.next_innovation.action.TgPreAction;
import id.co.next_innovation.action.request.TgRequest;
import id.co.next_innovation.bot.TgMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@TgController(name = "Favorite Color", description = "Select your favorite color", regex = "\\/favorite_color")
@Scope("tg")
@RequiredArgsConstructor
public class FavoriteColor {

	private final TgMessageService messageService;

	private List<String> colors;

	@TgPreAction
	public void pre() {
		colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
	}

	@TgRequest
	public void favColor(String command) {
		messageService.sendReplyKeyboard("Select your favorite color", colors, true, 2);
	}

	@TgRequest
	public void favColor(String command, String color) {
		messageService.sendMessage(String.format("%s is my favorite color too!", color));
	}

	@TgPostAction
	public void post() {
		messageService.removeKeyboard();
	}

}
