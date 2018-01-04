/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.action.request;

/**
 * May be returned in any {@link id.co.next_innovation.action.TgController} class method annotated with {@link TgRequest} to gain more
 * control over your actions.
 * @author Enis Ö.
 * @see TgRequest
 */
public enum TgRequestResult {
	OK, ABORT, RETRY
}
