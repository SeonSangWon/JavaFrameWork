@Override
@Transactional
public Map<String, Object> selectChagyebuList(ChagyebuVO vo) throws Exception {
	Map<String, Object> map = new HashMap<String, Object>();
	
	final int dataPerPage = 10;
	int page = vo.getPage();
	
	int first = page * dataPerPage + 1;
	int last = first + dataPerPage - 1;
	
	vo.setFirst(first);
	vo.setLast(last);
	
	LOGGER.info(vo.toString());
	
	Integer total = chagyebuDAO.selectChagyebuTotal(vo);
	Integer totalPages = (int)Math.ceil(total / dataPerPage);
	
	map.put("total", total);
	map.put("totalPages", totalPages);
	map.put("list", chagyebuDAO.selectChagyebuList(vo));
	
	return map;
}
