package com.crio.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "memes")
@NoArgsConstructor
public class MemesEntity {

  public static final String MEME_SEQ = "MEME_IDs";

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
  
  public MemesEntity(String id,String name, String url, String caption) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.caption = caption;
  } 

}
