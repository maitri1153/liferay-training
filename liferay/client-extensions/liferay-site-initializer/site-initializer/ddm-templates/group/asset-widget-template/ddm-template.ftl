<#if entries?has_content>
    <div>
			<div class="row">
        <#list entries as curEntry>
             <div class="col-4">
				<div>
                <#assign
                    assetRenderer = curEntry.getAssetRenderer()
                    journalArticle = assetRenderer.getAssetObject()
                 />
                <@liferay_journal["journal-article"]
                    articleId=journalArticle.getArticleId()
                    ddmTemplateKey=journalArticle.getDDMTemplateKey()
                    groupId=journalArticle.getGroupId()
                />
            </div>
			</div>
        </#list>
    </div>
	</div>
</#if>