package com.liferay.commerce.training.custom.renderer;

import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.content.render.CPContentRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "commerce.product.content.renderer.key=" + CustomCPContentRenderer.KEY,
                "commerce.product.content.renderer.type=grouped",
                "commerce.product.content.renderer.type=simple",
                "commerce.product.content.renderer.type=virtual",
                "commerce.product.content.renderer.type=Custom Product"
        },
        service = CPContentRenderer.class
)
public class CustomCPContentRenderer implements CPContentRenderer {
    public static final String KEY = "custom";

	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public String getLabel(Locale locale) {
		return KEY;
	}

	@Override
	public void render(CPCatalogEntry cpCatalogEntry, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		_jspRenderer.renderJSP(
                _servletContext, httpServletRequest, httpServletResponse,
                "/view.jsp");
		
	}
	

	@Reference
	private JSPRenderer _jspRenderer;
	
	 @Reference(
	            target = "(osgi.web.symbolicname=com.liferay.commerce.training.custom.renderer)"
	    )
	    private ServletContext _servletContext;
}
