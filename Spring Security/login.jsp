<form id="loginForm" action="/login" method="post">
  <input type="text" class="form-control" placeholder="UserID" required="required" name="id">
  <input type="password" class="form-control" placeholder="Password" required="required" name="password">
  <button class="btn btn-primary btn-block">Log in</button>
</form>


<script>
  //Spring Security
  //2020.05.22 Security 를 통한 Login AJAX 는 안됌
  //권한을 확인하며 수행하는 Security 를 통한 AJAX 방식에는 header 를 추가해줄 것.!
  
  var csrfParameter = $('meta[name="_csrf_parameter"]').attr('content');
  var csrfHeader = $('meta[name="_csrf_header"]').attr('content');
  var csrfToken = $('meta[name="_csrf"]').attr('content');
  
  
  $('#loginForm').submit(function(){
    var sendData = $('#loginForm').serialize();
    console.log(sendData);
    
  $.ajax({
    type : "POST",
    url  : "/login",
    data : sendData,
    error:function(data){
      alert("아이디 또는 비밀번호가 틀렸습니다.");
    }
  });
    //페이지 이동 방지
    return false;
  });
	</script>
