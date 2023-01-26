package com.dumiduh.utils;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord logRecord) {
        return logRecord.getSourceClassName()+" :: "
                +logRecord.getSourceMethodName()+" :: "
                +new Date(logRecord.getMillis())+" :: "
                +logRecord.getMessage()+"\n";
    }
}
