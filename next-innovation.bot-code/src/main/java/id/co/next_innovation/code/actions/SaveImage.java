/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.code.actions;

import com.google.common.io.Files;
import id.co.next_innovation.action.TgController;
import id.co.next_innovation.action.TgPhotos;
import id.co.next_innovation.action.request.TgRequest;
import id.co.next_innovation.bot.TgFileService;
import id.co.next_innovation.bot.TgMessageService;
import id.co.next_innovation.scope.context.TgContext;
import id.co.next_innovation.scope.context.TgContextHolder;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.api.objects.PhotoSize;

import java.io.File;
import java.io.IOException;

@TgController(name = "Save Image", description = "Saves any image to the disk", commandValidator = SaveImageCommandValidator.class)
@RequiredArgsConstructor
public class SaveImage {

	private final TgMessageService messageService;
	private final TgFileService fileService;

	@TgRequest
	public void saveImage(TgPhotos photos) {
		PhotoSize largest = photos.get(photos.size() - 1);
		File tmpFile = fileService.download(largest);

		TgContext tgContext = TgContextHolder.currentContext();
		String dirName = String.format("./%d_%s", tgContext.getUser().getId(), tgContext.getUser().getUserName());

		File dir = new File(dirName);
		if (!dir.exists())
			if (!dir.mkdirs())
				throw new IllegalStateException("Could not create directory");

		File file = new File(dir, tmpFile.getName());

		try {
			Files.copy(tmpFile, file);
			messageService.sendMessage("File saved!");
		} catch (IOException e) {
			messageService.sendMessage("Failed to save file!");
			throw new IllegalStateException(e);
		}

	}

}
