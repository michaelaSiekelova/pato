package cz.upol.pato.ticketmanagement.enums;

import java.util.Arrays;
import java.util.List;

public class TicketEnums {
    public enum TicketType {
        TASK,
        BUG;
    }

    public static List<TicketType> getTicketTypes(){
        return Arrays.asList(TicketType.values());
    }
}
