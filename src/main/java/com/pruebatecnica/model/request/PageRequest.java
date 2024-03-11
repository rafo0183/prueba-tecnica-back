package com.pruebatecnica.model.request;

import java.util.List;

public class PageRequest {
	Integer currentPage;
    Integer rowsPerPage;
    Integer totalRows;
    Integer maxPages;
    List<Object> results;
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
