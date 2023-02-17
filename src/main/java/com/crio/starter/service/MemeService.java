package com.crio.starter.service;

import com.crio.starter.exchange.GetListOfMemesResponse;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.exchange.PostMemeResquest;

public interface MemeService {

    GetListOfMemesResponse fetchLatestMemes();
    PostMemeResponse createNewMeme(PostMemeResquest postMemeResquest);
    GetMemeResponse fetchMemeById(String id);
}
