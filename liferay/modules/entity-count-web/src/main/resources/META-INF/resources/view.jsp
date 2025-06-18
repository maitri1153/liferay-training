<%@ include file="init.jsp" %>

<div class="entityCounttile">
	<img src="<%=renderRequest.getContextPath()%>/image/${category}.png" alt="categoryIcon" class="entityCountImg"/>
	<p class="entityCountText">${category}</p>
	<p class="entityCounts">${count}</p>
</div>