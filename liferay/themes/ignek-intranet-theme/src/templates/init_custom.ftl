<#if show_sign_out>
	<#assign
		logout_text = languageUtil.get(locale, "Logout")
		sign_out_url = htmlUtil.escape(theme_display.getURLSignOut())
	/>
</#if>