package com.crio.starter.repositoryservices;

import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import com.crio.starter.data.MemesEntity;
import com.crio.starter.repository.MemeRepository;
import com.crio.starter.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemeRepositoryServiceImpl implements MemeRepositoryService {

      @Autowired
      private final MemeRepository memeRepository;
      @Autowired
      private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<MemesEntity> getLatestMemes() {
        Pageable pageable = PageRequest.of(0, 100, Sort.by("_id").descending());
        List<MemesEntity> memesList = memeRepository.findLatest100Memes(pageable).orElse(new ArrayList<>());
        return memesList;
    }

    @Override
    public MemesEntity createNewMeme(String name, String url, String caption) {
        String id;
        //check if already exists
        MemesEntity newMeme;
        newMeme = memeRepository.findByNameAndCaptionAndUrl(name, caption, url).orElse(null);
        if(newMeme == null){
            //Generate unique Id
            id = sequenceGeneratorService.generateSequence(MemesEntity.MEME_SEQ)+"";
            newMeme = memeRepository.save(new MemesEntity(id,name,url,caption));
            return newMeme;
        }
        return new MemesEntity();
    }

    @Override
    public MemesEntity fetchMemeById(String id) {
        return memeRepository.findMemeById(id).orElse(new MemesEntity());
    }
    
}
