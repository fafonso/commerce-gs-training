<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %><%@
taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/expando" prefix="liferay-expando" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/soy" prefix="soy" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/trash" prefix="liferay-trash" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>

<%@ page import="com.liferay.training.product.display.VehicleServiceDisplayContext" %>
<%@ page import="commerce.training.car.garage.model.CarGarage" %>
<%@ page import="commerce.training.car.garage.model.CarGarageProduct" %>
<%@ page import="commerce.training.car.garage.service.CarGarageLocalService" %>
<%@ page import="commerce.training.car.garage.service.CarGarageProductLocalService" %>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.commerce.product.model.CPDefinition" %>

<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="com.liferay.commerce.product.constants.CPPortletKeys" %>
<%@ page import="com.liferay.commerce.product.model.CPDefinition" %>

<%@ page import="javax.portlet.PortletURL" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
