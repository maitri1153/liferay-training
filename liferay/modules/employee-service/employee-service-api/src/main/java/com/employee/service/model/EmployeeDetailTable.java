/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;IgnekIntranet_EmployeeDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetail
 * @generated
 */
public class EmployeeDetailTable extends BaseTable<EmployeeDetailTable> {

	public static final EmployeeDetailTable INSTANCE =
		new EmployeeDetailTable();

	public final Column<EmployeeDetailTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeDetailTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, Long> phoneNumber = createColumn(
		"phoneNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> addressLine1 =
		createColumn(
			"addressLine1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> addressLine2 =
		createColumn(
			"addressLine2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, Long> zipCode = createColumn(
		"zipCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailTable, String> designation = createColumn(
		"designation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EmployeeDetailTable() {
		super("IgnekIntranet_EmployeeDetail", EmployeeDetailTable::new);
	}

}