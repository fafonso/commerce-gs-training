package com.liferay.commerce.training.account.selector.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;


@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Training",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=commercetrainingaccountselector",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CommerceTrainingAccountSelectorPortlet extends MVCPortlet {
}