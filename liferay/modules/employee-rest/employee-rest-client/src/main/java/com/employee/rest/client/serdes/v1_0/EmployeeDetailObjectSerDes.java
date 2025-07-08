package com.employee.rest.client.serdes.v1_0;

import com.employee.rest.client.dto.v1_0.EmployeeDetailObject;
import com.employee.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author ignek
 * @generated
 */
@Generated("")
public class EmployeeDetailObjectSerDes {

	public static EmployeeDetailObject toDTO(String json) {
		EmployeeDetailObjectJSONParser employeeDetailObjectJSONParser =
			new EmployeeDetailObjectJSONParser();

		return employeeDetailObjectJSONParser.parseToDTO(json);
	}

	public static EmployeeDetailObject[] toDTOs(String json) {
		EmployeeDetailObjectJSONParser employeeDetailObjectJSONParser =
			new EmployeeDetailObjectJSONParser();

		return employeeDetailObjectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(EmployeeDetailObject employeeDetailObject) {
		if (employeeDetailObject == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (employeeDetailObject.getAddressLine1() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"addressLine1\": ");

			sb.append("\"");

			sb.append(_escape(employeeDetailObject.getAddressLine1()));

			sb.append("\"");
		}

		if (employeeDetailObject.getAddressLine2() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"addressLine2\": ");

			sb.append("\"");

			sb.append(_escape(employeeDetailObject.getAddressLine2()));

			sb.append("\"");
		}

		if (employeeDetailObject.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(employeeDetailObject.getCity()));

			sb.append("\"");
		}

		if (employeeDetailObject.getDesignation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"designation\": ");

			sb.append("\"");

			sb.append(_escape(employeeDetailObject.getDesignation()));

			sb.append("\"");
		}

		if (employeeDetailObject.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(employeeDetailObject.getEmail()));

			sb.append("\"");
		}

		if (employeeDetailObject.getEmployeeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeId\": ");

			sb.append(employeeDetailObject.getEmployeeId());
		}

		if (employeeDetailObject.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(employeeDetailObject.getFirstName()));

			sb.append("\"");
		}

		if (employeeDetailObject.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(employeeDetailObject.getLastName()));

			sb.append("\"");
		}

		if (employeeDetailObject.getPhoneNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phoneNumber\": ");

			sb.append(employeeDetailObject.getPhoneNumber());
		}

		if (employeeDetailObject.getZipCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"zipCode\": ");

			sb.append(employeeDetailObject.getZipCode());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeDetailObjectJSONParser employeeDetailObjectJSONParser =
			new EmployeeDetailObjectJSONParser();

		return employeeDetailObjectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		EmployeeDetailObject employeeDetailObject) {

		if (employeeDetailObject == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (employeeDetailObject.getAddressLine1() == null) {
			map.put("addressLine1", null);
		}
		else {
			map.put(
				"addressLine1",
				String.valueOf(employeeDetailObject.getAddressLine1()));
		}

		if (employeeDetailObject.getAddressLine2() == null) {
			map.put("addressLine2", null);
		}
		else {
			map.put(
				"addressLine2",
				String.valueOf(employeeDetailObject.getAddressLine2()));
		}

		if (employeeDetailObject.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(employeeDetailObject.getCity()));
		}

		if (employeeDetailObject.getDesignation() == null) {
			map.put("designation", null);
		}
		else {
			map.put(
				"designation",
				String.valueOf(employeeDetailObject.getDesignation()));
		}

		if (employeeDetailObject.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(employeeDetailObject.getEmail()));
		}

		if (employeeDetailObject.getEmployeeId() == null) {
			map.put("employeeId", null);
		}
		else {
			map.put(
				"employeeId",
				String.valueOf(employeeDetailObject.getEmployeeId()));
		}

		if (employeeDetailObject.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put(
				"firstName",
				String.valueOf(employeeDetailObject.getFirstName()));
		}

		if (employeeDetailObject.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put(
				"lastName", String.valueOf(employeeDetailObject.getLastName()));
		}

		if (employeeDetailObject.getPhoneNumber() == null) {
			map.put("phoneNumber", null);
		}
		else {
			map.put(
				"phoneNumber",
				String.valueOf(employeeDetailObject.getPhoneNumber()));
		}

		if (employeeDetailObject.getZipCode() == null) {
			map.put("zipCode", null);
		}
		else {
			map.put(
				"zipCode", String.valueOf(employeeDetailObject.getZipCode()));
		}

		return map;
	}

	public static class EmployeeDetailObjectJSONParser
		extends BaseJSONParser<EmployeeDetailObject> {

		@Override
		protected EmployeeDetailObject createDTO() {
			return new EmployeeDetailObject();
		}

		@Override
		protected EmployeeDetailObject[] createDTOArray(int size) {
			return new EmployeeDetailObject[size];
		}

		@Override
		protected void setField(
			EmployeeDetailObject employeeDetailObject,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "addressLine1")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setAddressLine1(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "addressLine2")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setAddressLine2(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "designation")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setDesignation(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "employeeId")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setEmployeeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setFirstName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setLastName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phoneNumber")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setPhoneNumber(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "zipCode")) {
				if (jsonParserFieldValue != null) {
					employeeDetailObject.setZipCode(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}