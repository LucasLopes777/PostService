package com.algaworks.AlgaPosts.PostService.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInput {

    private String title;
    private String body;
    private String author;
}
