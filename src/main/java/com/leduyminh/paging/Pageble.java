package com.leduyminh.paging;

import com.leduyminh.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer GetLimit();
	Sorter getSorter();
}
