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
import com.liferay.portal.kernel.test.AssertUtils;
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

import commerce.training.car.garage.exception.NoSuchCarGarageException;
import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.service.CarGarageLocalServiceUtil;
import commerce.training.car.garage.service.persistence.CarGaragePersistence;
import commerce.training.car.garage.service.persistence.CarGarageUtil;

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
public class CarGaragePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "commerce.training.car.garage.service"));

	@Before
	public void setUp() {
		_persistence = CarGarageUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CarGarage> iterator = _carGarages.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarage carGarage = _persistence.create(pk);

		Assert.assertNotNull(carGarage);

		Assert.assertEquals(carGarage.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CarGarage newCarGarage = addCarGarage();

		_persistence.remove(newCarGarage);

		CarGarage existingCarGarage = _persistence.fetchByPrimaryKey(
			newCarGarage.getPrimaryKey());

		Assert.assertNull(existingCarGarage);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCarGarage();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarage newCarGarage = _persistence.create(pk);

		newCarGarage.setUuid(RandomTestUtil.randomString());

		newCarGarage.setGroupId(RandomTestUtil.nextLong());

		newCarGarage.setCompanyId(RandomTestUtil.nextLong());

		newCarGarage.setUserId(RandomTestUtil.nextLong());

		newCarGarage.setUserName(RandomTestUtil.randomString());

		newCarGarage.setCreateDate(RandomTestUtil.nextDate());

		newCarGarage.setModifiedDate(RandomTestUtil.nextDate());

		newCarGarage.setCpDefinitionId(RandomTestUtil.nextLong());

		newCarGarage.setTitle(RandomTestUtil.randomString());

		newCarGarage.setLatitude(RandomTestUtil.nextDouble());

		newCarGarage.setLongitude(RandomTestUtil.nextDouble());

		_carGarages.add(_persistence.update(newCarGarage));

		CarGarage existingCarGarage = _persistence.findByPrimaryKey(
			newCarGarage.getPrimaryKey());

		Assert.assertEquals(
			existingCarGarage.getUuid(), newCarGarage.getUuid());
		Assert.assertEquals(
			existingCarGarage.getCarGarageId(), newCarGarage.getCarGarageId());
		Assert.assertEquals(
			existingCarGarage.getGroupId(), newCarGarage.getGroupId());
		Assert.assertEquals(
			existingCarGarage.getCompanyId(), newCarGarage.getCompanyId());
		Assert.assertEquals(
			existingCarGarage.getUserId(), newCarGarage.getUserId());
		Assert.assertEquals(
			existingCarGarage.getUserName(), newCarGarage.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCarGarage.getCreateDate()),
			Time.getShortTimestamp(newCarGarage.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCarGarage.getModifiedDate()),
			Time.getShortTimestamp(newCarGarage.getModifiedDate()));
		Assert.assertEquals(
			existingCarGarage.getCpDefinitionId(),
			newCarGarage.getCpDefinitionId());
		Assert.assertEquals(
			existingCarGarage.getTitle(), newCarGarage.getTitle());
		AssertUtils.assertEquals(
			existingCarGarage.getLatitude(), newCarGarage.getLatitude());
		AssertUtils.assertEquals(
			existingCarGarage.getLongitude(), newCarGarage.getLongitude());
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
	public void testCountByCPDefinitionId() throws Exception {
		_persistence.countByCPDefinitionId(RandomTestUtil.nextLong());

		_persistence.countByCPDefinitionId(0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CarGarage newCarGarage = addCarGarage();

		CarGarage existingCarGarage = _persistence.findByPrimaryKey(
			newCarGarage.getPrimaryKey());

		Assert.assertEquals(existingCarGarage, newCarGarage);
	}

	@Test(expected = NoSuchCarGarageException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CarGarage> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CarGarage", "uuid", true, "carGarageId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "cpDefinitionId", true, "title", true,
			"latitude", true, "longitude", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CarGarage newCarGarage = addCarGarage();

		CarGarage existingCarGarage = _persistence.fetchByPrimaryKey(
			newCarGarage.getPrimaryKey());

		Assert.assertEquals(existingCarGarage, newCarGarage);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarage missingCarGarage = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCarGarage);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CarGarage newCarGarage1 = addCarGarage();
		CarGarage newCarGarage2 = addCarGarage();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCarGarage1.getPrimaryKey());
		primaryKeys.add(newCarGarage2.getPrimaryKey());

		Map<Serializable, CarGarage> carGarages =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, carGarages.size());
		Assert.assertEquals(
			newCarGarage1, carGarages.get(newCarGarage1.getPrimaryKey()));
		Assert.assertEquals(
			newCarGarage2, carGarages.get(newCarGarage2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CarGarage> carGarages =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(carGarages.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CarGarage newCarGarage = addCarGarage();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCarGarage.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CarGarage> carGarages =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, carGarages.size());
		Assert.assertEquals(
			newCarGarage, carGarages.get(newCarGarage.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CarGarage> carGarages =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(carGarages.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CarGarage newCarGarage = addCarGarage();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCarGarage.getPrimaryKey());

		Map<Serializable, CarGarage> carGarages =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, carGarages.size());
		Assert.assertEquals(
			newCarGarage, carGarages.get(newCarGarage.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CarGarageLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CarGarage>() {

				@Override
				public void performAction(CarGarage carGarage) {
					Assert.assertNotNull(carGarage);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CarGarage newCarGarage = addCarGarage();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarage.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"carGarageId", newCarGarage.getCarGarageId()));

		List<CarGarage> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CarGarage existingCarGarage = result.get(0);

		Assert.assertEquals(existingCarGarage, newCarGarage);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarage.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"carGarageId", RandomTestUtil.nextLong()));

		List<CarGarage> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CarGarage newCarGarage = addCarGarage();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarage.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("carGarageId"));

		Object newCarGarageId = newCarGarage.getCarGarageId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"carGarageId", new Object[] {newCarGarageId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCarGarageId = result.get(0);

		Assert.assertEquals(existingCarGarageId, newCarGarageId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CarGarage.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("carGarageId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"carGarageId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CarGarage newCarGarage = addCarGarage();

		_persistence.clearCache();

		CarGarage existingCarGarage = _persistence.findByPrimaryKey(
			newCarGarage.getPrimaryKey());

		Assert.assertTrue(
			Objects.equals(
				existingCarGarage.getUuid(),
				ReflectionTestUtil.invoke(
					existingCarGarage, "getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(
			Long.valueOf(existingCarGarage.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingCarGarage, "getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(
			Long.valueOf(existingCarGarage.getCpDefinitionId()),
			ReflectionTestUtil.<Long>invoke(
				existingCarGarage, "getOriginalCpDefinitionId",
				new Class<?>[0]));
	}

	protected CarGarage addCarGarage() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CarGarage carGarage = _persistence.create(pk);

		carGarage.setUuid(RandomTestUtil.randomString());

		carGarage.setGroupId(RandomTestUtil.nextLong());

		carGarage.setCompanyId(RandomTestUtil.nextLong());

		carGarage.setUserId(RandomTestUtil.nextLong());

		carGarage.setUserName(RandomTestUtil.randomString());

		carGarage.setCreateDate(RandomTestUtil.nextDate());

		carGarage.setModifiedDate(RandomTestUtil.nextDate());

		carGarage.setCpDefinitionId(RandomTestUtil.nextLong());

		carGarage.setTitle(RandomTestUtil.randomString());

		carGarage.setLatitude(RandomTestUtil.nextDouble());

		carGarage.setLongitude(RandomTestUtil.nextDouble());

		_carGarages.add(_persistence.update(carGarage));

		return carGarage;
	}

	private List<CarGarage> _carGarages = new ArrayList<CarGarage>();
	private CarGaragePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}