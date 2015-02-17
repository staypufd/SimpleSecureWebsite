<%@ attribute name="fontColor" required="true" %>
<%@ tag body-content="tagdependent" %>

<img height="72" width="72" src="images/image1.jpg" > <br/>

<em>
	<strong>
		<font color="${fontColor }">
			<jsp:doBody />
		</font>
	</strong>
</em>