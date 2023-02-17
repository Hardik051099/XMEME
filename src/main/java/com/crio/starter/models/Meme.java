package com.crio.starter.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meme {

    @JsonIgnore
    @Id
    private String _id;
    
    @NotNull
    private String id;
  
    @NotNull
    private String name;
  
    @NotNull
    private String url;
  
    @NotNull
    private String caption;
}
