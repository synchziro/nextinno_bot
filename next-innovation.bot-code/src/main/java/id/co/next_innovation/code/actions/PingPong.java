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

@TgController(name = "PingPong", description = "Sends back Pong", regex = "\\/cok")
@RequiredArgsConstructor
public class PingPong {

	private final TgMessageService messageService;

	@TgRequest
	public void pong(String command) {
		messageService.sendMessage("Asu!");
		messageService.sendMessage("Picek!");
		messageService.sendMessage("Matamu!");
		messageService.sendMessage("Gatel");

	}

}
