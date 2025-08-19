<@liferay_aui.fieldset cssClass="search-bar">
	<@liferay_aui.input
		cssClass="search-bar-empty-search-input p-0"
		name="emptySearchEnabled"
		type="hidden"
		value=searchBarPortletDisplayContext.isEmptySearchEnabled()
	/>

	<div class="w-75 input-group ${searchBarPortletDisplayContext.isLetTheUserChooseTheSearchScope()?then("search-bar-scope","search-bar-simple")}">
		<#if searchBarPortletDisplayContext.isLetTheUserChooseTheSearchScope()>
			<@liferay_aui.select
				cssClass="search-bar-scope-select"
				disabled=true
				label=""
				name=htmlUtil.escape(searchBarPortletDisplayContext.getScopeParameterName())
				title="scope"
				useNamespace=false
				wrapperCssClass="input-group-item input-group-item-shrink input-group-prepend search-bar-search-select-wrapper"
			>
				<@liferay_aui.option
					label="this-site"
					selected=searchBarPortletDisplayContext.isSelectedCurrentSiteSearchScope()
					value=searchBarPortletDisplayContext.getCurrentSiteSearchScopeParameterString()
				/>

				<#if searchBarPortletDisplayContext.isAvailableEverythingSearchScope()>
					<@liferay_aui.option
						label="everything"
						selected=searchBarPortletDisplayContext.isSelectedEverythingSearchScope()
						value=searchBarPortletDisplayContext.getEverythingSearchScopeParameterString()
					/>
				</#if>
			</@>

			<#assign data = {
				"test-id": "SearchInput"
			} />

			<@liferay_aui.input
				autoFocus=true
				autocomplete="off"
				cssClass="input-group-item search-bar-keywords-input p-0"
				data=data
				disabled=true
				label=""
				name=htmlUtil.escape(searchBarPortletDisplayContext.getKeywordsParameterName())
				placeholder=" "
				title=languageUtil.get(locale, "liferay")
				type="text"
				useNamespace=false
				value=htmlUtil.escape(searchBarPortletDisplayContext.getKeywords())
				wrapperCssClass="input-group-item input-group-append search-bar-keywords-input-wrapper"
			/>
		<#else>
			<div class="input-group-item search-bar-keywords-input-wrapper p-0">
				<input
					id="fontDesign"
					autocomplete="off" 
					class="form-control input-group-inset search-bar-keywords-input bg-white border-top-0 border-right-0 border-left-0 border-secondary rounded-0 p-0"
					data-qa-id="seaarchInput"
					disabled=true
					id="${namespace + stringUtil.randomId()}"
					name="${htmlUtil.escape(searchBarPortletDisplayContext.getKeywordsParameterName())}"
					placeholder="${languageUtil.get(locale, "liferay")}"
					title="${languageUtil.get(locale, "Search")}"
					type="text"
					value="${htmlUtil.escape(searchBarPortletDisplayContext.getKeywords())}"
				/>

				<@liferay_aui.input
					name=htmlUtil.escape(searchBarPortletDisplayContext.getScopeParameterName())
					type="hidden"
					value=searchBarPortletDisplayContext.getScopeParameterValue()
				/>
			</div>
			
			<div class="input-group-item input-group-item-shrink input-group-prepend">
				<@clay["button"]
					aria\-label="${languageUtil.get(locale, 'Liferay')}"
					cssClass="btn btn-monospaced btn-light search-bar-submit-button rounded-circle"
					disabled=true
					displayType=""
					icon="search"
					type="submit"
				/>
			</div>
		</#if>
	</div>
</@>
	
	<style>
		#fontDesign{
			font-family: 'Poppins';
		  font-weight:400;
			font-size:24px;
			color:#333333;
			letter-spacing:-2%;
		}
	</style>