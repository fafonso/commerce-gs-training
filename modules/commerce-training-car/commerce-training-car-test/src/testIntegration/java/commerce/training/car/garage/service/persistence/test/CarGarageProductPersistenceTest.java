/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package commerce.training.car.garage.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import commerce.training.car.garage.exception.NoSuchCarGarageProductException;
import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.CarGarageProductLocalServiceUtil;
import commerce.training.car.garage.service.persistence.CarGarageProductPersistence;
import commerce.training.car.garage.service.persistence.CarGarageProductUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CarGarageProductPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "commerce.training.car.garage.service"));

	@Before
	public void setUp() {
		_persistence = CarGarageProductUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CarGarageProduct> iterator = _carGarageProducts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarageProduct carGarageProduct = _persistence.create(pk);

		Assert.assertNotNull(carGarageProduct);

		Assert.assertEquals(carGarageProduct.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		_persistence.remove(newCarGarageProduct);

		CarGarageProduct existingCarGarageProduct =
			_persistence.fetchByPrimaryKey(newCarGarageProduct.getPrimaryKey());

		Assert.assertNull(existingCarGarageProduct);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCarGarageProduct();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarageProduct newCarGarageProduct = _persistence.create(pk);

		newCarGarageProduct.setUuid(RandomTestUtil.randomString());

		newCarGarageProduct.setGroupId(RandomTestUtil.nextLong());

		newCarGarageProduct.setCompanyId(RandomTestUtil.nextLong());

		newCarGarageProduct.setUserId(RandomTestUtil.nextLong());

		newCarGarageProduct.setUserName(RandomTestUtil.randomString());

		newCarGarageProduct.setCreateDate(RandomTestUtil.nextDate());

		newCarGarageProduct.setModifiedDate(RandomTestUtil.nextDate());

		newCarGarageProduct.setCarGarageId(RandomTestUtil.nextLong());

		newCarGarageProduct.setCpDefinitionId(RandomTestUtil.nextLong());

		newCarGarageProduct.setTitle(RandomTestUtil.randomString());

		_carGarageProducts.add(_persistence.update(newCarGarageProduct));

		CarGarageProduct existingCarGarageProduct =
			_persistence.findByPrimaryKey(newCarGarageProduct.getPrimaryKey());

		Assert.assertEquals(
			existingCarGarageProduct.getUuid(), newCarGarageProduct.getUuid());
		Assert.assertEquals(
			existingCarGarageProduct.getCarGarageProductId(),
			newCarGarageProduct.getCarGarageProductId());
		Assert.assertEquals(
			existingCarGarageProduct.getGroupId(),
			newCarGarageProduct.getGroupId());
		Assert.assertEquals(
			existingCarGarageProduct.getCompanyId(),
			newCarGarageProduct.getCompanyId());
		Assert.assertEquals(
			existingCarGarageProduct.getUserId(),
			newCarGarageProduct.getUserId());
		Assert.assertEquals(
			existingCarGarageProduct.getUserName(),
			newCarGarageProduct.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCarGarageProduct.getCreateDate()),
			Time.getShortTimestamp(newCarGarageProduct.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCarGarageProduct.getModifiedDate()),
			Time.getShortTimestamp(newCarGarageProduct.getModifiedDate()));
		Assert.assertEquals(
			existingCarGarageProduct.getCarGarageId(),
			newCarGarageProduct.getCarGarageId());
		Assert.assertEquals(
			existingCarGarageProduct.getCpDefinitionId(),
			newCarGarageProduct.getCpDefinitionId());
		Assert.assertEquals(
			existingCarGarageProduct.getTitle(),
			newCarGarageProduct.getTitle());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByCarGarageId() throws Exception {
		_persistence.countByCarGarageId(RandomTestUtil.nextLong());

		_persistence.countByCarGarageId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		CarGarageProduct existingCarGarageProduct =
			_persistence.findByPrimaryKey(newCarGarageProduct.getPrimaryKey());

		Assert.assertEquals(existingCarGarageProduct, newCarGarageProduct);
	}

	@Test(expected = NoSuchCarGarageProductException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CarGarageProduct> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CarGarageProduct", "uuid", true, "carGarageProductId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "carGarageId", true,
			"cpDefinitionId", true, "title", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		CarGarageProduct existingCarGarageProduct =
			_persistence.fetchByPrimaryKey(newCarGarageProduct.getPrimaryKey());

		Assert.assertEquals(existingCarGarageProduct, newCarGarageProduct);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarageProduct missingCarGarageProduct =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCarGarageProduct);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CarGarageProduct newCarGarageProduct1 = addCarGarageProduct();
		CarGarageProduct newCarGarageProduct2 = addCarGarageProduct();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCarGarageProduct1.getPrimaryKey());
		primaryKeys.add(newCarGarageProduct2.getPrimaryKey());

		Map<Serializable, CarGarageProduct> carGarageProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, carGarageProducts.size());
		Assert.assertEquals(
			newCarGarageProduct1,
			carGarageProducts.get(newCarGarageProduct1.getPrimaryKey()));
		Assert.assertEquals(
			newCarGarageProduct2,
			carGarageProducts.get(newCarGarageProduct2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CarGarageProduct> carGarageProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(carGarageProducts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCarGarageProduct.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CarGarageProduct> carGarageProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, carGarageProducts.size());
		Assert.assertEquals(
			newCarGarageProduct,
			carGarageProducts.get(newCarGarageProduct.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CarGarageProduct> carGarageProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(carGarageProducts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCarGarageProduct.getPrimaryKey());

		Map<Serializable, CarGarageProduct> carGarageProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, carGarageProducts.size());
		Assert.assertEquals(
			newCarGarageProduct,
			carGarageProducts.get(newCarGarageProduct.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CarGarageProductLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CarGarageProduct>() {

				@Override
				public void performAction(CarGarageProduct carGarageProduct) {
					Assert.assertNotNull(carGarageProduct);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarageProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"carGarageProductId",
				newCarGarageProduct.getCarGarageProductId()));

		List<CarGarageProduct> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CarGarageProduct existingCarGarageProduct = result.get(0);

		Assert.assertEquals(existingCarGarageProduct, newCarGarageProduct);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarageProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"carGarageProductId", RandomTestUtil.nextLong()));

		List<CarGarageProduct> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarageProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("carGarageProductId"));

		Object newCarGarageProductId =
			newCarGarageProduct.getCarGarageProductId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"carGarageProductId", new Object[] {newCarGarageProductId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCarGarageProductId = result.get(0);

		Assert.assertEquals(existingCarGarageProductId, newCarGarageProductId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarageProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("carGarageProductId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"carGarageProductId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CarGarageProduct newCarGarageProduct = addCarGarageProduct();

		_persistence.clearCache();

		CarGarageProduct existingCarGarageProduct =
			_persistence.findByPrimaryKey(newCarGarageProduct.getPrimaryKey());

		Assert.assertTrue(
			Objects.equals(
				existingCarGarageProduct.getUuid(),
				ReflectionTestUtil.invoke(
					existingCarGarageProduct, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(
			Long.valueOf(existingCarGarageProduct.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingCarGarageProduct, "getOriginalGroupId",
				new Class<?>[0]));
	}

	protected CarGarageProduct addCarGarageProduct() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarageProduct carGarageProduct = _persistence.create(pk);

		carGarageProduct.setUuid(RandomTestUtil.randomString());

		carGarageProduct.setGroupId(RandomTestUtil.nextLong());

		carGarageProduct.setCompanyId(RandomTestUtil.nextLong());

		carGarageProduct.setUserId(RandomTestUtil.nextLong());

		carGarageProduct.setUserName(RandomTestUtil.randomString());

		carGarageProduct.setCreateDate(RandomTestUtil.nextDate());

		carGarageProduct.setModifiedDate(RandomTestUtil.nextDate());

		carGarageProduct.setCarGarageId(RandomTestUtil.nextLong());

		carGarageProduct.setCpDefinitionId(RandomTestUtil.nextLong());

		carGarageProduct.setTitle(RandomTestUtil.randomString());

		_carGarageProducts.add(_persistence.update(carGarageProduct));

		return carGarageProduct;
	}

	private List<CarGarageProduct> _carGarageProducts =
		new ArrayList<CarGarageProduct>();
	private CarGarageProductPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}