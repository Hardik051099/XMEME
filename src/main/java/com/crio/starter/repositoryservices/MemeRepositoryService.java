package com.crio.starter.repositoryservices;

import java.util.List;
import com.crio.starter.data.MemesEntity;

public interface MemeRepositoryService {
    List<MemesEntity> getLatestMemes();
    MemesEntity createNewMeme(String name, String url, String caption);
    MemesEntity fetchMemeById(String id);
}
