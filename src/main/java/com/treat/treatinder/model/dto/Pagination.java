package com.treat.treatinder.model.dto;

import lombok.Data;

@Data
public class Pagination {
    private int countPerPage;
    private long totalCount;
    private int currentPage;
    private int totalPages;
}