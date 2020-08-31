package com.bachhpan.frontend.utils.date;

import org.joda.time.DateTime;

import static org.joda.time.DateTimeZone.UTC;

public interface DateService {
    DateService DATES = new JodaDateService(UTC);

    DateTime now();
}
