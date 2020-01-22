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
          success : function(data, status, xhr) {
              console.log(data);
              alert('AJAX Success!!!')
          },
          error: function(jqXHR, textStatus, errorThrown) {
              alert(jqXHR.responseText);
          }
      });
  }

</script>
