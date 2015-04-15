package org.simple.service;

import java.util.List;

import javax.inject.Inject;

import org.simple.domain.AppCredential;
import org.simple.repository.AppCredentialRepository;
import org.simple.service.exception.AppCredentialDuplicatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppCredentialServiceImpl implements AppCredentialService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppCredentialServiceImpl.class);

	private AppCredentialRepository repository;
	
	@Inject
	public AppCredentialServiceImpl(AppCredentialRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public AppCredential save(AppCredential credential) {
		AppCredential existing = repository.findOne(credential.getAppId());
		if (null != existing) {
			throw new AppCredentialDuplicatedException(credential.getAppId() + " already exists.");
		}
		return repository.save(credential);
	}

	@Transactional(readOnly = true)
	@Override
	public List<AppCredential> getList() {
		LOGGER.debug("Retrieve all app credentials..");
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public AppCredential getByAppId(String appId) {
		AppCredential existing = repository.findOne(appId);
		if (null == existing) {
			LOGGER.debug("No app credential for " + appId);
			return new AppCredential();
		}
		return existing;
	}

}
