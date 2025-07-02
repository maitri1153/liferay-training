<!DOCTYPE html>
<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="d-flex flex-column flex-fill" id="wrapper">
	<header id="banner" role="banner" class="align-items-center w-100">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
			</div>
		</div>
		
		<#if !is_signed_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>			
	</header>

	<div class="pageContent">	
		<section id="content" class="d-flex">
			<div class="sideBar">
				<#assign user = themeDisplay.getUser()>
				<#assign portraitURL = user.getPortraitURL(themeDisplay)>
				<#assign roles = user.getSiteRoles()>
				
					<div class="siteNameDiv mt-2">
						<p class="siteName pl-2">${site_name}</p>
					</div>
					<div>
    					<img src="${portraitURL}" alt="User Profile Picture" class="rounded-circle mt-3 profilePicture">
    				</div>
    				<p class="userName m-0 mt-3" role="presentation">${user_name}</p>
    				
					<#if roles?has_content>
					<ul class="p-0 pt-2 list-unstyled roleName">
    					<#list roles as role>
    					  <li class="roles">
        					${role.getName()} 
        				</li>
    					</#list>
					</ul>
					</#if>	
					
					<svg class="lexicon-icon lexicon-icon-user" role="presentation"></svg>	   
		  
				 	<#if has_navigation && is_setup_complete>
						<#include "${full_templates_path}/navigation.ftl" />
		  			</#if>				
			</div>
			
			<div class="w-100 contentDiv">
				<div class="position-fixed bg-white topNavigation">
					<#include "${full_templates_path}/top_navigation.ftl" />
				</div>
				<div class="content">
					<h2 class="hide-accessible sr-only" role="heading" aria-level="1">${htmlUtil.escape(the_title)}</h2>
		
				<#if selectable>
					<@liferay_util["include"] page=content_include />
				<#else>
					${portletDisplay.recycle()}

					${portletDisplay.setTitle(the_title)}

					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
					</@>
				</#if>
				</div>
			</div>
			
		</section>
   	</div>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
<!-- endinject -->

</body>

</html>