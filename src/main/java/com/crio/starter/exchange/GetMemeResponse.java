package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import com.crio.starter.models.Meme;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMemeResponse {

    @NotNull
    private Meme meme;

    public String getId() {
        return meme.getId();
    }
    
    public String getName() {
        return meme.getName();
    }
    
    public String getUrl() {
        return meme.getUrl();
    }
    
    public String getCaption() {
        return meme.getCaption();
    }
    
}
