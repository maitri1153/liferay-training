/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.service.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.employee.service.exception.NoSuchEmployeeDetailException;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.model.EmployeeDetailTable;
import com.employee.service.model.impl.EmployeeDetailImpl;
import com.employee.service.model.impl.EmployeeDetailModelImpl;
import com.employee.service.service.persistence.EmployeeDetailPersistence;
import com.employee.service.service.persistence.EmployeeDetailUtil;
import com.employee.service.service.persistence.impl.constants.IgnekIntranetPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

/**
 * The persistence implementation for the employee detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDetailPersistence.class)
public class EmployeeDetailPersistenceImpl
	extends BasePersistenceImpl<EmployeeDetail>
	implements EmployeeDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDetailUtil</code> to access the employee detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmployeeDetail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<EmployeeDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<EmployeeDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<EmployeeDetail> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetail employeeDetail : list) {
					if (!uuid.equals(employeeDetail.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<EmployeeDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUuid_First(
			String uuid, OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {

		EmployeeDetail employeeDetail = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDetailException(sb.toString());
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDetail> orderByComparator) {

		List<EmployeeDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUuid_Last(
			String uuid, OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {

		EmployeeDetail employeeDetail = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDetailException(sb.toString());
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmployeeDetail[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {

		uuid = Objects.toString(uuid, "");

		EmployeeDetail employeeDetail = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetail[] array = new EmployeeDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeDetail, uuid, orderByComparator, true);

			array[1] = employeeDetail;

			array[2] = getByUuid_PrevAndNext(
				session, employeeDetail, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDetail getByUuid_PrevAndNext(
		Session session, EmployeeDetail employeeDetail, String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeDetail employeeDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDetail);
		}
	}

	/**
	 * Returns the number of employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"employeeDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeDetail.uuid IS NULL OR employeeDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException {

		EmployeeDetail employeeDetail = fetchByUUID_G(uuid, groupId);

		if (employeeDetail == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeDetailException(sb.toString());
		}

		return employeeDetail;
	}

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof EmployeeDetail) {
			EmployeeDetail employeeDetail = (EmployeeDetail)result;

			if (!Objects.equals(uuid, employeeDetail.getUuid()) ||
				(groupId != employeeDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<EmployeeDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeDetail employeeDetail = list.get(0);

					result = employeeDetail;

					cacheResult(employeeDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmployeeDetail)result;
		}
	}

	/**
	 * Removes the employee detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee detail that was removed
	 */
	@Override
	public EmployeeDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException {

		EmployeeDetail employeeDetail = findByUUID_G(uuid, groupId);

		return remove(employeeDetail);
	}

	/**
	 * Returns the number of employee details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		EmployeeDetail employeeDetail = fetchByUUID_G(uuid, groupId);

		if (employeeDetail == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"employeeDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeDetail.uuid IS NULL OR employeeDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<EmployeeDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<EmployeeDetail> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetail employeeDetail : list) {
					if (!uuid.equals(employeeDetail.getUuid()) ||
						(companyId != employeeDetail.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<EmployeeDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EmployeeDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {

		EmployeeDetail employeeDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDetailException(sb.toString());
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		List<EmployeeDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmployeeDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {

		EmployeeDetail employeeDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDetailException(sb.toString());
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmployeeDetail[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {

		uuid = Objects.toString(uuid, "");

		EmployeeDetail employeeDetail = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetail[] array = new EmployeeDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeDetail, uuid, companyId, orderByComparator,
				true);

			array[1] = employeeDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeDetail, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDetail getByUuid_C_PrevAndNext(
		Session session, EmployeeDetail employeeDetail, String uuid,
		long companyId, OrderByComparator<EmployeeDetail> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeDetail employeeDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeDetail);
		}
	}

	/**
	 * Returns the number of employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"employeeDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeDetail.uuid IS NULL OR employeeDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeDetail.companyId = ?";

	public EmployeeDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeDetail.class);

		setModelImplClass(EmployeeDetailImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeDetailTable.INSTANCE);
	}

	/**
	 * Caches the employee detail in the entity cache if it is enabled.
	 *
	 * @param employeeDetail the employee detail
	 */
	@Override
	public void cacheResult(EmployeeDetail employeeDetail) {
		entityCache.putResult(
			EmployeeDetailImpl.class, employeeDetail.getPrimaryKey(),
			employeeDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeDetail.getUuid(), employeeDetail.getGroupId()
			},
			employeeDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	@Override
	public void cacheResult(List<EmployeeDetail> employeeDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeDetails.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeDetail employeeDetail : employeeDetails) {
			if (entityCache.getResult(
					EmployeeDetailImpl.class, employeeDetail.getPrimaryKey()) ==
						null) {

				cacheResult(employeeDetail);
			}
		}
	}

	/**
	 * Clears the cache for all employee details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDetailImpl.class);

		finderCache.clearCache(EmployeeDetailImpl.class);
	}

	/**
	 * Clears the cache for the employee detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDetail employeeDetail) {
		entityCache.removeResult(EmployeeDetailImpl.class, employeeDetail);
	}

	@Override
	public void clearCache(List<EmployeeDetail> employeeDetails) {
		for (EmployeeDetail employeeDetail : employeeDetails) {
			entityCache.removeResult(EmployeeDetailImpl.class, employeeDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeDetailModelImpl employeeDetailModelImpl) {

		Object[] args = new Object[] {
			employeeDetailModelImpl.getUuid(),
			employeeDetailModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeDetailModelImpl);
	}

	/**
	 * Creates a new employee detail with the primary key. Does not add the employee detail to the database.
	 *
	 * @param employeeId the primary key for the new employee detail
	 * @return the new employee detail
	 */
	@Override
	public EmployeeDetail create(long employeeId) {
		EmployeeDetail employeeDetail = new EmployeeDetailImpl();

		employeeDetail.setNew(true);
		employeeDetail.setPrimaryKey(employeeId);

		String uuid = PortalUUIDUtil.generate();

		employeeDetail.setUuid(uuid);

		employeeDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeDetail;
	}

	/**
	 * Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail that was removed
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail remove(long employeeId)
		throws NoSuchEmployeeDetailException {

		return remove((Serializable)employeeId);
	}

	/**
	 * Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee detail
	 * @return the employee detail that was removed
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail remove(Serializable primaryKey)
		throws NoSuchEmployeeDetailException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDetail employeeDetail = (EmployeeDetail)session.get(
				EmployeeDetailImpl.class, primaryKey);

			if (employeeDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDetail);
		}
		catch (NoSuchEmployeeDetailException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmployeeDetail removeImpl(EmployeeDetail employeeDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDetail)) {
				employeeDetail = (EmployeeDetail)session.get(
					EmployeeDetailImpl.class,
					employeeDetail.getPrimaryKeyObj());
			}

			if (employeeDetail != null) {
				session.delete(employeeDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDetail != null) {
			clearCache(employeeDetail);
		}

		return employeeDetail;
	}

	@Override
	public EmployeeDetail updateImpl(EmployeeDetail employeeDetail) {
		boolean isNew = employeeDetail.isNew();

		if (!(employeeDetail instanceof EmployeeDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDetail implementation " +
					employeeDetail.getClass());
		}

		EmployeeDetailModelImpl employeeDetailModelImpl =
			(EmployeeDetailModelImpl)employeeDetail;

		if (Validator.isNull(employeeDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (employeeDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDetail.setCreateDate(date);
			}
			else {
				employeeDetail.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!employeeDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDetail.setModifiedDate(date);
			}
			else {
				employeeDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDetail);
			}
			else {
				employeeDetail = (EmployeeDetail)session.merge(employeeDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDetailImpl.class, employeeDetailModelImpl, false, true);

		cacheUniqueFindersCache(employeeDetailModelImpl);

		if (isNew) {
			employeeDetail.setNew(false);
		}

		employeeDetail.resetOriginalValues();

		return employeeDetail;
	}

	/**
	 * Returns the employee detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee detail
	 * @return the employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDetailException {

		EmployeeDetail employeeDetail = fetchByPrimaryKey(primaryKey);

		if (employeeDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDetail;
	}

	/**
	 * Returns the employee detail with the primary key or throws a <code>NoSuchEmployeeDetailException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeDetailException {

		return findByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns the employee detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee detail
	 * @return the employee detail, or <code>null</code> if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail fetchByPrimaryKey(long employeeId) {
		return fetchByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns all the employee details.
	 *
	 * @return the employee details
	 */
	@Override
	public List<EmployeeDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmployeeDetail> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EmployeeDetail> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EmployeeDetail> findAll(
		int start, int end, OrderByComparator<EmployeeDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EmployeeDetail> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDETAIL;

				sql = sql.concat(EmployeeDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employee details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDetail employeeDetail : findAll()) {
			remove(employeeDetail);
		}
	}

	/**
	 * Returns the number of employee details.
	 *
	 * @return the number of employee details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEDETAIL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "employeeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee detail persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		EmployeeDetailUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeDetailUtil.setPersistence(null);

		entityCache.removeCache(EmployeeDetailImpl.class.getName());
	}

	@Override
	@Reference(
		target = IgnekIntranetPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = IgnekIntranetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = IgnekIntranetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMPLOYEEDETAIL =
		"SELECT employeeDetail FROM EmployeeDetail employeeDetail";

	private static final String _SQL_SELECT_EMPLOYEEDETAIL_WHERE =
		"SELECT employeeDetail FROM EmployeeDetail employeeDetail WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDETAIL =
		"SELECT COUNT(employeeDetail) FROM EmployeeDetail employeeDetail";

	private static final String _SQL_COUNT_EMPLOYEEDETAIL_WHERE =
		"SELECT COUNT(employeeDetail) FROM EmployeeDetail employeeDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}