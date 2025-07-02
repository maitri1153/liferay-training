<#include "${full_templates_path}/init_custom.ftl" />

<nav aria-label="<@liferay.language key="site-pages" />" class="${nav_css_class}" id="navigation" role="navigation">
<ul role="menubar" class="p-0 list-unstyled">
		<#list nav_items as nav_item>
			<#assign
				nav_item_attr_has_popup = ""
				nav_item_css_class = ""
				nav_item_layout = nav_item.getLayout()
			/>

			<#if nav_item.isSelected()>
				<#assign
					nav_item_attr_has_popup = "aria-haspopup='true'"
					nav_item_css_class = "selected"
				/>
			</#if>

			<li id="layout_${nav_item.getLayoutId()}"  class="w-100 ${nav_item_css_class}  pageList" role="presentation">
				<a ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
				<span class="pageName">
					<@liferay_theme["layout-icon"] layout=nav_item_layout/> ${nav_item.getName()}</span></a>

				<#if nav_item.hasChildren()>
					<ul class="child-menu" role="menu">
						<#list nav_item.getChildren() as nav_child>
							<#assign nav_child_css_class = ""/>

							<#if nav_item.isSelected()>
								<#assign nav_child_css_class = "selected"/>
							</#if>

							<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
								<a href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
							</li>
							
						</#list>
					</ul>
				</#if>
				
			</li>
			
		</#list>
	</ul>
	<button class="logoutButton">
		<a class="text-dark pr-2" href="${sign_out_url}">${logout_text}
		<img src="${images_folder}/sign-out.png" class="pl-3"/></a>
	</button>
</nav>