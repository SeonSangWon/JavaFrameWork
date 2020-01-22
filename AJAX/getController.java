/**
 * GET 방식으로 값을 전달하는 방법 입니다.
 * @param vo
 * @return
 * @throws Exception
 */
  @RequestMapping(value = "/searchGet.do", method = RequestMethod.GET)
  public @ResponseBody Map<String, Object> searchGet(ChagyebuVO vo) throws Exception {
  
    //searchGet(ChagyebuVO vo) 에서 ChagyebuVO 객체에 자동으로 맵핑
    //Debug    
    LOGGER.info(vo.toString());

    return chagyebuService.selectChagyebuList(vo);
  }
