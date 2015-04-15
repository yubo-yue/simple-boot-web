package org.simple.service;

import java.util.List;

import org.simple.domain.AppCredential;

public interface AppCredentialService {

	AppCredential save(AppCredential user);

    List<AppCredential> getList();
    
    /**
     * Get the app credential for specific appId
     * @param appId id of application to retrieve
     * @return AppCredential instance for that appId
     */
    AppCredential getByAppId(String appId);
    
}
