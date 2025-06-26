/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EmployeeDetail service. Represents a row in the &quot;IgnekIntranet_EmployeeDetail&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailModel
 * @generated
 */
@ImplementationClassName("com.employee.service.model.impl.EmployeeDetailImpl")
@ProviderType
public interface EmployeeDetail extends EmployeeDetailModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.employee.service.model.impl.EmployeeDetailImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmployeeDetail, Long> EMPLOYEE_ID_ACCESSOR =
		new Accessor<EmployeeDetail, Long>() {

			@Override
			public Long get(EmployeeDetail employeeDetail) {
				return employeeDetail.getEmployeeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmployeeDetail> getTypeClass() {
				return EmployeeDetail.class;
			}

		};

}