package com.liferay.commerce.training.custom.product.web;


import com.liferay.commerce.product.definitions.web.display.context.BaseCPDefinitionsDisplayContext;
import com.liferay.commerce.product.definitions.web.portlet.action.ActionHelper;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.http.HttpServletRequest;

public class CustomCPDefinitionDisplayContext extends BaseCPDefinitionsDisplayContext{
	
	public CustomCPDefinitionDisplayContext(ActionHelper actionHelper, HttpServletRequest httpServletRequest) {
		super(actionHelper, httpServletRequest);
		
		try {
			CPDefinition cp = actionHelper.getCPDefinition(cpRequestHelper.getRenderRequest());
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public long getCPDefinitionId() {
		

		try {
			return actionHelper.getCPDefinition(cpRequestHelper.getRenderRequest()).getCPDefinitionId();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean doesEntityExist(long cpDefinitionId) {
		
		return true;
	}

	
	
}
