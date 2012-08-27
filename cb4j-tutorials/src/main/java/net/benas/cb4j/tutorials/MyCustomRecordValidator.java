package net.benas.cb4j.tutorials;

import net.benas.cb4j.core.api.FieldValidator;
import net.benas.cb4j.core.impl.RecordValidatorImpl;
import net.benas.cb4j.core.model.Record;

import java.util.List;
import java.util.Map;

/**
 * A custom validator to implement validation rule that involve multiple fields at the same time
 * @author benas (md.benhassine@gmail.com)
 */
public class MyCustomRecordValidator extends RecordValidatorImpl {

    public MyCustomRecordValidator(Map<Integer, List<FieldValidator>> fieldValidators) {
        super(fieldValidators);
    }

    @Override
    public String validateRecord(Record record) {

        String error = super.validateRecord(record);
        if (error.isEmpty()){//no errors after applying declared validators on each field => all fields are valid

            //add custom validation : field 2 content must starts with field 1 content
            final String content1 = record.getContentByIndex(1);
            final String content2 = record.getContentByIndex(2);
            if (!content2.startsWith(content1))
                return "field 2 content [" + content2 + "] must start with field 1 content [" + content1 + "]";
        }
        return "";
    }
}