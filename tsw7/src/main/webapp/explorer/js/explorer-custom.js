
	var faq_view = 0;				//	 default view [ 0 = single view, 1 = full view ]
	var faq_stiky_index = true;		//	 floating navigation
	
	

	

	$(document).ready(function() {
			
		$('table.exp-stats tbody tr:not(.labels)').hover(function(){
			var productID = $(this).attr('id');
			var currentStats = $(this).closest('table');
					
			$('.chart .chart-'+productID, currentStats).show();
			$('.data  .sales-total',currentStats).hide();
			$('.data  .sales-'+productID,currentStats).show();
		},function(){
			var productID = $(this).attr('id');
			var currentStats = $(this).closest('table');
			
			$('.chart .chart-'+productID,currentStats).hide();
			$('.data  .sales-total',currentStats).show();
			$('.data  .sales-'+productID,currentStats).hide();
		});
		
		
		
		
		

		
		
		/***** Login form *****************************************************/	
		if ($('.exp-form').length){
			exp_loadForms();
			}
		
		
		/***** Nav - Sidebar **************************************************/	
		if ($('#side-nav').length){
			exp_loadSideNav();
			}
		
		
		/***** Nav - Sidebar **************************************************/	
		if ($('#header').length){
			exp_loadTopNav();
			}
			

		/***** Panel - Gallery ************************************************/	
		if ($('.gallery-view-thumbnail').size()){
			exp_loadGallery();
			}
		
		
		/***** Panel - Chart **************************************************/	
		if ($('.chartData').length){
			exp_loadCharts();
			}
		
		/***** Panel - WYSIWYG ************************************************/	
		if ( $('#niceEditArea').size() ){
			new nicEditor({fullPanel : true, iconsPath : 'explorer/images/niceditoricons.gif'}).panelInstance('niceEditArea');
			}
		
		
		/***** Panel - Code view **********************************************/	
		if ($('.code').size()){
			$(".code.css").snippet("css",{style:"acid",transparent:true,showNum:true});
			$(".code.php").snippet("php",{style:"acid",transparent:true,showNum:true});
			$(".code.js").snippet("javascript",{style:"acid",transparent:true,showNum:true});
			$(".code.html").snippet("html",{style:"acid",transparent:true,showNum:true});
			$(".code.sql").snippet("sql",{style:"acid",transparent:true,showNum:true});
			}
		
		
		/***** Panel - FAQ ****************************************************/	
		if ($('.panel .faq-columns').size()) {	
			exp_loadFAQ();
			}
		
		
		/***** Panel - Wizard *************************************************/	
		if ($('.panel.wizard').size()) {	
			exp_loadWizard();
			}
			
			
		/***** Panel - Calendar *************************************************/	
		exp_loadCalendar();
		
		
		
		/***** Panels - General *************************************************/	
		exp_loadPanels();

		
		$('.help').hover(function(){
			$('.popup-help', this).fadeIn('fast');
		},function(){
			$('.popup-help', this).fadeOut('fast');
		});
		
		$('.notice .close').click(function(){
			$(this).closest('.notice').slideUp('fast');
		});
		
		
		/***** Attach theme styles ********************************************/	
			exp_colorSupport();
	});
	
	
	function exp_loadForms() {
		var form = $('.exp-form');
		
		$('.btn-recovery').click(function(){
			$('#exp-register').hide();
			$('#exp-login').hide();
			$('#exp-recovery').show();
			
			return false;
		});
		
		$('.btn-register').click(function(){
			$('#exp-register').show();
			$('#exp-login').hide();
			$('#exp-recovery').hide();
			
			return false;
		});
		
		$('.btn-cancel').click(function(){
			$('#exp-register').hide();
			$('#exp-login').show();
			$('#exp-recovery').hide();
			
			return false;
		});
	}
	
	
	function exp_colorSupport(){
		
		//$('.fc-widget-header').addClass('theme-bar-color');
		//$('.fc-button-inner').addClass('theme-bar-color');
	
	}
	
	
	function loadPercents(animate){
		if (typeof(animate) == 'undefined') { animate = true; }
		
		if ($('.percents>div:not(.done)').size()){
			var currentPercent = $('.percents>div:not(.done)')[0];
			var percent = $('span', currentPercent).html();
			$('span', currentPercent).html('').css('display','block');
			
			//log('Load percent: [animate'+animate+']');
			
			if (animate){
			$(currentPercent).delay(300).animate({
				'width':percent+'%'
				},{
					duration:600, 
					step:function(width){
						var crPercent = 625/100;
						var crValue = width;
						
						$('span',currentPercent).html(Math.round(crValue)+'%');
					},
					complete: function (){
						$(this).addClass('done');
						loadPercents();
					}
				});				
			}else{
				$('span', currentPercent).html(percent+'%');
				$(currentPercent).css('width', percent+'%').addClass('done');
				
				loadPercents();
			}
			
		}
	}

	
	function exp_loadCalendar(){
		$('.tabularData').dataTable();
		
		if ($('#scrolable_content').size()){
			$("#scrolable_content").mCustomScrollbar( "vertical", 400, "easeOutCirc", 1.05, "auto", "yes", "yes", 10);
			}
		//$('#calendar-events-rnd').fullCalendar({ });
		
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
	
	
		$('.calendar-nav .next').click(function(){
			 $('#calendar-events-rnd').fullCalendar('next');
			 $('.calendar-nav h1').html($('.fc-header-title h2').html());
			 
			 return false;
		});
	
		$('.calendar-nav .back').click(function(){
			 $('#calendar-events-rnd').fullCalendar('prev');
			 $('.calendar-nav h1').html($('.fc-header-title h2').html());
			 
			 return false;
		});
		
	
		var calendar = $('#calendar-events-rnd').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek'

			},
			editable: true,
			firstHour: 8,	
			selectable: true,
			selectHelper: true,
		    select: function(start, end, allDay) {
	            window.open('/tsw7/newEvent',target='_self');
	            return false;
		    },
		    eventSources: [
				'/tsw7/fcEvent'
				],
				eventClick: function(event) {
					if (event.url) {
						window.open(event.url,target='_self');
						return false;
					}
				}
		});
		
		$('.calendar-nav h1').html($('.fc-header-title h2').html());
	}
	
	function exp_loadGallery(){
		/*		
		$( ".gallery-view-thumbnail" ).sortable({
			placeholder: "thumb-state-highlight"
		});
		
		$( ".gallery-view-thumbnail" ).disableSelection();
		
		$('.gallery-view-thumbnail .crop').click(function(){
			var picture = $(this).closest('li');
			var imgSrc = $('.thumb img', picture).attr('alt');
			$('.gallery-view-thumbnail', picture).append('<img src="'+imgSrc+'" >').fadeIn();
		});
		
		$('.gallery-view-thumbnail .remove').click(function(){
			var thumb = $(this).closest('li');
			$(thumb).fadeOut('slow');
		});
		
		
		$('.gallery-view-thumbnail li').hover(function(){
			$('.edit, .remove', this).show(); //fadeIn('fast');
		}, function(){
			$('.edit, .remove', this).hide(); //.fadeOut('slow');
		});
		*/			
			if ($('.content-gallery').size()){				
				$('.content-gallery li').hover(function(){
					$('div', this).fadeIn('fast');
				}, function(){
					$('div', this).fadeOut('fast');
				});		
				$(".content-gallery div a").colorbox();		
			}

	}
	
	
	function exp_loadPanels(){
	
		/***** Panel - Toolbar Support ****************************************/	
		if ($('.panel .toolbar')){
			
			$('.toolbar .view-button').click(function(){
				var panel = $(this).closest('.panel');
				
				$('.toolbar .view-button', panel).removeClass('selected');
				$(this).addClass('selected');
				
				var related_content = $(this).attr('rel');
				if ($('#'+related_content+'.view-content', panel).size()){
					
					$('.view-content.selected', panel).removeClass('selected');
					$('#'+related_content+'.view-content', panel).addClass('selected');
				}
				
				return false;
			});
			
			$( ".section > .tiny, .section> .full, .section> .small, .section> .large" ).sortable({
				connectWith: ".section > .tiny, .section> .full, .section> .small, .section> .large",
				placeholder: 'ui-state-highlight',
				handle: '.title, .title-large',
				helper: 'clone'
			});

			$( ".panel" ).addClass( "ui-widget ui-widget-content ui-helper-clearfix ui-corner-all" )
				.find( ".panel>.title" )
					.addClass( "ui-widget-header ui-corner-all" )
					.prepend( "<span class='ui-icon ui-icon-minusthick'></span>")
					.end()
				.find( ".panel>.content" );

			$( ".panel>.title .ui-icon" ).click(function() {
				$( this ).toggleClass( "ui-icon-minusthick" ).toggleClass( "ui-icon-plusthick" );
				$( this ).parents( ".panel:first" ).find( ".panel > .content" ).toggle();
			});
			
			
			$(".panel .title>.drop, .panel .title-large>.drop").click(function(event){
				event.stopPropagation();
				
				var panel = $(this).closest('.panel');
				var content = $('.content', panel);
				
				if ($(this).hasClass('minimized')){
					$(content).slideDown('fast');
					$(this).removeClass('minimized');
				}else{
					$(content).slideUp('fast');
					$(this).addClass('minimized');
				}
				
			});
			
			
			//$( ".section >.tiny" ).disableSelection();
			
		}
		
		
		/***** Panel - Tabs Support *******************************************/	
		$('.panel .tabs-box li').click(function(){
			var panel = $(this).closest('.panel');
			var tab_content_id = $('a', this).attr('rel');
			
			$('.tabs-box li', panel).removeClass('selected');
			$(this).addClass('selected');
			
			if ($('#'+tab_content_id, panel).size()){
				$('.tabs-content.selected', panel).removeClass('selected');
				$('#'+tab_content_id+'.tabs-content', panel).addClass('selected');
			}
			
			return false;
		});
	}
	
	
	function exp_loadTopNav(){
	
		$('#header li').click(function(){
			if ($(this).hasClass('selected')) { return false; }
			
			var list = $(this).closest('ul');
			var li = this;
			
			$('.selected .sel', list).fadeOut('fast', function () {
				$('.selected', list).removeClass('selected');
			
				$('.sel', li).fadeIn('fast', function (){
					$(li).addClass('selected');
				});
			});
		});
		
	}
	
	
	function exp_loadSideNav(){
	
		$('#container > .nav-wrapper li').click(function(){
			$('#container > .nav-wrapper li').removeClass('selected');
			$(this).addClass('selected');
		});
		
		$('#side-nav li').hover(function(){
			if ($(this).hasClass('selected')) { return false; }
			
			$('div>div', this).fadeIn('slow');
		}, function(){
			if ($(this).hasClass('selected')) { return false; }
			
			$('div>div', this).fadeOut('slow');
		});
		
	}
	
	
	function exp_loadFAQ(){
		if (faq_stiky_index){
			$('.columns-index').addClass('auto');
			}
		
		$('.columns-index>ul').containedStickyScroll({ duration: 300 });
		
		$('.columns-index>ul>li>a').click(function(event){
			var stContentID = $(this).attr('rel');

			if ( faq_view==0 ){
				if ($('.columns-content>div.selected').size()){
					$('.columns-content>div.selected').slideUp('fast').removeClass('selected');
				}
				
				$('.columns-content #'+stContentID).slideDown('fast').addClass('selected');
			}
		});
		
		$('.columns-index ul ul li').click(function(event){
			$('.columns-index>ul>li.active').removeClass('active selected');
			
			var pt_ul = $(this).closest('ul');			
			var pt_li = $(pt_ul).closest('li');
			$(pt_li).addClass('active selected');
		});
		
		$('.view-column').click(function(){
			faq_view = 1;
			
			$('.columns-index ul ul').each(function(){
				$(this).slideDown().animate({'margin-bottom':'15px'});		
			});
			
			$('.columns-content > div').slideDown();
		});
		
		$('.view-dropdown').click(function(){
			faq_view = 0;
			
			$('.columns-index li ul').each(function(){
				if (!$(this).parent().hasClass('selected')){
					$(this).animate({'margin-bottom':'0'}).slideUp();
				}
			});
			
			var activeContentID = $('.columns-index>ul>li.selected>a').attr('rel');
			
			$('.columns-content>div').each(function(){
				if ($(this).attr('id')==activeContentID){
				
				}else{
					$(this).slideUp();
				}
			});
		});
				
		$('.columns-index>ul>li').click(function(){
			
			if ($(this).hasClass('selected')) { return false; }
			
			$('.columns-index>ul>li').removeClass('selected active');
			$(this).addClass('selected active');
			
			if ( faq_view==1 ){ return false; }
			
			if($('.columns-index ul ul:visible').size()){
				$('.columns-index ul ul:visible').slideUp();
			}
			
			if ($('ul', this).size()){
				$('ul', this).slideDown();
			}
		});
		
	}
	
	
	function exp_loadCharts( ){
		if ($('#exp-line-chart').size()){
			$('.chartData').visualize({type: 'line', width: '862px', height:'250px'}).appendTo('#exp-line-chart');
			$('.chartData').visualize({type: 'pie', width: '360px', height:'250px'}).appendTo('#exp-bar-pie');
			$('.chartData').visualize({type: 'area', width: '360px', height:'250px'}).appendTo('#exp-bar-zone');
			$('.chartData').visualize({type: 'bar', width: '862px', height:'250px'}).appendTo('#exp-bar-chart');
		}
		
		if ($('#fullpan-exp-line-chart').size()){
			$('.chartData').visualize({type: 'bar', width: '600px', height:'200px'}).appendTo('#fullpan-exp-bar-chart');
			$('.chartData').visualize({type: 'pie', width: '600px', height:'200px'}).appendTo('#fullpan-exp-pie-chart');
			$('.chartData').visualize({type: 'area', width: '600px', height:'200px'}).appendTo('#fullpan-exp-area-chart');
			$('.chartData').visualize({type: 'line', width: '600px', height:'200px'}).appendTo('#fullpan-exp-line-chart');
		}
	}
	
	
	function exp_loadWizard( ){
	
			var panel = $('.panel.wizard');
			var current_state = 0;
			
			var st_01 = 0;
			var st_02 = 105;
			var st_03 = 210;
			var st_04 = 315;
			var st_05 = 420;
			var st_06 = 525;

			if ( $('.pbar',panel).hasClass('ct-step-1') ) { current_state = 1; }
			if ( $('.pbar',panel).hasClass('ct-step-2') ) { current_state = 2; }
			if ( $('.pbar',panel).hasClass('ct-step-3') ) { current_state = 3; }
			if ( $('.pbar',panel).hasClass('ct-step-4') ) { current_state = 4; }
			if ( $('.pbar',panel).hasClass('ct-step-5') ) { current_state = 5; }
			if ( $('.pbar',panel).hasClass('ct-step-6') ) { current_state = 6; }
			

			//** Previews button click
			//**
			$('.wiz-prev', panel).click(function(){
				var prev_state = current_state;
				
				if (current_state>1) { prev_state--;  }
				
				if (current_state!=prev_state){
					var nt_width = ((prev_state-1)*105)+'px';
					
					$('.pbar .done',panel).animate( {'width':nt_width},350,'easeInOutExpo', function (){
						$('.pbar',panel).removeClass('ct-step-'+current_state);
						$('.pbar',panel).addClass('ct-step-'+prev_state);
						
						$('.progress-wrap>.step-'+prev_state).addClass('selected').removeClass('on');
						$('.progress-wrap>.step-'+current_state).addClass('off').removeClass('selected').removeClass('on');
						
						current_state--;
					});
					
					$('.label', panel).removeClass('selected');
					$('.label:eq('+(prev_state-1)+')', panel).addClass('selected');				
					
					changeWizardStep(prev_state, panel);
				}
				return false;
			});
			
			
			//** Next button click
			//**
			$('.wiz-next', panel).click(function(){
				var next_state = current_state;
				
				if (current_state<6) { next_state++;  }
				
				if (current_state!=next_state){
					var nt_width = ((next_state-1)*105)+'px';
					
					$('.pbar .done',panel).animate( {'width':nt_width},350,'easeInOutExpo', function(){
						$('.pbar',panel).removeClass('ct-step-'+current_state);
						$('.pbar',panel).addClass('ct-step-'+next_state);
						
						$('.progress-wrap>.step-'+current_state).addClass('on').removeClass('selected').removeClass('off');
						$('.progress-wrap>.step-'+next_state).addClass('selected').removeClass('off');
						
						current_state++;
					});
					
					$('.label', panel).removeClass('selected');
					$('.label:eq('+current_state+')', panel).addClass('selected');				
					
					changeWizardStep(next_state, panel);
				}
				return false;
			});
			
	}
	
	
	function changeWizardStep(page, panel){
		if ($( '.wizard-content li').length<page-1) { return false; }
		
		$( '.wizard-content li:visible'  ,panel).fadeOut(150, function(){
			$( '.wizard-content li:eq('+(page-1)+')'  ,panel).fadeIn(150);
		});		
	}