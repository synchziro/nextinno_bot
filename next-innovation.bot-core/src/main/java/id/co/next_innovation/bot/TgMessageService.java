/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.bot;

import id.co.next_innovation.scope.context.TgContext;
import id.co.next_innovation.scope.context.TgContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Message;

import java.util.List;

/**
 * Telegram message service. Sends messages to the current {@link TgContext} user
 *
 * @author Enis Ö.
 */
@Service
@Scope("tg")
@RequiredArgsConstructor
public class TgMessageService {
    // TODO: implements every message type that can be sent in tg

    private final TgBot tgBot;
    private final TgMessageServiceContextless messageServiceContextless;

    /**
     * @see TgMessageServiceContextless#sendMessage(long, String)
     */
    public Message sendMessage(String message) {
        return messageServiceContextless.sendMessage(getCurrentUserId(), message);
    }

    /**
     * @see TgMessageServiceContextless#editMessage(String, Message)
     */
    public void editMessage(String messageText, Message message) {
        messageServiceContextless.editMessage(messageText, message);
    }

    /**
     * @see TgMessageServiceContextless#sendReplyKeyboard(long, String, List, boolean, int)
     */
    public Message sendReplyKeyboard(String message, List<String> keyboardData, boolean oneTimeKeyboard, int maxColumns) {
        return messageServiceContextless.sendReplyKeyboard(getCurrentUserId(), message, keyboardData, oneTimeKeyboard, maxColumns);
    }

    /**
     * @see TgMessageServiceContextless#sendReplyKeyboard(long, String, List, boolean)
     */
    public Message sendReplyKeyboard(String message, List<List<String>> keyboardText, boolean oneTimeKeyboard) {
        return messageServiceContextless.sendReplyKeyboard(getCurrentUserId(), message, keyboardText, oneTimeKeyboard);
    }

    /**
     * @see TgMessageServiceContextless#sendReplyKeyboard(long, String, String[][], boolean)
     */
    public Message sendReplyKeyboard(String message, String[][] keyboardText, boolean oneTimeKeyboard) {
        return messageServiceContextless.sendReplyKeyboard(getCurrentUserId(), message, keyboardText, oneTimeKeyboard);
    }

    /**
     * @see TgMessageServiceContextless#removeKeyboard(long)
     */
    public void removeKeyboard() {
        messageServiceContextless.removeKeyboard(getCurrentUserId());
    }

    private long getCurrentUserId() {
        return TgContextHolder.currentContext().getUserId();
    }


}
