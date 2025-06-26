/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.service.persistence;

import com.employee.service.exception.NoSuchEmployeeDetailException;
import com.employee.service.model.EmployeeDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailUtil
 * @generated
 */
@ProviderType
public interface EmployeeDetailPersistence
	extends BasePersistence<EmployeeDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDetailUtil} to access the employee detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee details
	 */
	public java.util.List<EmployeeDetail> findByUuid(String uuid);

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
	public java.util.List<EmployeeDetail> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<EmployeeDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator);

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
	public java.util.List<EmployeeDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public EmployeeDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
				orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public EmployeeDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator);

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public EmployeeDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
				orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public EmployeeDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator);

	/**
	 * Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	public EmployeeDetail[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
				orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	 * Removes all the employee details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public EmployeeDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException;

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public EmployeeDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public EmployeeDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee detail that was removed
	 */
	public EmployeeDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException;

	/**
	 * Returns the number of employee details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee details
	 */
	public java.util.List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator);

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
	public java.util.List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public EmployeeDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
				orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public EmployeeDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator);

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	public EmployeeDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
				orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	public EmployeeDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator);

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
	public EmployeeDetail[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
				orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	 * Removes all the employee details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee detail in the entity cache if it is enabled.
	 *
	 * @param employeeDetail the employee detail
	 */
	public void cacheResult(EmployeeDetail employeeDetail);

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	public void cacheResult(java.util.List<EmployeeDetail> employeeDetails);

	/**
	 * Creates a new employee detail with the primary key. Does not add the employee detail to the database.
	 *
	 * @param employeeId the primary key for the new employee detail
	 * @return the new employee detail
	 */
	public EmployeeDetail create(long employeeId);

	/**
	 * Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail that was removed
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	public EmployeeDetail remove(long employeeId)
		throws NoSuchEmployeeDetailException;

	public EmployeeDetail updateImpl(EmployeeDetail employeeDetail);

	/**
	 * Returns the employee detail with the primary key or throws a <code>NoSuchEmployeeDetailException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	public EmployeeDetail findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeDetailException;

	/**
	 * Returns the employee detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail, or <code>null</code> if a employee detail with the primary key could not be found
	 */
	public EmployeeDetail fetchByPrimaryKey(long employeeId);

	/**
	 * Returns all the employee details.
	 *
	 * @return the employee details
	 */
	public java.util.List<EmployeeDetail> findAll();

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
	public java.util.List<EmployeeDetail> findAll(int start, int end);

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
	public java.util.List<EmployeeDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator);

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
	public java.util.List<EmployeeDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee details.
	 *
	 * @return the number of employee details
	 */
	public int countAll();

}