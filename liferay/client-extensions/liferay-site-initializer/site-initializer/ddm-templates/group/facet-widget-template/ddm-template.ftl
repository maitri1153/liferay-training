<div class="d-flex">
	<@clay.button 
				cssClass="facet-term categoryFacetButton ml-0 ${assetCategoriesSearchFacetDisplayContext.isNothingSelected()?then('selectButton','categoryFacetButton')}"
				displayType="button"
				id="${namespace + 'facetAssetCategoriesClear'}"
				onClick="Liferay.Search.FacetUtil.clearSelections(event);"
			  >
				<span>${languageUtil.get(locale, "all")}</span>
			</@clay.button>

		<#if entries?has_content>
			<div class="label-container">
				<#list entries as entry>
					<@clay.button
						cssClass="facet-term ${(entry.isSelected())?then('selectButton', 'categoryFacetButton')} term-name"
						data\-term\-id="${entry.getFilterValue()}"
						disabled="false"
						displayType="button"
						onClick="Liferay.Search.FacetUtil.changeSelection(event);"
					>
						<span class="label-item label-item-expand">
							${htmlUtil.escape(entry.getBucketText())}
						</span>
					</@clay.button>
				</#list>
			</div>
		</#if>
</div>
<style>
	
	.categoryFacetButton{
	  border:1px #262626 solid;
		border-radius: 50px;
		padding:4px;
		color:#262626;
		text-decoration: none;
		padding-left:20px;
		padding-right:20px;
		margin-left:20px;
	  margin-top:20px;
		font-weight:500;
	}
	
	.categoryFacetButton:hover{
	  border:none;
		color:white;
		background-color:#00979E;
	}
	
	.selectButton{
	  border:none;
		border-radius: 50px;
		padding:4px;
		color:white;
		padding-left:20px;
		padding-right:20px;
		background-color:#00979E;
		margin-left:20px;
	  margin-top:20px;
		text-decoration: none;
		font-weight:500;
	}
	
	.selectButton:hover{
		 color:white;
	}
	
	.portlet-layout .portlet .portlet-title-text {
	  display:none;
	}
</style>