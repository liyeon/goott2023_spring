package com.tech.sprj09.vopage;

public class PageVo { // 페이징 처리를 위한 VO 일
	private Integer displayRowCount = 5; // 한 페이지 출력할 데이터 개수
	private Integer grpPageCnt = 3; //// 페이지그룹에서 페이지갯수 수정 ***
	private Integer rowStart; // 시작행번호
	private Integer rowEnd; // 종료행 번호
	private Integer totPage; // 전체 페이수
	private Integer totRow = 0; // 전체 데이터 수
	private Integer page; // 현재 페이지
	private Integer pageStart; // 시작페이지
	private Integer pageEnd; // 종료페이지

	/*
	 * 전체 데이터 개수(total)를 이용하여 페이지수 계산.
	 */
	public void pageCalculate(Integer total) {
		getPage();
		totRow = total;
		totPage = (int) (total / displayRowCount); // 전체 갯수 나누기 페이지에 출력할 데이터 갯수

		if (total % displayRowCount > 0) { // 전체갯수와 페이지에 출력할 데이터 갯수를 나눈 나머지가 0보다 크다면
			totPage++;// 전체 갯수 나누기 페이지에 출력할 데이터 갯수를 1씩 늘려준다.
		}

		pageStart = (page - (page - 1) % grpPageCnt);// (시작 페이지 = 현재페이지 - (현재페이지-1))%페이지 그룹의 페이지갯수
		pageEnd = pageStart + (grpPageCnt - 1);// 종료 페이지 =시작페이지+(페이지그룹의 페이지 갯수 -1)
		if (pageEnd > totPage) { //만약 종료 페이지가 전체 페이지수보다 크다면
			pageEnd = totPage;
		}

		rowStart = ((page - 1) * displayRowCount) + 1;// 시작행번호 = ((현재페이지-1)*한페이지에출력할데이터갯수)+1;
		rowEnd = rowStart + displayRowCount - 1;//종료행번호 = 시작행번호 + 한페이지에 출력할 데이터 갯수
	}

	/*
	 * 현재 페이지 번호.
	 */
	public Integer getPage() {
		if (page == null || page == 0) {// 만약 현재 페이지 값이 없다면 1로 변경해준다.
			page = 1;
		}

		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRowStart() {
		return rowStart;
	}

	public void setRowStart(Integer rowStart) {
		this.rowStart = rowStart;
	}

	public Integer getRowEnd() {
		return rowEnd;
	}

	public void setRowEnd(Integer rowEnd) {
		this.rowEnd = rowEnd;
	}

	public Integer getDisplayRowCount() {
		return displayRowCount;
	}

	public void setDisplayRowCount(Integer displayRowCount) {
		this.displayRowCount = displayRowCount;
	}

	public Integer getTotPage() {
		return totPage;
	}

	public void setTotPage(Integer totPage) {
		this.totPage = totPage;
	}

	public Integer getTotRow() {
		return totRow;
	}

	public void setTotRow(Integer totRow) {
		this.totRow = totRow;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}
}