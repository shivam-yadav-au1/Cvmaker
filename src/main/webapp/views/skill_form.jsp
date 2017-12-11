
<%@ include file="/resource-bundles/directives.jsp"%>
<div class="form-card ">
	<h2>Skills</h2>



	<div class="skill-container">

		<label>Skill</label>

		<c:forEach var="skill" items="${skillMap}">
			<c:out value="${skill.key}" />:<c:out value="${skill.value}" />
			
				<a href="${pageContext.request.contextPath}/formServlet?id=${skill.key}&action=DeleteSkill">Delete</a><br>
			
		    </c:forEach>

		<select name="skills">

			<option value="SELECT SKILLS">SELECT SKILLS</option>
			<option value="Java">Java</option>
			<option value="Hibernate">Hibernate</option>
			<option value="Maven">Maven</option>
			<option value="JDBC">JDBC</option>
			<option value="HTML">HTML</option>
			<option value="CSS">CSS</option>
			<option value="LINUX">LINUX</option>
			<option value="ANDROID">ANDROID</option>
			<option value="PHP">PHP</option>
			<option value="PYTHON">PYTHON</option>
			<option value="JAVASCRIPT">JAVASCRIPT</option>
			<option value="ORACLE">ORACLE</option>
			<option value="SPRING">SPRING</option>
			<option value="AJAX">AJAX</option>
			<option value="REACT.JS">REACT.JS</option>
			<option value=".NET">.NET</option>
			<option value="OTHER">OTHER</option>

		</select> <label>Profeciency</label> <select name="profeciency">
			<option value="Beginner">Beginner</option>
			<option value="Intermediate">Intermediate</option>
			<option value="Expert">Expert</option>

		</select> <label>Years</label> <select name="year">
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="14">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			<option value="23">23</option>
			<option value="24">24</option>
			<option value="25">25</option>
			<option value="26">26</option>
			<option value="27">27</option>
			<option value="28">28</option>
			<option value="29">29</option>
			<option value="30">30</option>
		</select> <label>Months</label> <select name="months">
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>


		</select>
		<div class="button-container">
			<input class="btn btn-primary" id="skill" type="submit"
				name="buttonskill" value="Add More">
		</div>

	</div>

</div>


