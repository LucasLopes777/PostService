package com.algaworks.AlgaPosts.PostService.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSummaryOutput {

    private UUID id;
    private String title;
    private String sumary;
    private String author;

}
