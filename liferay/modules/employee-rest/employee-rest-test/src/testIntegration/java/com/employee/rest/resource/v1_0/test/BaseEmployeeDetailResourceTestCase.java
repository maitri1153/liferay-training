package com.employee.rest.resource.v1_0.test;

import com.employee.rest.client.dto.v1_0.EmployeeDetailObject;
import com.employee.rest.client.http.HttpInvoker;
import com.employee.rest.client.pagination.Page;
import com.employee.rest.client.pagination.Pagination;
import com.employee.rest.client.resource.v1_0.EmployeeDetailResource;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author ignek
 * @generated
 */
@Generated("")
public abstract class BaseEmployeeDetailResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_employeeDetailResource.setContextCompany(testCompany);

		EmployeeDetailResource.Builder builder =
			EmployeeDetailResource.builder();

		employeeDetailResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testDeleteEmployeeDetailById() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetEmployees() throws Exception {
		Page<EmployeeDetail> page = employeeDetailResource.getEmployees(
			Pagination.of(1, 10));

		long totalCount = page.getTotalCount();

		EmployeeDetail employeeDetail1 = testGetEmployees_addEmployeeDetail(
			randomEmployeeDetail());

		EmployeeDetail employeeDetail2 = testGetEmployees_addEmployeeDetail(
			randomEmployeeDetail());

		page = employeeDetailResource.getEmployees(Pagination.of(1, 10));

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(employeeDetail1, (List<EmployeeDetail>)page.getItems());
		assertContains(employeeDetail2, (List<EmployeeDetail>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetEmployeesWithPagination() throws Exception {
		Page<EmployeeDetail> totalPage = employeeDetailResource.getEmployees(
			null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		EmployeeDetail employeeDetail1 = testGetEmployees_addEmployeeDetail(
			randomEmployeeDetail());

		EmployeeDetail employeeDetail2 = testGetEmployees_addEmployeeDetail(
			randomEmployeeDetail());

		EmployeeDetail employeeDetail3 = testGetEmployees_addEmployeeDetail(
			randomEmployeeDetail());

		Page<EmployeeDetail> page1 = employeeDetailResource.getEmployees(
			Pagination.of(1, totalCount + 2));

		List<EmployeeDetail> employeeDetails1 =
			(List<EmployeeDetail>)page1.getItems();

		Assert.assertEquals(
			employeeDetails1.toString(), totalCount + 2,
			employeeDetails1.size());

		Page<EmployeeDetail> page2 = employeeDetailResource.getEmployees(
			Pagination.of(2, totalCount + 2));

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<EmployeeDetail> employeeDetails2 =
			(List<EmployeeDetail>)page2.getItems();

		Assert.assertEquals(
			employeeDetails2.toString(), 1, employeeDetails2.size());

		Page<EmployeeDetail> page3 = employeeDetailResource.getEmployees(
			Pagination.of(1, totalCount + 3));

		assertContains(employeeDetail1, (List<EmployeeDetail>)page3.getItems());
		assertContains(employeeDetail2, (List<EmployeeDetail>)page3.getItems());
		assertContains(employeeDetail3, (List<EmployeeDetail>)page3.getItems());
	}

	protected EmployeeDetail testGetEmployees_addEmployeeDetail(
			EmployeeDetail employeeDetail)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetEmployeeDetailById() throws Exception {
		EmployeeDetail postEmployeeDetail =
			testGetEmployeeDetail_addEmployeeDetail();

		EmployeeDetailObject postEmployeeDetailObject =
			testGetEmployeeDetailById_addEmployeeDetailObject(
				postEmployeeDetail.getId(), randomEmployeeDetailObject());

		EmployeeDetailObject getEmployeeDetailObject =
			employeeDetailResource.getEmployeeDetailById(
				postEmployeeDetail.getId());

		assertEquals(postEmployeeDetailObject, getEmployeeDetailObject);
		assertValid(getEmployeeDetailObject);
	}

	protected EmployeeDetailObject
			testGetEmployeeDetailById_addEmployeeDetailObject(
				long employeeDetailId,
				EmployeeDetailObject employeeDetailObject)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateEmployeeDetail() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(
		Object employeeDetail, List<Object> employeeDetails) {

		boolean contains = false;

		for (Object item : employeeDetails) {
			if (equals(employeeDetail, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			employeeDetails + " does not contain " + employeeDetail, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Object employeeDetail1, Object employeeDetail2) {

		Assert.assertTrue(
			employeeDetail1 + " does not equal " + employeeDetail2,
			equals(employeeDetail1, employeeDetail2));
	}

	protected void assertEquals(
		List<Object> employeeDetails1, List<Object> employeeDetails2) {

		Assert.assertEquals(employeeDetails1.size(), employeeDetails2.size());

		for (int i = 0; i < employeeDetails1.size(); i++) {
			Object employeeDetail1 = employeeDetails1.get(i);
			Object employeeDetail2 = employeeDetails2.get(i);

			assertEquals(employeeDetail1, employeeDetail2);
		}
	}

	protected void assertEquals(
		EmployeeDetailObject employeeDetailObject1,
		EmployeeDetailObject employeeDetailObject2) {

		Assert.assertTrue(
			employeeDetailObject1 + " does not equal " + employeeDetailObject2,
			equals(employeeDetailObject1, employeeDetailObject2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> employeeDetails1, List<Object> employeeDetails2) {

		Assert.assertEquals(employeeDetails1.size(), employeeDetails2.size());

		for (Object employeeDetail1 : employeeDetails1) {
			boolean contains = false;

			for (Object employeeDetail2 : employeeDetails2) {
				if (equals(employeeDetail1, employeeDetail2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				employeeDetails2 + " does not contain " + employeeDetail1,
				contains);
		}
	}

	protected void assertValid(Object employeeDetail) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> employeeDetails = page.getItems();

		int size = employeeDetails.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(EmployeeDetailObject employeeDetailObject) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalEmployeeDetailObjectAssertFieldNames()) {

			if (Objects.equals("addressLine1", additionalAssertFieldName)) {
				if (employeeDetailObject.getAddressLine1() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("addressLine2", additionalAssertFieldName)) {
				if (employeeDetailObject.getAddressLine2() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (employeeDetailObject.getCity() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("designation", additionalAssertFieldName)) {
				if (employeeDetailObject.getDesignation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (employeeDetailObject.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("employeeId", additionalAssertFieldName)) {
				if (employeeDetailObject.getEmployeeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (employeeDetailObject.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (employeeDetailObject.getLastName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phoneNumber", additionalAssertFieldName)) {
				if (employeeDetailObject.getPhoneNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("zipCode", additionalAssertFieldName)) {
				if (employeeDetailObject.getZipCode() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalEmployeeDetailObjectAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Object employeeDetail1, Object employeeDetail2) {
		if (employeeDetail1 == employeeDetail2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(
		EmployeeDetailObject employeeDetailObject1,
		EmployeeDetailObject employeeDetailObject2) {

		if (employeeDetailObject1 == employeeDetailObject2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalEmployeeDetailObjectAssertFieldNames()) {

			if (Objects.equals("addressLine1", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getAddressLine1(),
						employeeDetailObject2.getAddressLine1())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("addressLine2", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getAddressLine2(),
						employeeDetailObject2.getAddressLine2())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getCity(),
						employeeDetailObject2.getCity())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("designation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getDesignation(),
						employeeDetailObject2.getDesignation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getEmail(),
						employeeDetailObject2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("employeeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getEmployeeId(),
						employeeDetailObject2.getEmployeeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getFirstName(),
						employeeDetailObject2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getLastName(),
						employeeDetailObject2.getLastName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phoneNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getPhoneNumber(),
						employeeDetailObject2.getPhoneNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("zipCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeDetailObject1.getZipCode(),
						employeeDetailObject2.getZipCode())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_employeeDetailResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_employeeDetailResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Object employeeDetail) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected EmployeeDetailObject randomEmployeeDetailObject()
		throws Exception {

		return new EmployeeDetailObject() {
			{
				addressLine1 = RandomTestUtil.randomString();
				addressLine2 = RandomTestUtil.randomString();
				city = RandomTestUtil.randomString();
				designation = RandomTestUtil.randomString();
				email = RandomTestUtil.randomString();
				employeeId = RandomTestUtil.randomLong();
				firstName = RandomTestUtil.randomString();
				lastName = RandomTestUtil.randomString();
				phoneNumber = RandomTestUtil.randomLong();
				zipCode = RandomTestUtil.randomLong();
			}
		};
	}

	protected EmployeeDetailResource employeeDetailResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseEmployeeDetailResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.employee.rest.resource.v1_0.EmployeeDetailResource
		_employeeDetailResource;

}