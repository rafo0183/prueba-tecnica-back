package com.pruebatecnica.model.response;

import java.util.List;

import com.pruebatecnica.model.request.PageRequest;

public class PageResponse {
	Integer currentPage;
    Integer rowsPerPage;
    Integer totalRows;
    Integer maxPages;
    List results;
    public PageResponse() {
    	
    }
	public PageResponse(PageRequest pageRequest, List<Object> results) {
		this.currentPage = pageRequest.getCurrentPage();
		this.rowsPerPage = pageRequest.getRowsPerPage();
		this.totalRows = pageRequest.getTotalRows();
		if(pageRequest.getRowsPerPage()!=0) {
			this.maxPages = (int) Math.ceil((float) pageRequest.getTotalRows() / (float) pageRequest.getRowsPerPage());
		}else {
			this.maxPages = 1;
		}
		this.results = results;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public List<Object> getResults() {
		return results;
	}
	public void setResults(List<Object> results) {
		this.results = results;
	}
	public Integer getMaxPages() {
		return maxPages;
	}
	public void setMaxPages(Integer maxPages) {
		this.maxPages = maxPages;
	}
	
}
