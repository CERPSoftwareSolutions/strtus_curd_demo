<!doctype html>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html class="no-js" lang="">

<head>
</head>

<body>
	<!-- Breadcubs Area Start Here -->
	<div class="breadcrumbs-area">
	    <h3>Students</h3>
	    <ul>
	        <li>
	            <a href="dashboard.do">Home</a>
	        </li>
	        <li>Student Registration</li>
	    </ul>
	</div>
	<!-- Breadcubs Area End Here -->
	<!-- Notify Alert Area Start Here -->
    <div class="card height-auto notification" style="display: none;">
		<div class="card-body">
			<div class="ui-alart-box">
                <div class="dismiss-alart">
                    <div class="alert alert-success alert-dismissible fade show" style="display: none;" role="alert">
                        <span class="message"></span>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                        <span class="message"></span>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </div>
            </div>
		</div>
	</div>
	<!-- Notify Alert Area End Here -->
	<!-- Tab Area Start Here -->
    <div class="card ui-tab-card">
        <div class="card-body">
            <div class="ui-modal-box">
                <div class="modal-box">
                	<input type="text" class="activeId" style="display: none;">
        			<div class="modal fade" id="inactivemodal" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content">
                                <form class="new-added-form" id="inactiveform" novalidate>
	                                <div class="modal-header">
	                                    <h5 class="modal-title">Delete</h5>
	                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                                        <span aria-hidden="true">&times;</span>
	                                    </button>
	                                </div>
	                                <div class="modal-body">
	                                    <h4 class="font-semibold">Are you sure to delete ?</h4>
	                                    
	                                  	<div class="col-12-xxxl col-12 form-group">
				                            <label>Remarks <font color="red">*</font></label>
				                            <textarea rows="3" cols="10" name="remarks" id="remarks" class="textarea form-control" required></textarea>
				                        	<div class="invalid-feedback">
		        								Please provide the remarks.
		      								</div>
				                        </div>
	                                </div>
	                                <div class="modal-footer">
	                                    <button type="button" class="footer-btn bg-dark-low" data-dismiss="modal">Close</button>
	                                    <button type="submit" class="footer-btn bg-linkedin">Yes</button>
	                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="custom-tab">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#viewall" id="view" role="tab" aria-selected="true">View All</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#addnew" id="add" role="tab" aria-selected="false">Add New</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="viewall" role="tabpanel">
	                    <div class="table-responsive">
		                    <table class="display nowrap" id="tableid" style="width: 100%;">
		                        <thead>
		                            <tr>
		                            	<th>#</th>
	                                    <th>Actions</th>
	                                    <th>Student Name</th>
	                                    <th>Admission No.</th>
	                                    <th>Admission date</th>
	                                    <th>Gender</th>
	                                    <th>Date of Birth</th>
	                                    <th>Blood Group</th>
	                                    <th>Primary Person</th>
	                                    <th>Student Mobile</th>
	                                    <th>Student Email</th>
	                                    <th>Father's Name</th>
	                                    <th>Father's Mobile</th>
	                                    <th>Mother's Name</th>
	                                    <th>Mother's Mobile</th>
	                                    <th>Guardian's Name</th>
	                                    <th>Guardian's Mobile</th>
	                                    <th>Permanent Address</th>
	                                    <th>Present Address</th>
	                                </tr>
		                        </thead>
		                        <tbody>
		                        </tbody>
		                    </table>
		                </div>
                    </div>
                    <div class="tab-pane fade" id="addnew" role="tabpanel">
	                    <form class="new-added-form" id="formId" novalidate>
		                    <div class="row">
		                        <input type="text" class="form-control" name="studentid" id="updateid" value="" style="display: none;"/>
		                        <input type="text" class="form-control" id="hadmissionno" style="display: none;"/>
		                        
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Admission No. <font color="red">*</font></label>
		                            <input type="text" name="admissionno" id="admissionno" class="form-control" aria-describedby="aadmissionno" required>
		                            <div id="aadmissionno" class="invalid-feedback">
        								Please provide a admission no.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Admission Date <font color="red">*</font></label>
		                            <input type="text" name="admissiondate" id="admissiondate" placeholder="dd-mm-yyyy" class="form-control air-datepicker" data-position='bottom right' aria-describedby="aadmissiondate" required>
		                            <i class="far fa-calendar-alt"></i>
		                            <div id="aadmissiondate" class="invalid-feedback">
        								Please choose a admission date.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>First Name <font color="red">*</font></label>
		                            <input type="text" name="firstname" id="firstname" class="form-control" aria-describedby="astudentname" required>
		                            <div id="afirstname" class="invalid-feedback">
        								Please provide a firstname.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Last Name </label>
		                            <input type="text" name="lastname" id="lastname" class="form-control" aria-describedby="astudentname">
		                            <div id="alastname" class="invalid-feedback">
        								Please provide a lastname.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
	                                <label>Gender <font color="red">*</font></label>
	                                <select class="select2 custom-select" name="gender" id="gender" required>
	                                    <option value="">Please Select</option>
	                                    <option value="Male">Male</option>
									    <option value="Female">Female</option>
									    <option value="Others">Others</option>
	                                </select>
	                                <div id="agender" class="invalid-feedback">
        								Please choose a gender.
      								</div>
	                            </div>
	                            <div class="col-xl-3 col-lg-6 col-12 form-group">
	                                <label>Date of Birth <font color="red">*</font></label>
	                                <input type="text" name="dob" id="dob" placeholder="dd-mm-yyyy" class="form-control air-datepicker" data-position='bottom right' aria-describedby="adob" required>
	                            	<i class="far fa-calendar-alt"></i>
	                            	<div id="adob" class="invalid-feedback">
        								Please choose a date of birth.
      								</div>
	                            </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Blood Group </label>
		                            <select class="select2 custom-select" name="bloodgroup" id="bloodgroup">
		                                <option value="">Please Select</option>
		                                <option value="A+ve">A+ve</option>
										<option value="A-ve">A-ve</option>
										<option value="A1+ve">A1+ve</option>
										<option value="A1-ve">A1-ve</option>	
										<option value="A2+ve">A2+ve</option>
										<option value="A2-ve">A2-ve</option>
										<option value="B+ve">B+ve</option>
										<option value="B-ve">B-ve</option>
										<option value="B1+ve">B1+ve</option>
										<option value="B1-ve">B1-ve</option>	
										<option value="B2+ve">B2+ve</option>
										<option value="B2-ve">B2-ve</option>
										<option value="AB+ve">AB+ve</option>
										<option value="AB-ve">AB-ve</option>
										<option value="AB1+ve">AB1+ve</option>
										<option value="AB1-ve">AB1-ve</option>
										<option value="AB2+ve">AB2+ve</option>
										<option value="AB2-ve">AB2-ve</option>
										<option value="O+ve">O+ve</option>
										<option value="O-ve">O-ve</option>
										<option value="A1B+ve">A1B+ve</option>
										<option value="A1B-ve">A1B-ve</option>
										<option value="A2B+ve">A2B+ve</option>
										<option value="A2B-ve">A2B-ve</option>
		                            </select>
		                            <div class="invalid-feedback">
        								Please choose a blood group.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
	                                <label>Primary Person <font color="red">*</font></label>
	                                <select class="select2 custom-select" name="primaryperson" id="primaryperson" required>
	                                    <option value="">Please Select</option>
	                                    <option value="Father">Father</option>
									    <option value="Mother">Mother</option>
									    <option value="Guardian">Guardian</option>
	                                </select>
	                                <div id="aprimaryperson" class="invalid-feedback">
        								Please choose a primary person.
      								</div>
	                            </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Student Mobile No. </label>
		                            <input type="text" name="studentmobileno" id="studentmobileno" class="form-control" aria-describedby="astudentmobileno">
		                            <div id="astudentmobileno" class="invalid-feedback">
        								Please provide a student mobileno.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Student Email Id </label>
		                            <input type="text" name="studentemailid" id="studentemailid" class="form-control" aria-describedby="astudentemailid">
		                            <div id="astudentemailid" class="invalid-feedback">
        								Please provide a valid student emailid.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Father's Name <font color="red">*</font></label>
		                            <input type="text" name="fathername" id="fathername" class="form-control" aria-describedby="afathername" required>
		                            <div id="afathername" class="invalid-feedback">
        								Please provide a fathername.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Father's Mobile No. <font color="red">*</font></label>
		                            <input type="text" name="fathermobileno" id="fathermobileno" class="form-control" aria-describedby="afathermobileno" required>
		                            <div id="afathermobileno" class="invalid-feedback">
        								Please provide a father's mobileno.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Mother's Name <font color="red">*</font></label>
		                            <input type="text" name="mothername" id="mothername" class="form-control" aria-describedby="amothername" required>
		                            <div id="amothername" class="invalid-feedback">
        								Please provide a mother's name.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Mother's Mobile No. <font color="red">*</font></label>
		                            <input type="text" name="mothermobileno" id="mothermobileno" class="form-control" aria-describedby="amothermobileno" required>
		                            <div id="amothermobileno" class="invalid-feedback">
        								Please provide a mother's mobileno.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Guardian's Name</label>
		                            <input type="text" name="guardianname" id="guardianname" class="form-control" aria-describedby="aguardianname">
		                            <div id="aguardianname" class="invalid-feedback">
        								Please provide a guardian's name.
      								</div>
		                        </div>
		                        <div class="col-xl-3 col-lg-6 col-12 form-group">
		                            <label>Guardian's Mobile No.</label>
		                            <input type="text" name="guardianmobileno" id="guardianmobileno" class="form-control" aria-describedby="aguardianmobileno">
		                            <div id="aguardianmobileno" class="invalid-feedback">
        								Please provide a guardian's mobileno.
      								</div>
		                        </div>
		                        <div class="col-xl-6 col-lg-6 col-12 form-group">
		                            <label>Permanent Address <font color="red">*</font></label>
		                            <textarea rows="5" cols="10" name="permanentaddress" id="address" class="textarea form-control" aria-describedby="aaddress" required></textarea>
		                            <div id="aaddress" class="invalid-feedback">
        								Please provide a permanent address.
      								</div>
		                        </div>
		                        <div class="col-xl-6 col-lg-6 col-12 form-group">
		                            <label><span>Same as a permanent address</span> <input type="checkbox" id="sameaddress"> Present Address <font color="red">*</font></label>
		                            <textarea rows="5" cols="10" name="presentaddress" id="presentaddress" class="textarea form-control" aria-describedby="apresentaddress" required></textarea>
		                            <div id="apresentaddress" class="invalid-feedback">
        								Please provide a present address.
      								</div>
		                        </div>
		                        <div class="col-12 form-group mg-t-8">
		                            <button type="submit" id="save" class="btn-fill-lg btn-gradient-yellow btn-hover-bluedark save">Save</button>
		                            <button type="reset" id="reset" class="btn-fill-lg bg-blue-dark btn-hover-yellow reset">Reset</button>
		                        </div>
		                    </div>
		                </form>    
                    </div>
                </div>
            </div>
        </div>
    </div>	
	<!-- Tab Area End Here -->
	<script type="text/javascript" src="views/js/student/studentregistration.js"></script>
</body>
</html>
