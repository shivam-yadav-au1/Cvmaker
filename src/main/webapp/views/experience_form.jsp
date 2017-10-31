<!-- Main Container Start-->
    <div class="main-container">

        <!-- Form container Start-->
        <div class="form-card">

            <h2>Experience</h2>
            <div class="experience-container">
            	<div class="item">
            		<!-- <h1>asdohadsl;fn;l</h1>
            		<h1>asdohadsl;fn;l</h1>
            		<h1>asdohadsl;fn;l</h1> -->
            	</div>
            </div>
           
            <form class="">

                <label>Company</label>
                <input id="companyname" type="text" name="Company" placeholder="Company">

                <label>Designation</label>
                <input type="text" name="name" placeholder="Designation">

                <div class="date-container">
                    <label>From</label>
                    <input type="date" name="date">

                    <label>To</label>
                    <input type="date" name="date">
                </div>

                <label>Describe your roll in company</label>
                <textarea rows="4" columns="50"></textarea>
                
                
                <input type="hidden" name="nextFragmentName" value="skill">

                <!-- Button container start-->
                <div class="button-container">

                	<!-- <div  id="add" class="add-button">
            				<h1>+</h1>
            		</div> -->
            		<button onclick="myFunction()" class="add-button" >
            			<a href=""><h1>+</h1></a>
            		</button>

            		
					
                   <input onclick="getText()" class="btn btn-primary" type="submit" name="action" value="Next">
                    

                </div>
                <!-- Button container End-->

            </form>
        </div>
        <!-- Form container End-->

    </div>
    <!--Main Container End -->