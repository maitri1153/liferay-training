/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.employee.service.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEmployeeDetailException extends NoSuchModelException {

	public NoSuchEmployeeDetailException() {
	}

	public NoSuchEmployeeDetailException(String msg) {
		super(msg);
	}

	public NoSuchEmployeeDetailException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchEmployeeDetailException(Throwable throwable) {
		super(throwable);
	}

}