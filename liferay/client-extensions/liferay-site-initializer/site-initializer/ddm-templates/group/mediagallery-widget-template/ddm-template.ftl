<div>
	<p id="mediaText">Media</p>
<#if entries?has_content>
	<div class="row">
		<#list entries as entry>
			  <div class="col-4">
					<img alt="${htmlUtil.escapeAttribute(entry.getDescription())}" class="mediaImage" src="${dlUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "")}" />
		    </div>
		</#list>
	</div>
	<button type="button" id="viewMoreBtn">View More</button>
</#if>
</div>

<@liferay_aui.script use="aui base">	
$(function(){
    $(".mediaImage:hidden").slice(0, 3).show(); 
    $("#viewMoreBtn").click(function(e){ 
        e.preventDefault();
        $(".mediaImage:hidden").slice(0, 3).show(); 
        if($(".mediaImage:hidden").length == 0){ 
           $("#viewMoreBtn").hide(); 
        }
    });
});
</@liferay_aui.script>

<style>
	img{
	 
	}
	.mediaImage{
		 border-radius:15px;
	   height: 290px;
	   width:348px;
		 margin-right:20px;
		 margin-bottom:10px;
		 display:none;
	}
	#viewMoreBtn{
		font-family: Poppins;
	  border:1px blue solid;
		border-radius:7px;
		padding:6px;
		padding-left:20px;
		padding-right:20px;
		color:blue;
		background-color:white;
		float:right;
		margin-top:20px;
		margin-bottom:20px;
	}
	
	#mediaText{
		font-family: Poppins;
    font-weight: 500;
    font-style: Medium;
    font-size: 22px;
    line-height: 100%;
	}
</style>