package com.kh.mvc.model.vo;

import lombok.Getter;

@Getter
public class Paging {
  // 프론트 단 페이징 처리 
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int num = 10; // 한 페이지에 보여줄 버튼 갯수(화면 하단에 페이지) 
	
	private int total;
	private Criteria cri;
	
	public Paging(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage  = (int)Math.ceil((double)cri.getPage()  / this.num) * this.num;
		this.startPage = this.endPage  - this.num +1;
	
		
		                // 소주점이 나오면 한 페이지 더 추가 해줘야 하기 때문에 double로 지정
		int lastPage =(int) Math.ceil((double) total / cri.getAmount());
		
		if(lastPage <this.endPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage >1;
		this.next = this.endPage <lastPage;
	}
	
}
