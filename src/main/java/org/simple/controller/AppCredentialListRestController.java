package org.simple.controller;

import java.util.List;

import javax.inject.Inject;

import org.simple.domain.AppCredential;
import org.simple.service.AppCredentialService;
import org.simple.service.exception.AppCredentialDuplicatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appcredentials")
public class AppCredentialListRestController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppCredentialListRestController.class);

	private AppCredentialService appCredentialService;

	@Inject
	public AppCredentialListRestController(
			final AppCredentialService appCredentialService) {
		this.appCredentialService = appCredentialService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<AppCredential> listAppCredentials() {
		LOGGER.debug("retrive credential list.");
		return appCredentialService.getList();
	}

	/**
	 * 
	 * @param appId get the appId from URI
	 * @return
	 */
	@RequestMapping(value = "/{appId}", method = RequestMethod.GET)
	public AppCredential getAppCredential(@PathVariable String appId) {

		return appCredentialService.getByAppId(appId);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleAppCredentialDuplicatedException(
			AppCredentialDuplicatedException e) {
		return e.getMessage();
	}
}
