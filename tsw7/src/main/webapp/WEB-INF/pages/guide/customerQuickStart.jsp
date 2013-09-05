<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quickStart-resources" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Customer Quick Entry</title>

  </head>
  
  <body>
	<div class="section">
		<div class="full">
		
		<div class="panel wizard">
			<div class="header">
				<div class="wizard-title">
					<h2>Customer Quick Entry</h2>
					<span>We will guide you through Customer Family setup</span>
				</div>
				<div class="progress-zone">
					<div class="progress-bar">
					
						<div class="progress-wrap">
							<div class="pbar ct-step-1"><div class="done"></div></div>
							
							<div class="step-1 selected">1</div>
							<div class="step-2 off">2</div>
							<div class="step-3 off">3</div>
							<div class="step-4 off">4</div>
							<div class="step-5 off">5</div>
							<div class="step-6 off">6</div>
						</div>
						
						<div class="label selected">Family Parent<span>Enter parent of family</span></div>
						<div class="label">Address<span>Enter family address</span></div>
						<div class="label">Family Members<span>Enter member names</span></div>
						<div class="label">Finish<span>Save entire family</span></div>
						<div class="label">Extra1<span>Extra1</span></div>
						<div class="label">Extra2<span>Extra2</span></div>
						
					</div>
				</div>
				<div class="theme"></div>
			</div>
			
			<div class="content">					
				<div class="wizard-content">
					<ul>
						<li>
							<div class="wizard-text">
								<span class="numbering">1</span>
								<h2>Family Parent</h2>
								<span class="subtext">Enter parent of family</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>Parent</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>
									
									<p>
										<label for="text">Parent First Name</label>
										<input type="text" id="text" name="text" />
									</p>
										
									<p>
										<label for="text">Parent Last Name</label>
										<input type="text" id="text" name="text" />
									</p>
									
									<p>
										<label for="text">Email Address</label>
										<input type="text" id="text" name="text" />
									</p>
									<p>
										<label for="text">Phone</label>
										<input type="text" id="text" name="text" />
									</p>
								</div>
								
							</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">2</span>
								<h2>Family Address</h2>
								<span class="subtext">Enter family address</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>Address</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>
																
							
									<p>
										<label for="text">Address</label>
										<input type="text" id="text" name="text" />
									</p>
										
									<p>
										<label for="text">City</label>
										<input type="text" id="text" name="text" />
									</p>
									
									<p>
										<label for="text">State</label>
										<input type="text" id="text" name="text" />
									</p>
									<p>
										<label for="text">Zip</label>
										<input type="text" id="text" name="text" />
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">3</span>
								<h2>Family Members</h2>
								<span class="subtext">Enter member names</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>Member Names</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>

										<table>
											<tbody>
												<tr>
													<td>
														<label for="text">First Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Last Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Year Born</label> 
														<input type="text" id="text" name="text" />
													</td>
												</tr>
												<tr>
													<td>
														<label for="text">First Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Last Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Year Born</label> 
														<input type="text" id="text" name="text" />
													</td>
												</tr>
												<tr>
													<td>
														<label for="text">First Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Last Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Year Born</label> 
														<input type="text" id="text" name="text" />
													</td>
												</tr>
												<tr>
													<td>
														<label for="text">First Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Last Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Year Born</label> 
														<input type="text" id="text" name="text" />
													</td>													
												</tr>
												<tr>
													<td>
														<label for="text">First Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Last Name</label> 
														<input type="text" id="text" name="text" />
													</td>
													<td>
														<label for="text">Year Born</label> 
														<input type="text" id="text" name="text" />
													</td>													
												</tr>
											</tbody>
										</table>
									</div>
							</div>
						</li>

						<li>
							<div class="wizard-text">
								<span class="numbering">4</span>
								<h2>Finish</h2>
								<span class="subtext">Save entire family</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">							
							<h1>Save</h1>
							<div class="hr"></div>
							<p>Save new Customer Family.</p>
							<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="#"><button> &nbsp;Save&nbsp; </button></a>					
							&nbsp;</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">5</span>
								<h2>Extra1</h2>
								<span class="subtext">Extra1</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">							
							<h1>Extra1</h1>
							<div class="hr"></div>
							<p>Extra1</p>
							<br><br>				
							&nbsp;</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">6</span>
								<h2>Extra2</h2>
								<span class="subtext">Extra2</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">							
							<h1>Extra2</h1>
							<div class="hr"></div>
							<p>Extra2</p>
							<br><br>				
							&nbsp;</div>
						</li>
					</ul>
				</div>
				
				<div class="wizard-nav clearfix">
					<a href="#" class="wiz-prev">
						<span><img src="explorer/images/icon-previews.png" /> &nbsp;Previous Step</span>
					</a>
					<a href="#" class="wiz-next">
						<span>Next Step&nbsp;&nbsp;<img src="explorer/images/icon-next.png" /></span>
					</a>
				</div>
				
			</div>
		</div>
		
		</div>
	</div>
  </body>
</html>
