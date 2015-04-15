package org.simple.controller;

import javax.inject.Inject;

import org.simple.service.AppCredentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppCredentialListController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppCredentialListController.class);
	
	private AppCredentialService appCredentialService;

	@Inject
	public AppCredentialListController(
			final AppCredentialService appCredentialService) {
		this.appCredentialService = appCredentialService;
	}

	@RequestMapping("/app_credential_list.html")
	public ModelAndView getCredentialListView() {
		LOGGER.debug("receive request for app credential list.");
		ModelMap model = new ModelMap();
		model.addAttribute("appCredentials", appCredentialService.getList());
		return new ModelAndView("app_credential_list", model);
	}
}
