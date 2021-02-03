
package com.liferay.commerce.training.data.source;

import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.catalog.CPQuery;
import com.liferay.commerce.product.constants.CPWebKeys;
import com.liferay.commerce.product.data.source.CPDataSource;
import com.liferay.commerce.product.data.source.CPDataSourceResult;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.util.CPDefinitionHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "commerce.product.data.source.name=" +
	CommerceTrainingDataSource.NAME, service = CPDataSource.class)
public class CommerceTrainingDataSource implements CPDataSource {

	/**
	 * The product data source name must be a unique value so that Liferay
	 * Commerce can distinguish the new datafrom existing data sources.
	 */
	public static final String NAME = "Products Ending in Same Word";

	/**
	 * This method returns a text label that describes how product data source
	 * will search for related products on "Publisher Products". 
	 * with a language key.
	 */
	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "products-ending-in-the-same-word");
	}

	@Override
	public String getName() {

		return NAME;
	}

	/**
	 * This will be where we add the business logic to perform the search for
	 * related products. The HttpServletRequest contains a reference to a
	 * particular product which the results should be related to in some way.
	 * The method will return a CPDataSourceResult, which contains a list of the
	 * search results; see the implementation at CPDataSourceResult.java.
	 */
	@Override
	public CPDataSourceResult getResult(
		HttpServletRequest httpServletRequest, int start, int end)
		throws Exception {

		CPCatalogEntry cpCatalogEntry =
			(CPCatalogEntry) httpServletRequest.getAttribute(
				CPWebKeys.CP_CATALOG_ENTRY);

		if (cpCatalogEntry == null) {
			return new CPDataSourceResult(new ArrayList<>(), 0);
		}

		SearchContext searchContext = new SearchContext();

		Map<String, Serializable> attributes = new HashMap<>();

		attributes.put(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
		attributes.put(
			"excludedCPDefinitionId", cpCatalogEntry.getCPDefinitionId());

		searchContext.setAttributes(attributes);

		searchContext.setCompanyId(_portal.getCompanyId(httpServletRequest));

		searchContext.setKeywords(
			StringPool.STAR + _getLastWordOfName(cpCatalogEntry));

		return _cpDefinitionHelper.search(
			_portal.getScopeGroupId(httpServletRequest), searchContext,
			new CPQuery(), start, end);
	}

	/**
	 * Returns the last name of the cpCatalogEntry
	 * @param cpCatalogEntry
	 * @return
	 * @throws Exception
	 */
	private String _getLastWordOfName(CPCatalogEntry cpCatalogEntry)
		throws Exception {

		CPDefinition cpDefinition = _cpDefinitionLocalService.getCPDefinition(
			cpCatalogEntry.getCPDefinitionId());

		String cpDefinitionName = cpDefinition.getName();

		String[] nameTokens = cpDefinitionName.split(" ");

		return nameTokens[nameTokens.length - 1];
	}

	@Reference
	private CPDefinitionHelper _cpDefinitionHelper;

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Reference
	private Portal _portal;

}
