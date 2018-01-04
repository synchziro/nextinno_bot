/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, January 2018
 */

package id.co.next_innovation.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Registers the {@link TgScope} in the {@link org.springframework.beans.factory.BeanFactory}
 * @author Enis Ö.
 * @see TgScope
 */
@Component
public class TgScopeRegisterer implements BeanFactoryPostProcessor {

	/**
	 * simply registers {@link TgScope} with the name "tg"
	 * @param factory
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
		factory.registerScope("tg", new TgScope());
	}

}
