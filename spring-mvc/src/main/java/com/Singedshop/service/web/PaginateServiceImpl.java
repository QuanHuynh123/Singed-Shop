package com.Singedshop.service.web;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.PaginateDTO;
import com.Singedshop.service.web.Interface.IPaginateService;

@Service
public class PaginateServiceImpl implements IPaginateService {

	public PaginateDTO getInforPaginate(int totalData, int limit, int currentPage) {
		PaginateDTO paginate = new PaginateDTO();
		paginate.setLimit(limit);;
		paginate.setTotalPage(SetInfoTotalPage(totalData, limit));
		paginate.setCurrentPage(CheckCurrentPage(currentPage ,paginate.getTotalPage()));
		int start = FindStart(paginate.getCurrentPage(), limit);
		paginate.setStart(start);
		int end = FindEnd(paginate.getStart(), limit, totalData);
		paginate.setEnd(end);
		return paginate;
	}

	private int FindEnd(int start, int limit, int totalData) {
		return (start + limit) > totalData ? totalData : ((start + limit) -1);
	}

	private int FindStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit) + 1;
	}

	private int SetInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? (totalPage + 1) : totalPage;
		return totalPage;
	}
	
	public int CheckCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
	
}
