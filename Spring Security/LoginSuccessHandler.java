public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  private RequestCache requestCache = new HttpSessionRequestCache();
  private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
  
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
     
      //redirect url 작업을 위한 메서드를 호출
      resultRedirectStrategy(request, response, authentication);
     
  }
  
  protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

      //RequestCache 객체를 통해 SavedRequest 객체를 가져온다
      SavedRequest savedRequest = requestCache.getRequest(request, response);
  
      
      //세션에 이동할 url의 정보가 담겨져 있을때 즉, 인증 권한이 필요한 페이지에 접근했을 경우
      if(savedRequest!=null)
      {
          //savedRequest 객체를 통해 getRedirectUrl (로그인화면을 보기 전에 갔던 url)을 가져온다
          String targetUrl = savedRequest.getRedirectUrl();
          
          redirectStratgy.sendRedirect(request, response, targetUrl);
      }
      //직접 로그인 화면으로 이동했을 경우
      else
      {
          String defualtUrl = "";
          redirectStratgy.sendRedirect(request, response, defaultUrl);
      }
      
      //redirectStratgy.sendRedirect() : 화면 이동을 위해 redirectStratgy 의 sendRedirect 를 재정의
  }
  
  //로그인 실패 세션 지우기
  //로그인에 실패해도 세션이 생긴다.
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

      clearAuthenticationAttributes(request);
  }
  
  protected void clearAuthenticationAttributes(HttpServletRequest request) {
      HttpSession session = request.getSession(false);
      if(session==null) return;
      
      session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}

출처: https://to-dy.tistory.com/94 [todyDev]
