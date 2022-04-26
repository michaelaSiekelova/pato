package cz.upol.pato.attachementsmanagement.srv;

import cz.upol.pato.attachementsmanagement.repository.AttachementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachementsService {

    @Autowired
    private AttachementsRepository attachementsRepository;
}
