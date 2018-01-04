/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.generics.LongPollingBot;

import javax.annotation.PostConstruct;

/**
 * @author Enis Ö.
 * @see TgBot
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TgBotService {

	private final TgBot tgBot;
	private final TelegramBotsApi telegramBotsApi;

	/**
	 * registers the {@link TgBot} using {@link TelegramBotsApi#registerBot(LongPollingBot)}
	 */
	@PostConstruct
	private void init() {
		try {
			telegramBotsApi.registerBot(tgBot);
		} catch (TelegramApiRequestException e) {
			log.error(String.format("Failed to initialize Telegram Bot: %s", e.getMessage()), e);
		}
	}

}