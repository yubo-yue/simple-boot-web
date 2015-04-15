package org.simple.repository;

import org.simple.domain.AppCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppCredentialRepository extends JpaRepository<AppCredential, String> {
}
