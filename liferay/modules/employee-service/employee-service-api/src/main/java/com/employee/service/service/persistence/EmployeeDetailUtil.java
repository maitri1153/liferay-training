/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.service.persistence;

import com.employee.service.model.EmployeeDetail;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee detail service. This utility wraps <code>com.employee.service.service.persistence.impl.EmployeeDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailPersistence
 * @generated
 */
public class EmployeeDetailUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeeDetail employeeDetail) {
		getPersistence().clearCache(employeeDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmployeeDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDetail update(EmployeeDetail employeeDetail) {
		return getPersistence().update(employeeDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDetail update(
		EmployeeDetail employeeDetail, ServiceContext serviceContext) {

		return getPersistence().update(employeeDetail, serviceContext);
	}

	/**
	 * Returns all the employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee details
	 */
	public static List<EmployeeDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @return the range of matching employee details
	 */
	public static List<EmployeeDetail> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee details
	 */
	public static List<EmployeeDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee details
	 */
	public static List<EmployeeDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public static EmployeeDetail findByUuid_First(
			String uuid, OrderByComparator<EmployeeDetail> orderByComparator)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public static EmployeeDetail fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public static EmployeeDetail findByUuid_Last(
			String uuid, OrderByComparator<EmployeeDetail> orderByComparator)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public static EmployeeDetail fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	public static EmployeeDetail[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee details
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public static EmployeeDetail findByUUID_G(String uuid, long groupId)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public static EmployeeDetail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public static EmployeeDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee detail that was removed
	 */
	public static EmployeeDetail removeByUUID_G(String uuid, long groupId)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee details
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee details
	 */
	public static List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @return the range of matching employee details
	 */
	public static List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee details
	 */
	public static List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee details
	 */
	public static List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public static EmployeeDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public static EmployeeDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public static EmployeeDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public static EmployeeDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	public static EmployeeDetail[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee details
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the employee detail in the entity cache if it is enabled.
	 *
	 * @param employeeDetail the employee detail
	 */
	public static void cacheResult(EmployeeDetail employeeDetail) {
		getPersistence().cacheResult(employeeDetail);
	}

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	public static void cacheResult(List<EmployeeDetail> employeeDetails) {
		getPersistence().cacheResult(employeeDetails);
	}

	/**
	 * Creates a new employee detail with the primary key. Does not add the employee detail to the database.
	 *
	 * @param employeeId the primary key for the new employee detail
	 * @return the new employee detail
	 */
	public static EmployeeDetail create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	 * Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail that was removed
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	public static EmployeeDetail remove(long employeeId)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().remove(employeeId);
	}

	public static EmployeeDetail updateImpl(EmployeeDetail employeeDetail) {
		return getPersistence().updateImpl(employeeDetail);
	}

	/**
	 * Returns the employee detail with the primary key or throws a <code>NoSuchEmployeeDetailException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	public static EmployeeDetail findByPrimaryKey(long employeeId)
		throws com.employee.service.exception.NoSuchEmployeeDetailException {

		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	 * Returns the employee detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail, or <code>null</code> if a employee detail with the primary key could not be found
	 */
	public static EmployeeDetail fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	 * Returns all the employee details.
	 *
	 * @return the employee details
	 */
	public static List<EmployeeDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @return the range of employee details
	 */
	public static List<EmployeeDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee details
	 */
	public static List<EmployeeDetail> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee details
	 */
	public static List<EmployeeDetail> findAll(
		int start, int end, OrderByComparator<EmployeeDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee details.
	 *
	 * @return the number of employee details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDetailPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeeDetailPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeeDetailPersistence _persistence;

}