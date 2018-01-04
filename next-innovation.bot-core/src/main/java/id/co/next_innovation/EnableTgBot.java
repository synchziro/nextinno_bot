/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * this thing enables all you need to get your spring telegram bot up and running. You just need to put it over any configuration.
 * Make sure, that you've provided the following two properties and you're good to go:
 * <ul><li>bot.token (the token of the bot that you get from the @BotFather in Telegram)</li><li>bot.name (the name you've given your bot)</li></ul><br>
 * it imports the {@link TgConfiguration} configuration. Alternatively you could just {@link Import} the {@link TgConfiguration} yourself
 * @author Enis Ö.
 * @see TgConfiguration
 */
@Import(TgConfiguration.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableTgBot {
}
