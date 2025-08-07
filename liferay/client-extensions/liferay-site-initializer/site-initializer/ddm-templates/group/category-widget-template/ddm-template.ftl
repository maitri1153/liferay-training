<#assign resetURL = renderResponse.createRenderURL() />
${resetURL.setParameter("resetCur", "true")}
${resetURL.setParameter("categoryId", "")}

<#assign hasCategories = false />

<#if entries?has_content>
	<@clay.row id="filterDiv">
		<#list entries as entry>
			<#assign categories = entry.getCategories() />

			<#if categories?has_content>
				<#assign hasCategories = true />

				<@clay.col id="filterDiv">
					<@displayCategories categories = categories />
				</@clay.col>
			</#if>
		</#list>

		<#if !hasCategories>
			${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}

			<div class="alert alert-info">
				<@liferay_ui.message key="there-are-no-categories" />
			</div>
		</#if>
	</@clay.row>
</#if>

<#macro displayCategories
	categories
>
	<#if categories?has_content>
		<#assign categoryIdParam = renderRequest.getParameter("categoryId")!"0" />
		<p id="contentHeight">
			<a id="hoverClass" href="${resetURL}" class="${(categoryIdParam == '0')?then('activeCategory', 'categories')}">${languageUtil.get(locale,"all")}</a>
			<#list categories as category>
					<#assign categoryURL = renderResponse.createRenderURL() />
					${categoryURL.setParameter("resetCur", "true")}
					${categoryURL.setParameter("categoryId", category.getCategoryId()?string)}

					 <#assign isActive = (category.getCategoryId()?string == categoryIdParam) />
 					 <a id="hoverClass" href="${categoryURL}" class="${isActive?then('activeCategory', 'categories')}">${category.getName()}</a>

					<#if serviceLocator??>
						<#assign
							assetCategoryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")
							childCategories = assetCategoryService.getChildCategories(category.getCategoryId()) />
						<@displayCategories categories = childCategories />
					</#if>
			</#list>
			</p>
	</#if>
</#macro>

<style>
	
.categories{
	  font-family:'Poppins';
	  border:1px #262626 solid;
		border-radius: 50px;
		padding:6px;
		color:#262626;
		text-decoration: none;
		padding-left:20px;
		padding-right:20px;
	  margin-top:20px;
	  margin-right:20px;
	}
	
	.activeCategory{
	  border:none;
		border-radius: 50px;
		padding:10px;
		color:white;
		padding-left:20px;
		padding-right:20px;
		background-color:#00979E;
	  margin-top:20px;
		text-decoration: none;
		margin-right:20px;
	}
	#contentHeight{
		line-height:40px;
	}
	#hoverClass:hover{
	  border:none;
		border-radius: 50px;
		color:white;
		background-color:#00979E;
		text-decoration:none;
	}
	#filterDiv{
	 margin:0px;
	 padding:0px;
	}
</style>