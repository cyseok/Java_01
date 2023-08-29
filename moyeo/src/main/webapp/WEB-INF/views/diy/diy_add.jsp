<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
  
  <head>
<jsp:include page="/WEB-INF/views/inc/head.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  </head>    
   
<body id="body" class="up-scroll">	
  <!-- ====================================
  ——— HEADER
  ===================================== -->
<jsp:include page="/WEB-INF/views/inc/header.jsp"/>
  <div class="main-wrapper booking-step-1">


<!-- ====================================
———	PAGE TITLE
===================================== -->
<section class="page-title">
  <div class="page-title-img bg-img bg-overlay-darken" style="background-image: url(${pageContext.request.contextPath}/assets/img/pages/page-title-bg7.jpg);">
    <div class="container">
      <div class="row align-items-center justify-content-center" style="height: 200px;">
        <div class="col-lg-6">
          <div class="page-title-content">
            <div class="title-border">
              <h2 class="text-uppercase text-white font-weight-bold">DIY 작성 페이지</h2>
            </div>
            <p class="text-white mb-0"></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>


<!-- ====================================
———	BOOKING SECTION
===================================== -->
<section class="py-8 py-md-10">
  <div class="container">
    <div class="mb-8"></div>
      <div class="row progress-wizard">
      
        
      
        <div class="col-4 progress-wizard-step incomplete">
          <div class="progress">
            <div class="progress-bar"></div>
          </div>
      
          <a href="diy_add" class="progress-wizard-dot">
            <div class="progress-wizard-content">
              <i class="fas fa-dollar-sign" aria-hidden="true"></i>
              <span class="d-block">DIY 작성</span>
            </div>
          </a>
        </div>
      
        <div class="col-4 progress-wizard-step incomplete">
          <div class="progress">
            <div class="progress-bar"></div>
          </div>
      
          <a href="diy_list" class="progress-wizard-dot">
            <div class="progress-wizard-content">
              <i class="fa fa-check" aria-hidden="true"></i>
              <span class="d-block">목록으로</span>
            </div>
          </a>
        </div>
        
       </div>
    
    
    <div class="row">
      <div class="col-md-7 col-lg-8 order-1 order-md-0">
        <h3 class="text-capitalize mb-5">여행 정보!</h3>

        <form action="diy_detail" name="diy_add" method="post" target="_blank" enctype="multipart/form-data">
     	   <div class="row">

              <div class="col-lg-6">
                <label for="exampleInputText">출발일</label>
                <div class="form-group form-group-icon form-group-icon-default">
                  <i class="far fa-calendar-alt" aria-hidden="true"></i>
                  <input type="text" class="form-control border-0 bg-smoke" name="dateRange" value="" placeholder="DD/MM/YYYY">
                </div>
                </div>
                
  	  
    
             <div class="col-lg-6">
                <label for="exampleInputText">도착일</label>
                <div class="form-group form-group-icon form-group-icon-default">
                  <i class="far fa-calendar-alt" aria-hidden="true"></i>
                  <input type="text" class="form-control border-0 bg-smoke" name="dateRange" value="" placeholder="DD/MM/YYYY">
                </div>
              </div>
        

    
            <div class="col-lg-6">
              <div class="form-group">
                <label for="inputName">인원</label>
                <input type="text" class="form-control border-0 bg-smoke" name="diyPeople" placeholder="ex) 3" >
              </div>
            </div>
    
            <div class="col-lg-6">
              <div class="form-group">
                <label for="inputName">지역</label>
                <input type="text" class="form-control border-0 bg-smoke" name="diyLoc" placeholder="ex) 서울">
              </div>
            </div>
    
            <div class="col-lg-6">
              <div class="form-group">
                <label for="inputName">비용</label>
                <input type="text" class="form-control border-0 bg-smoke" name="diyPrice" placeholder="ex) 10">
              </div>
            </div>
    
            <div class="col-lg-6">
              <div class="form-group">
                <label for="inputName">제목</label>
                <input type="text" class="form-control border-0 bg-smoke" name="diyTitle" placeholder="ex) 3박 4일 강릉여행 후기!!">
              </div>
            </div>
           
           <div class="col-lg-6">
              <div class="form-group">
                <label for="inputName">간단한 소개글</label>
                <textarea class="form-control border-0 bg-smoke" rows="2" name="diyIntroduction" placeholder="ex) 여행을 간단하게 소개해주세요"></textarea>
              </div>
            </div>
           
    
          <div class="form-group mb-5">
    		<label for="imgUpload">썸네일 사진올리기</label>
    		<input type="file" class="btn btn-xs btn-outline-secondary text-uppercase" id="imgUpload" name="diyThumbnail">
    		<div id="imagePreview"></div>
		  </div>
		 	
          <div class="form-group mb-5" id="day1Block">
            <label for="exampleFormControlTextarea1">DAY 1</label>
            <textarea class="form-control border-0 bg-smoke" name="diyContent1" rows="7"></textarea>
          </div>
          
          <div class="form-group mb-5">
    		<label for="imgUpload">DAY 1 사진올리기</label>
    		<input type="file" class="btn btn-xs btn-outline-secondary text-uppercase" id="imgUpload" name="diyContent1Img">
    		<div id="imagePreview"></div>
		  </div>
            
           <div class="form-group mb-5">
            <label for="exampleFormControlTextarea1">DAY 2</label>
            <textarea class="form-control border-0 bg-smoke" rows="7"></textarea>
          </div>
          
          <div class="form-group mb-5">
    		<label for="imgUpload">DAY 2 사진올리기</label>
    		<input type="file" class="btn btn-xs btn-outline-secondary text-uppercase" id="imgUpload" name="diyContent2Img">
    		<div id="imagePreview"></div>
		  </div>
            
           <div class="form-group mb-5">
            <label for="exampleFormControlTextarea1">DAY 3</label>
            <textarea class="form-control border-0 bg-smoke" rows="7"></textarea>
          </div>
          
          <div class="form-group mb-5">
    		<label for="imgUpload">DAY 3 사진올리기</label>
    		<input type="file" class="btn btn-xs btn-outline-secondary text-uppercase" id="imgUpload" name="diyContent3Img">
    		<div id="imagePreview"></div>
		  </div>
            
			<div class="form-group mb-5">
            <label for="exampleFormControlTextarea1">DAY 4</label>
            <textarea class="form-control border-0 bg-smoke" rows="7"></textarea>
          </div>
          
          <div class="form-group mb-5">
    		<label for="imgUpload">DAY 4 사진올리기</label>
    		<input type="file" class="btn btn-xs btn-outline-secondary text-uppercase" id="imgUpload" name="diyContent4Img">
    		<div id="imagePreview"></div>
		  </div>
		  
           <div class="container mt-5">
	        <div id="elementContainer" id="addButton" class="mt-3"></div>
	        <button type="button" id="addButton" class="btn btn-hover btn-outline-secondary text-uppercase">
	            Add DAY
	        </button>
	      </div>

          <div class="form-group form-check mb-9">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">졸리<a href="https://www.naver.com/">다아아아아아</a>
            </label>
          </div>
        </div>
    
           <div class="text-center text-md-start text-lg-end">
            <button type="submit" class="btn btn-primary text-uppercase" id="enrollBtn">
              작성하기
            </button>
           </div>
           
	  </form>	  
	  
      </div>
    </div>
</section>

    <!-- ====================================
    ——— FOOTER SECTION
    ===================================== -->
    <jsp:include page="/WEB-INF/views/inc/footer.jsp"/>
  
    <!-- ====================================
    ——— MODAL SECTION
    ===================================== -->
    <!-- Signup Modal -->
    <div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-label="signupModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header rounded">
            <h3 class="modal-title text-uppercase font-weight-bold">Create your account</h3>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>

          <div class="modal-body">
            <form class="" action="index.html" method="get">
              <div class="mb-3">
                <input type="text" class="form-control bg-smoke" required="" placeholder="Full Name">
              </div>

              <div class="mb-3">
                <input type="email" class="form-control bg-smoke" required="" placeholder="Email">
              </div>
    
              <div class="mb-3">
                <input type="password" class="form-control bg-smoke" required="" placeholder="Password">
              </div>
    
              <div class="mb-3 form-check mb-0">
                <input type="checkbox" class="form-check-input" id="exampleCheck4">
                <label class="form-check-label text-gray-color mb-3" for="exampleCheck4">
                  I agree to the terms of use and privacy.
                </label>
              </div>

              <div class="d-grid">
                <button type="submit" class="btn btn-primary btn-block text-uppercase">Login</button>
              </div>

              <div class="text-uppercase text-center py-3">Or</div>

              <div class="d-grid">
                <button type="submit" class="btn btn-facebook btn-block text-uppercase text-white">Login with facebook</button>
              </div>
            </form>
          </div>
    
          <div class="modal-footer justify-content-center">
            <p class="mb-1">Don’t have an Account? <a href="javascript:void(0)">Sign up</a></p>
          </div>
        </div>
      </div>
    </div>

    <!-- Login Modal -->
    <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-label="loginModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header rounded">
            <h3 class="modal-title text-uppercase font-weight-bold">Log in to your account</h3>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>

          <div class="modal-body">
            <form class="" action="index.html" method="get">
              <div class="mb-3">
                <input type="email" class="form-control bg-smoke" required="" placeholder="Email">
              </div>

              <div class="mb-3">
                <input type="password" class="form-control bg-smoke" required="" placeholder="Password">
              </div>

              <div class="mb-3 form-check mb-0">
                <input type="checkbox" class="form-check-input" id="exampleCheck5">
                <label class="form-check-label text-gray-color mb-3" for="exampleCheck5">
                  Remember me
                </label>
                <a class="pull-right" href="javascript:void(0)">Fogot Password?</a>
             </div>

             <div class="d-grid">
              <button type="submit" class="btn btn-primary text-uppercase">Login</button>
             </div>

              <div class="text-uppercase text-center py-3">Or</div>

              <div class="d-grid">
                <button type="submit" class="btn btn-facebook text-uppercase text-white">Login with facebook</button>
               </div>
            </form>
          </div>

          <div class="modal-footer justify-content-center">
            <p class="mb-1">Don’t have an Account? <a href="javascript:void(0)">Sign up</a></p>
          </div>
        </div>
      </div>
    </div>

    <!-- INQUIRY IN MODAL -->
    <div class="modal fade" id="inquiry" tabindex="-1" role="dialog" aria-label="inquiryModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header rounded">
            <h3 class="modal-title text-uppercase font-weight-bold">Inquiry about tour</h3>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>

          <div class="modal-body pb-3">
            <form class="" action="index.html" method="get">
              <div class="mb-3">
                <input type="text" class="form-control bg-smoke" required="" placeholder="Your Name">
              </div>

              <div class="mb-3">
                <input type="email" class="form-control bg-smoke" required="" placeholder="Your Email">
              </div>
    
              <div class="mb-3">
                <input type="number" class="form-control bg-smoke" required="" placeholder="Phone Number">
              </div>

              <div class="mb-3">
                <textarea class="form-control bg-smoke" rows="6" placeholder="Message"></textarea>
              </div>
    
              <button type="submit" class="btn btn-primary text-uppercase">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>


    <script >
    const addButton = document.getElementById('addButton');
    const elementContainer = document.getElementById('elementContainer');

    // Counter for unique IDs
    let counter = 5;

    // Function to add new elements
    function addNewDay() {
    	 
        const dayDiv = document.createElement('div');
        dayDiv.classList.add('form-group', 'mb-5');

        const dayLabel = document.createElement('label');
        dayLabel.textContent = `DAY ${counter}`;

        const textarea = document.createElement('textarea');
        textarea.classList.add('form-control', 'border-0', 'bg-smoke');
        textarea.rows = 7;

        const uploadLabel = document.createElement('label');
        uploadLabel.textContent = `Upload DAY ${counter} photo`;

        const uploadInput = document.createElement('input');
        uploadInput.type = 'file';
        uploadInput.classList.add('btn', 'btn-xs', 'btn-outline-secondary', 'text-uppercase');

        const deleteButton = document.createElement('button');
        deleteButton.type = 'button';
        deleteButton.classList.add('btn', 'btn-outline-secondary', 'text-uppercase');
        deleteButton.textContent = 'Delete DAY';
        deleteButton.addEventListener('click', () => {
            elementContainer.removeChild(dayDiv);
        });

        dayDiv.appendChild(dayLabel);
        dayDiv.appendChild(textarea);
        dayDiv.appendChild(uploadLabel);
        dayDiv.appendChild(uploadInput);
        dayDiv.appendChild(deleteButton);

        elementContainer.appendChild(dayDiv, dayLabel);

    	 counter++;
  
        dayLabel.textContent = `DAY ${counter}`;
    }

    // Add event listener to the "Add DAY" button
    addButton.addEventListener('click', addNewDay);
    </script>

	<script type="text/javascript">
	
	function submitCheck() {
		let enrollForm = $("#diy_form");

		if(dateRange.value=="") {
			alert("날짜를 입력해주세요.");
			return;
		}
		
		var noReg=/\d{2}/g;
		if(!noReg.test(diyPeople.value)) {
			alert("인원은 숫자로만 입력해주세요.");
			diyPeople.focus();
			return;
		}
		
		if(diyLoc.value=="") {
			alert("지역을 입력해 주세요.");
			diyLoc.focus();
			return;
		}
		
		var noReg=/\d{9}/g;
		if(diyPrice.value=="") {
			alert("비용은 숫자로만 입력해주세요.");
			diyPrice.focus();
			return;
		}
		
		if(diyTitle.value=="") {
			alert("제목을 입력해 주세요.");
			diyTitle.focus();
			return;
		}

		if(diyIntroduction.value=="") {
			alert("소개글을 입력해 주세요.");
			diyIntroduction.focus();
			return;
		}
		
		if(diyContent1.value=="") {
			alert("내용을 입력해 주세요.");
			diyContent1.focus();
			return;
		}

		 $("#enrollBtn").on("click", function(e){
		        e.preventDefault();
		        diy_add.submit();
		    });
	} 
	</script>

    
    
    

    <!-- Javascript -->
    
    <script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/menuzord/js/menuzord.js"></script>
    
    <script src='${pageContext.request.contextPath}/assets/plugins/fancybox/jquery.fancybox.min.js'></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/lazyestload/lazyestload.js"></script>
    
    <script src='${pageContext.request.contextPath}/assets/plugins/selectric/jquery.selectric.min.js'></script>
    <script src='${pageContext.request.contextPath}/assets/plugins/daterangepicker/js/moment.min.js'></script>
    <script src='${pageContext.request.contextPath}/assets/plugins/daterangepicker/js/daterangepicker.min.js'></script>
    
    <script src="${pageContext.request.contextPath}/assets/plugins/smoothscroll/SmoothScroll.js"></script>
    
    <script src="${pageContext.request.contextPath}/assets/js/star.js"></script>
    
    <script src="${pageContext.request.contextPath}/assets/plugins/smoothscroll/SmoothScroll.js"></script>
    
    <script src="${pageContext.request.contextPath}/assets/js/star.js"></script>
  </body>
</html>