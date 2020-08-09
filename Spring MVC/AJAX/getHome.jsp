<script>

  function searchGet(_pageNo) {
      $('#page').val(_pageNo||0);

      //var sendData = {"type":$('#type').val(), 
      //                "complete":$('#complete').val(), 
      //                 page:$('#page').val()};
                       
      var sendData = $('#SearchForm').serialize();
      console.log(sendData);

      $.ajax({
          type: "GET",
          url : "<c:url value='/searchGet.do' />",
          data: sendData,
          async: true,
          success : function(data) {
              //Controller에서 전송한 List
              console.log(data);
          }
      });
  }
</script>

<script>

  function searchGet() {

      var sendData = $('#SearchForm').serialize();

      $.ajax({
          type: "POST",
          url : "login.do",
          data: sendData,
          async: true,
          success : function(data) {
              if(data.responseCode == 'success')
                alert("로그인 성공");
              else if(data.responseCode == 'fail')
                alert("아이디 또는 비밀번호가 틀렸습니다.");
              else
                alert("Error!! 다시 시도해주세요.");
          }
      });
  }
</script>
