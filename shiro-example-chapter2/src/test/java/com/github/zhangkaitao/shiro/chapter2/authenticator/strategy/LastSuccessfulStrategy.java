package com.github.zhangkaitao.shiro.chapter2.authenticator.strategy;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AbstractAuthenticationStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;

public class LastSuccessfulStrategy extends AbstractAuthenticationStrategy {
	@Override
	protected AuthenticationInfo merge(AuthenticationInfo info,
			AuthenticationInfo aggregate) {
		// TODO Auto-generated method stub
		if (info != null && !CollectionUtils.isEmpty(info.getPrincipals()))
			return info;
		else
			return aggregate;
	}

	@Override
	public AuthenticationInfo afterAttempt(Realm realm,
			AuthenticationToken token, AuthenticationInfo singleRealmInfo,
			AuthenticationInfo aggregateInfo, Throwable t)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return merge(singleRealmInfo, aggregateInfo);
	}
}
