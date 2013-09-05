<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quickStart-resources" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Scheduling Quick Entry</title>

  </head>
  
  <body>
	<div class="section">
		<div class="full">
		
		<div class="panel wizard">
			<div class="header">
				<div class="wizard-title">
					<h2>Scheduling Quick Entry</h2>
					<span>We will guide you tough the theme install process</span>
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
						
						<div class="label selected">Theme Install<span>Copy files in folder</span></div>
						<div class="label">Database Backup<span>Create the database</span></div>
						<div class="label">Minimal Config<span>Customize color &amp; name</span></div>
						<div class="label">Sidebars Setup<span>Add content to sidebars</span></div>
						<div class="label">Import Content<span>Upload update.xml</span></div>
						<div class="label">Finish<span>Save &amp; start posting</span></div>
						
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
								<h2>Theme Install</h2>
								<span class="subtext">Copy files in folder</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>Database setup</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>
									
									<p>
										<label for="text">User name</label>
										<input type="text" id="text" name="text" />
									</p>
										
									<p>
										<label for="text">Password</label>
										<input type="text" id="text" name="text" />
									</p>
									
									<p>
										<label for="text">Database name</label>
										<input type="text" id="text" name="text" />
									</p>
								</div>
								
								
								<div class="formular topad">
									<h1>Set file permissions</h1>
									<div class="hr"></div>
									<p>Permissions on Unix-like systems are managed in three distinct classes. These classes are known as user, group, and others. In effect, Unix permissions are a simplified form of access control lists (ACLs).</p>
												  						
									<div>
										<input type="radio" id="test_radio_1" name="test_radio_group" />
										<label for="test_radio_1">775 - Read</label>
									</div>
										
									<div>
										<input type="radio" id="test_radio_2" name="test_radio_group" />
										<label for="test_radio_2">777 - Read/Write</label>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">2</span>
								<h2>Database Backup</h2>
								<span class="subtext">Create the database</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">&nbsp;</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">3</span>
								<h2>Minimal Config</h2>
								<span class="subtext">Customize color &amp; name</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">&nbsp;</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">4</span>
								<h2>Widgets &amp; Sidebars</h2>
								<span class="subtext">Add content to sidebars</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">&nbsp;</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">5</span>
								<h2>Import Content</h2>
								<span class="subtext">Upload update.xml</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">&nbsp;</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">6</span>
								<h2>Finish</h2>
								<span class="subtext">Save &amp; start posting</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">&nbsp;</div>
						</li>
					</ul>
				</div>
				
				<div class="wizard-nav clearfix">
					<a href="#" class="wiz-prev">
						<span><img src="explorer/images/icon-previews.png" /> &nbsp;Database Backup</span>
					</a>
					<a href="#" class="wiz-next">
						<span>Widgets &amp; Sidebars &nbsp;&nbsp;<img src="explorer/images/icon-next.png" /></span>
					</a>
				</div>
				
			</div>
		</div>
		
		</div>
	</div>
  </body>
</html>
