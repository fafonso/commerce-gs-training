package commerce.training.car.garage.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.service.test.ServiceTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.CarGarageProductLocalService;

@RunWith(Arquillian.class)
public class CarGarageProductLocalServiceTest {

	@ClassRule
	@Rule 
	public static final AggregateTestRule AGGREGATE_TEST_RULE = new LiferayIntegrationTestRule();
	
	    @Before
	    public void setUp() throws Exception {
	        _group = GroupTestUtil.addGroup();
	        _user = TestPropsValues.getUser();

	        ServiceTestUtil.setUser(TestPropsValues.getUser());
	    }
	    
	    @Test
	    public void testAddCarGarageProduct() throws Exception {
	        int initialCount = _carGarageProductLocalService.getCarGarageProductsCount();

	        addGarageProduct(_user.getUserId());

	        int actualCount = _carGarageProductLocalService.getCarGarageProductsCount();

	        Assert.assertEquals(initialCount + 1, actualCount);
	    }


	    protected CarGarageProduct addGarageProduct(long userId)
	            throws Exception {
	        ServiceContext serviceContext =
	                ServiceContextTestUtil.getServiceContext(
	                        _group.getGroupId(), userId);

	        return _carGarageProductLocalService.addCarGarageProduct(RandomTestUtil.randomLong(), RandomTestUtil.randomLong(), RandomTestUtil.randomString(), serviceContext);
	            
	    }
	    
	    @DeleteAfterTestRun
	    private Group _group;

	    @Inject
	    private CarGarageProductLocalService _carGarageProductLocalService;

	    private User _user;
}
