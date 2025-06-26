/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.service.persistence.test;

import com.employee.service.exception.NoSuchEmployeeDetailException;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalServiceUtil;
import com.employee.service.service.persistence.EmployeeDetailPersistence;
import com.employee.service.service.persistence.EmployeeDetailUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
public class EmployeeDetailPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.employee.service.service"));

	@Before
	public void setUp() {
		_persistence = EmployeeDetailUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmployeeDetail> iterator = _employeeDetails.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeDetail employeeDetail = _persistence.create(pk);

		Assert.assertNotNull(employeeDetail);

		Assert.assertEquals(employeeDetail.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		_persistence.remove(newEmployeeDetail);

		EmployeeDetail existingEmployeeDetail = _persistence.fetchByPrimaryKey(
			newEmployeeDetail.getPrimaryKey());

		Assert.assertNull(existingEmployeeDetail);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmployeeDetail();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeDetail newEmployeeDetail = _persistence.create(pk);

		newEmployeeDetail.setUuid(RandomTestUtil.randomString());

		newEmployeeDetail.setGroupId(RandomTestUtil.nextLong());

		newEmployeeDetail.setCompanyId(RandomTestUtil.nextLong());

		newEmployeeDetail.setUserId(RandomTestUtil.nextLong());

		newEmployeeDetail.setUserName(RandomTestUtil.randomString());

		newEmployeeDetail.setCreateDate(RandomTestUtil.nextDate());

		newEmployeeDetail.setModifiedDate(RandomTestUtil.nextDate());

		newEmployeeDetail.setFirstName(RandomTestUtil.randomString());

		newEmployeeDetail.setLastName(RandomTestUtil.randomString());

		newEmployeeDetail.setEmail(RandomTestUtil.randomString());

		newEmployeeDetail.setPhoneNumber(RandomTestUtil.nextLong());

		newEmployeeDetail.setAddressLine1(RandomTestUtil.randomString());

		newEmployeeDetail.setAddressLine2(RandomTestUtil.randomString());

		newEmployeeDetail.setCity(RandomTestUtil.randomString());

		newEmployeeDetail.setZipCode(RandomTestUtil.nextLong());

		newEmployeeDetail.setDesignation(RandomTestUtil.randomString());

		_employeeDetails.add(_persistence.update(newEmployeeDetail));

		EmployeeDetail existingEmployeeDetail = _persistence.findByPrimaryKey(
			newEmployeeDetail.getPrimaryKey());

		Assert.assertEquals(
			existingEmployeeDetail.getUuid(), newEmployeeDetail.getUuid());
		Assert.assertEquals(
			existingEmployeeDetail.getEmployeeId(),
			newEmployeeDetail.getEmployeeId());
		Assert.assertEquals(
			existingEmployeeDetail.getGroupId(),
			newEmployeeDetail.getGroupId());
		Assert.assertEquals(
			existingEmployeeDetail.getCompanyId(),
			newEmployeeDetail.getCompanyId());
		Assert.assertEquals(
			existingEmployeeDetail.getUserId(), newEmployeeDetail.getUserId());
		Assert.assertEquals(
			existingEmployeeDetail.getUserName(),
			newEmployeeDetail.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmployeeDetail.getCreateDate()),
			Time.getShortTimestamp(newEmployeeDetail.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmployeeDetail.getModifiedDate()),
			Time.getShortTimestamp(newEmployeeDetail.getModifiedDate()));
		Assert.assertEquals(
			existingEmployeeDetail.getFirstName(),
			newEmployeeDetail.getFirstName());
		Assert.assertEquals(
			existingEmployeeDetail.getLastName(),
			newEmployeeDetail.getLastName());
		Assert.assertEquals(
			existingEmployeeDetail.getEmail(), newEmployeeDetail.getEmail());
		Assert.assertEquals(
			existingEmployeeDetail.getPhoneNumber(),
			newEmployeeDetail.getPhoneNumber());
		Assert.assertEquals(
			existingEmployeeDetail.getAddressLine1(),
			newEmployeeDetail.getAddressLine1());
		Assert.assertEquals(
			existingEmployeeDetail.getAddressLine2(),
			newEmployeeDetail.getAddressLine2());
		Assert.assertEquals(
			existingEmployeeDetail.getCity(), newEmployeeDetail.getCity());
		Assert.assertEquals(
			existingEmployeeDetail.getZipCode(),
			newEmployeeDetail.getZipCode());
		Assert.assertEquals(
			existingEmployeeDetail.getDesignation(),
			newEmployeeDetail.getDesignation());
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		EmployeeDetail existingEmployeeDetail = _persistence.findByPrimaryKey(
			newEmployeeDetail.getPrimaryKey());

		Assert.assertEquals(existingEmployeeDetail, newEmployeeDetail);
	}

	@Test(expected = NoSuchEmployeeDetailException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmployeeDetail> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"IgnekIntranet_EmployeeDetail", "uuid", true, "employeeId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "firstName", true,
			"lastName", true, "email", true, "phoneNumber", true,
			"addressLine1", true, "addressLine2", true, "city", true, "zipCode",
			true, "designation", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		EmployeeDetail existingEmployeeDetail = _persistence.fetchByPrimaryKey(
			newEmployeeDetail.getPrimaryKey());

		Assert.assertEquals(existingEmployeeDetail, newEmployeeDetail);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeDetail missingEmployeeDetail = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingEmployeeDetail);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmployeeDetail newEmployeeDetail1 = addEmployeeDetail();
		EmployeeDetail newEmployeeDetail2 = addEmployeeDetail();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeDetail1.getPrimaryKey());
		primaryKeys.add(newEmployeeDetail2.getPrimaryKey());

		Map<Serializable, EmployeeDetail> employeeDetails =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, employeeDetails.size());
		Assert.assertEquals(
			newEmployeeDetail1,
			employeeDetails.get(newEmployeeDetail1.getPrimaryKey()));
		Assert.assertEquals(
			newEmployeeDetail2,
			employeeDetails.get(newEmployeeDetail2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmployeeDetail> employeeDetails =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeDetails.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeDetail.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmployeeDetail> employeeDetails =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeDetails.size());
		Assert.assertEquals(
			newEmployeeDetail,
			employeeDetails.get(newEmployeeDetail.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmployeeDetail> employeeDetails =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeDetails.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeDetail.getPrimaryKey());

		Map<Serializable, EmployeeDetail> employeeDetails =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeDetails.size());
		Assert.assertEquals(
			newEmployeeDetail,
			employeeDetails.get(newEmployeeDetail.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmployeeDetailLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EmployeeDetail>() {

				@Override
				public void performAction(EmployeeDetail employeeDetail) {
					Assert.assertNotNull(employeeDetail);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDetail.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeId", newEmployeeDetail.getEmployeeId()));

		List<EmployeeDetail> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmployeeDetail existingEmployeeDetail = result.get(0);

		Assert.assertEquals(existingEmployeeDetail, newEmployeeDetail);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDetail.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeId", RandomTestUtil.nextLong()));

		List<EmployeeDetail> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDetail.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employeeId"));

		Object newEmployeeId = newEmployeeDetail.getEmployeeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employeeId", new Object[] {newEmployeeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEmployeeId = result.get(0);

		Assert.assertEquals(existingEmployeeId, newEmployeeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDetail.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employeeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employeeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newEmployeeDetail.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		EmployeeDetail newEmployeeDetail = addEmployeeDetail();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDetail.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeId", newEmployeeDetail.getEmployeeId()));

		List<EmployeeDetail> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(EmployeeDetail employeeDetail) {
		Assert.assertEquals(
			employeeDetail.getUuid(),
			ReflectionTestUtil.invoke(
				employeeDetail, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(employeeDetail.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				employeeDetail, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected EmployeeDetail addEmployeeDetail() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeDetail employeeDetail = _persistence.create(pk);

		employeeDetail.setUuid(RandomTestUtil.randomString());

		employeeDetail.setGroupId(RandomTestUtil.nextLong());

		employeeDetail.setCompanyId(RandomTestUtil.nextLong());

		employeeDetail.setUserId(RandomTestUtil.nextLong());

		employeeDetail.setUserName(RandomTestUtil.randomString());

		employeeDetail.setCreateDate(RandomTestUtil.nextDate());

		employeeDetail.setModifiedDate(RandomTestUtil.nextDate());

		employeeDetail.setFirstName(RandomTestUtil.randomString());

		employeeDetail.setLastName(RandomTestUtil.randomString());

		employeeDetail.setEmail(RandomTestUtil.randomString());

		employeeDetail.setPhoneNumber(RandomTestUtil.nextLong());

		employeeDetail.setAddressLine1(RandomTestUtil.randomString());

		employeeDetail.setAddressLine2(RandomTestUtil.randomString());

		employeeDetail.setCity(RandomTestUtil.randomString());

		employeeDetail.setZipCode(RandomTestUtil.nextLong());

		employeeDetail.setDesignation(RandomTestUtil.randomString());

		_employeeDetails.add(_persistence.update(employeeDetail));

		return employeeDetail;
	}

	private List<EmployeeDetail> _employeeDetails =
		new ArrayList<EmployeeDetail>();
	private EmployeeDetailPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}