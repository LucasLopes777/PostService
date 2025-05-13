package com.algaworks.AlgaPosts.PostService.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PostProcessingResult {

    private UUID postId;
    private Integer wordCount;
    private BigDecimal calculatedValue;
}
