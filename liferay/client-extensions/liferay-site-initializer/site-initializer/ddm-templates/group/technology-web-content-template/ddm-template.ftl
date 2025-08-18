	<div>
	   <div class="card g-0 shadow techCards">
		   <div class="row m-0">
			   <div class="col-1 p-0">
				    <#if (TechnologyIcon.getData())?? && TechnologyIcon.getData() != "">
	            <img alt="${TechnologyIcon.getAttribute("alt")}" data-fileentryid="${TechnologyIcon.getAttribute("fileEntryId")}" class="techImage" src="${TechnologyIcon.getData()}" />
            </#if>
				 </div>
         <div class="col-9 techHeading">
				   <#if (TechnologyTitle.getData())??>
	            ${TechnologyTitle.getData()}
           </#if>
				 </div>
				 <div class="techDiscription">
				 		<#if (TechnologyDescription.getData())??>
	           ${TechnologyDescription.getData()}
            </#if>
				 </div>
       </div>
			 <div class="btnDiv">
			    <a class="techButton" href="${friendlyURL}">Learn More </a>
			 </div>
	   </div>
	</div>

<style>
.techCards{
  border: 1px solid lightgrey;
  border-radius: 15px;
	height: 290px;
	width: 348px;
	font-family: 'Poppins';
}

.techImage{
  height:40px;
  width:35px;
	padding-top:15px;
	padding-left:10px;
	display:block;
}

.techHeading{
  font-size:16px;
	padding-left:30px;
	padding-top:20px;
	font-weight:600;
	color:#262626;
}

.techDiscription{
   width:100%;
	 padding-left:60px;
	 padding-right:40px;
	 font-size:16px;
	 font-weight:400;
	 margin-top:10px;
	 margin-bottom:10px;
	 color:#262626D9;
	 line-height:21px;
 }
 
.btnDiv{
	margin-left:60px; 
	text-decoration: none;
	margin-bottom:10px;
	margin-top:10px;
	position:absolute;
	bottom:10px;
}

.techButton{
    font-family:'Poppins';
    background-color:#00979E;
		padding:10px;
		border-radius:5px;
		color:white;
		font-size:14px;
	  font-weight:500;
		padding-left:20px;
		padding-right:20px;
}

.techButton:hover{
		color:white;
}

</style>