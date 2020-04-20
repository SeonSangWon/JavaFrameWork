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
