package com.crio.starter.service;

import java.util.Objects;
import com.crio.starter.models.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {
    
    @Autowired private MongoOperations mongoOperations;

    public int generateSequence(String seqName) {
        Sequence counter = mongoOperations.findAndModify(Query.query(Criteria.where("id").is(seqName)),
                new Update().inc("seq",1), FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class);
        return (!Objects.isNull(counter) ? counter.getSeq() : 1);
    }
}


