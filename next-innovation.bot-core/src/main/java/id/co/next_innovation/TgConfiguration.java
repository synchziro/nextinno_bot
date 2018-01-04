package id.co.next_innovation;

import id.co.next_innovation.bot.TgBot;
import id.co.next_innovation.bot.TgBotMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 * Spring configuration that loads all relevant spring-tg components
 * @author Enis Ö.
 * @see EnableTgBot
 */
@Configuration
@ComponentScan(value = "id.co.next_innovation")
@RequiredArgsConstructor
public class TgConfiguration {

	private final TgBotMessageHandler messageHandler;

	/**
	 * initializes the central telegram bot using the wonderful {@link ApiContextInitializer}.
	 * @return TgBot bean
	 */
	@Bean
	public TgBot tgBot() {
		ApiContextInitializer.init();
		return new TgBot(messageHandler);
	}

	@Bean
	public TelegramBotsApi telegramBotsApi() {
		return new TelegramBotsApi();
	}

}
