/**
 * GET 방식으로 값을 전달하는 방법 입니다.
 * @param vo
 * @return
 * @throws Exception
 */
  @ResponseBody
  @RequestMapping(value = "/searchGet.do", method = RequestMethod.GET)
  public Object searchGet(ChagyebuVO vo) throws Exception {
    //Debug    
    LOGGER.info(vo.toString());
    
    Map<String, Object> object = new HashMap<String, Object>();
    object.put("list", chagyebuService.selectChagyebuList(vo));

    return object;
  }

  @ResponseBody
  @RequestMapping(value = "/login.do", method = RequestMethod.POST)
  public Object loginAjax(MemberDTO memberDTO) throws Exception {
    //Debug    
    LOGGER.info(vo.toString());
    
    Map<String, Object> object = new HashMap<String, Object>();
    int result = 0;
    
    if(result > 0)
      object.put("responseCode", "success");
    else
      object.put("responseCode", "error");

    return object;
  }
