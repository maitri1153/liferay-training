<#if entries?has_content>
	<div>
		<div class="row">
			<#assign journalArticleLocalService =
        serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
       <#list entries as entry>
				 <div class="col-4">
           <#assign article =  journalArticleLocalService.getLatestArticle(entry.getClassPK()) />
           <@liferay_journal["journal-article"] 
			        articleId="${article.getArticleId()}"
              groupId=article.getGroupId() 
			        ddmTemplateKey="${article.getDDMTemplateKey()}"/>
					</div>
       </#list>
		</div>
	</div>
	<#else>
	  <div class="m-5">
			<h1 class="pt-4 text-secondary">
				 Sorry!! there is no content to display
			</h1>
	</div>
</#if>