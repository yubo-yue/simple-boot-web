package org.simple.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity(name = "AppCredential")
@Table(name = "app_credential")
public class AppCredential {

	@Id
	@NotNull
	@Size(max = 64)
	@Column(name = "app_id", nullable = false, updatable = false)
	private String appId;

	@NotNull
	@Column(name = "create_time", nullable = false, updatable = false)
	private Date createTime;

	@Column(name = "update_time", nullable = false)
	private Date updateTime;

	@NotNull
	@Size(max = 64)
	@Column(name = "credential", nullable = false)
	private String credential;

	@NotNull
	@Column(name = "ttl", nullable = false)
	private int timeToLive = 30;

	@NotNull
	@Column(name = "enabled", nullable = false)
	private boolean enabled = false; // default is disabled

	public AppCredential() {
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public int getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enable) {
		this.enabled = enable;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAppId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
