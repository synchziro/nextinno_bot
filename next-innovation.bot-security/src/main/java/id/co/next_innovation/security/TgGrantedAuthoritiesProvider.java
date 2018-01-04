/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.security;

import id.co.next_innovation.scope.context.TgContext;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface TgGrantedAuthoritiesProvider {

	Collection<GrantedAuthority> getAuthoritiesOf(TgContext tgContext);

}
