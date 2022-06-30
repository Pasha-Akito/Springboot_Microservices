package guru.springframework.msscbeerservice.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {

    //Convert a java.sql.Timestamp to java.time.OffsetDateTime
    public OffsetDateTime asOffsetDateTime(Timestamp ts) {
        if (ts != null) {
            return OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue()
                    , ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(),
                    ts.toLocalDateTime().getMinute(), ts.toLocalDateTime().getSecond(), ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }
    }

    //Convert a java.time.OffsetDateTime to java.sql.Timestamp
    public Timestamp asTimestamp(OffsetDateTime odt) {
        if (odt != null) {
            return Timestamp.valueOf(odt.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        } else {
            return null;
        }
    }

}
