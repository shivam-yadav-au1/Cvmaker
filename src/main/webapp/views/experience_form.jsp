<%@ include file="/resource-bundles/directives.jsp"%>

        <!-- Form container Start-->
        <div class="form-card ">

            <h2>Experience</h2>
            <!-- After adding experience in list it is shown below  -->
            
            <div class="experience-container" id="experience">
            	<div class="item">
            		 <ul>
            			<c:forEach items="${expMap}" var="itemMap">
            				<c:out value="${itemMap.key}"/> : <c:out value="${itemMap.value}"/>
            				<a href="${pageContext.request.contextPath}/formServlet?id=${itemMap.key}&action=Delete">Delete</a><br>
            				
						</c:forEach>
            		</ul> 
            	</div>
            </div>
           
           	
				
				
                <label>Company</label>
                <input id="companyname" type="text" name="company" placeholder="Company" value="${exp.company}">

                <label>Designation</label>
                <input type="text" name="designation" placeholder="Designation" value="${exp.designation}">

                <div class="date-container">
                    <label>From</label>
                    <input type="date" name="fromDate" value="${exp.fromDate}">

                    <label>To</label>
                    <input type="date" name="toDate" value="${exp.toDate}">
                </div>

                <label>Describe your roll in company</label>
                <textarea name="roll" rows="4" cols="40" value="${exp.roll}"></textarea>
                
             
                
              

                <!-- Button container start-->
                <div class="button-container">

                
            		<input class="btn btn-primary" id="experience" type="submit" name="buttonexp" value="Add More">
					<!-- <input class="btn btn-primary" type="submit" name="action" value="Next"> -->
                    

                </div> 
                <!-- Button container End-->

           
        </div>
        <!-- Form container End-->

   
