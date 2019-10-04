package com.liferay.commerce.training.custom.product.web;


import com.liferay.commerce.product.definitions.web.portlet.action.ActionHelper;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationCategory;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
			"screen.navigation.category.order:Integer=20",
			"screen.navigation.entry.order:Integer=10"
		},
		service = {ScreenNavigationCategory.class, ScreenNavigationEntry.class}
	)
public class CustomProductRenderer implements ScreenNavigationCategory, ScreenNavigationEntry<CPDefinition>{

	@Override
	public String getEntryKey() {
		

		return "Custom Product";
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

		CustomCPDefinitionDisplayContext cpDefinitionChiliDisplayContext =
				new CustomCPDefinitionDisplayContext(
					_actionHelper, request);
		
		request.setAttribute(
				WebKeys.PORTLET_DISPLAY_CONTEXT,
				cpDefinitionChiliDisplayContext);
		
		_jspRenderer.renderJSP(
				_setServletContext, request, response,
				"/custom_details_view.jsp");
	}

	
	@Override
	public boolean isVisible(User user, CPDefinition cpDefinition) {
		

		if(cpDefinition == null)
		{
			return false;
		}
		if(cpDefinition.getProductTypeName().equals("Custom Product")) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String getCategoryKey() {

		return "Custom Product";
	}

	@Override
	public String getLabel(Locale locale) {
		return "Custom Product";
	}

	@Override
	public String getScreenNavigationKey() {
		return "cp.definition.general";
	}

	@Reference
	private ActionHelper _actionHelper;
	
	@Reference
	private JSPRenderer _jspRenderer;

	@Reference(target = "(osgi.web.symbolicname=com.liferay.commerce.training.custom.product.web)")
	private ServletContext _setServletContext;
}
