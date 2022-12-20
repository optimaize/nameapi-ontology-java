package org.nameapi.ontology5.input.entities.person.age;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AgeUtil {

    private static final Logger log = LoggerFactory.getLogger(AgeUtil.class);

    /**
     * Check <a href="https://redmine.nameprofiler.com/issues/19271">this</a> task.
     */
    static void checkYear(int year) {
        if (year < 0 || year > 2100) {
            log.warn("Birth year >>>{}<<< is not in proper range [0; 2100]!", year);
        }
    }

}
