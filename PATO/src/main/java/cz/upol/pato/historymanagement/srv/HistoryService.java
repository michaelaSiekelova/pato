package cz.upol.pato.historymanagement.srv;

import cz.upol.pato.historymanagement.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private EventsRepository eventsRepository;
}
