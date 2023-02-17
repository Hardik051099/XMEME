package com.crio.starter.service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Provider;
import com.crio.starter.data.MemesEntity;
import com.crio.starter.exchange.GetListOfMemesResponse;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.exchange.PostMemeResquest;
import com.crio.starter.models.Meme;
import com.crio.starter.repositoryservices.MemeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemeServiceImpl implements MemeService{

  // private final MemeRepository MemeRepository;
  @Autowired
  private final MemeRepositoryService memeRepositoryService;
  @Autowired
  private Provider<ModelMapper> modelMapperProvider;
  

  @Override
  public GetListOfMemesResponse fetchLatestMemes() {
    List<MemesEntity> memesEntityList = memeRepositoryService.getLatestMemes();

    List<Meme> memesList = memesEntityList.stream().map(meme -> {
      return modelMapperProvider.get().map(meme,Meme.class);
    }).collect(Collectors.toList());
    return new GetListOfMemesResponse(memesList);
  }


  @Override
  public PostMemeResponse createNewMeme(PostMemeResquest postMemeResquest) {
    String name = postMemeResquest.getName();
    String url = postMemeResquest.getUrl();
    String caption = postMemeResquest.getCaption();
    
    MemesEntity meme = memeRepositoryService.createNewMeme(name,url,caption);

    return new PostMemeResponse(meme.getId());
  }


  @Override
  public GetMemeResponse fetchMemeById(String id) {

    MemesEntity memeEntity = memeRepositoryService.fetchMemeById(id);
    Meme meme = modelMapperProvider.get().map(memeEntity,Meme.class);
    return new GetMemeResponse(meme);
  }

  

}
