package cz.upol.pato.historymanagement.ctrl;

import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import cz.upol.pato.ticketmanagement.ctrl.TicketManagementController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/historyManagement")
public class HistoryController {
    private static final Logger log = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    private MapStructMapper mapstructMapper;
}
