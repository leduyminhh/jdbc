package com.leduyminh.paging;

import com.leduyminh.sort.Sorter;

public class PageRequest implements Pageble{
	private Integer page;
	private Integer maxpageItem;
	private Sorter sorter; 
	public  PageRequest(Integer page, Integer maxpageItem,Sorter sorter) {
		this.page = page;
		this.maxpageItem = maxpageItem;
		this.sorter = sorter;
	}
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(this.page!=null && this.maxpageItem!=null)
		{
			return (this.page-1) * maxpageItem;
		}
		else return null;
	}

	@Override
	public Integer GetLimit() {
		return this.maxpageItem;
	}
	public Sorter getSorter() {
		if(this.sorter != null)
			return this.sorter;
		return null;
	}

}
