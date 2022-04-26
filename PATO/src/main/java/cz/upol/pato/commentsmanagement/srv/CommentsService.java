package cz.upol.pato.commentsmanagement.srv;

import cz.upol.pato.commentsmanagement.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;
}
