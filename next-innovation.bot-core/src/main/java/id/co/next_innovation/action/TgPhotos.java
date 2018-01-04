/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.action;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;

import java.util.ArrayList;

/**
 * a concrete class for the {@link java.util.List}<{@link PhotoSize}> that is provided by {@link Message#getPhoto()}
 * @author Enis Ö.
 * @see Message#getPhoto()
 */
public final class TgPhotos extends ArrayList<PhotoSize> {

	public TgPhotos(Message message) {
		super(message.getPhoto().size());
		addAll(message.getPhoto());
	}

}
