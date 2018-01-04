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

import java.io.Console;
import java.io.IOException;

@TgController(name = "test command", description = "tes command", regex = "\\/start\\ httpd")
@RequiredArgsConstructor
public class TestCommand {

    private final TgMessageService messageService;

    @TgRequest
    public void test(String command) {
        messageService.sendMessage("yes sir");
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder();
//            processBuilder.command("/Users/winnerawan/tes.sh");
//            processBuilder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
