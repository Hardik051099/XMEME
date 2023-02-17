package com.crio.starter.exchange;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import javax.validation.constraints.NotNull;
import com.crio.starter.models.Meme;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListOfMemesResponse {
    @NotNull
    private List<Meme> memesList;
}
