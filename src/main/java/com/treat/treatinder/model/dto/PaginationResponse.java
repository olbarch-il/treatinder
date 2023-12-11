package com.treat.treatinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponse {
    private int countPerPage;
    private long totalCount;
    private int currentPage;
    private int totalPages;
    private String nextPage;
}