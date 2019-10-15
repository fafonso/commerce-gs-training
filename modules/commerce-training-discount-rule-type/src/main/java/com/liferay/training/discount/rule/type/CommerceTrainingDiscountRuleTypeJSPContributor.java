package com.liferay.training.discount.rule.type;

import com.liferay.commerce.discount.rule.type.CommerceDiscountRuleTypeJSPContributor;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = "commerce.discount.rule.type.jsp.contributor.key=" + CommerceTrainingDiscountRuleTypeJSPContributor.KEY,
	service = CommerceDiscountRuleTypeJSPContributor.class
)
public class CommerceTrainingDiscountRuleTypeJSPContributor
	implements CommerceDiscountRuleTypeJSPContributor {

	public static final String KEY = "Example";

	@Override
	public void render(
			long l, long l1, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		_jspRenderer.renderJSP(
			_servletContext, httpServletRequest, httpServletResponse,
			"/view.jsp");
	}

	@Reference
	private JSPRenderer _jspRenderer;

	@Reference(target = "(osgi.web.symbolicname=com.liferay.commerce.training.discount.rule.type)")
	private ServletContext _servletContext;

}