<%@ include file="/resource-bundles/directives.jsp"%>

        <!-- Form container Start-->
        <div class="form-card ">

            <h2>Experience</h2>
            <div class="experience-container">
            	<div class="item">
            		 <ul>
            			<c:forEach items="${experienceList}" var="item">
  							${item}<br>
						</c:forEach>
            		</ul> 
            	</div>
            </div>
           
           	
				
				
                <label>Company</label>
                <input id="companyname" type="text" name="company" placeholder="Company">

                <label>Designation</label>
                <input type="text" name="designation" placeholder="Designation">

                <div class="date-container">
                    <label>From</label>
                    <input type="date" name="fromDate">

                    <label>To</label>
                    <input type="date" name="toDate">
                </div>

                <label>Describe your roll in company</label>
                <textarea name="roll" rows="4" cols="40"></textarea>
                
             
                
              

                <!-- Button container start-->
                <div class="button-container">

                
            		<input class="btn btn-primary" type="submit" name="action" value="Add More">
					<!-- <input class="btn btn-primary" type="submit" name="action" value="Next"> -->
                    

                </div> 
                <!-- Button container End-->

           
        </div>
        <!-- Form container End-->

   
