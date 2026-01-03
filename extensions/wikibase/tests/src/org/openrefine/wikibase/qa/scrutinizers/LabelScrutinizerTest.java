
package org.klear.wikibase.qa.scrutinizers;

import org.apache.poi.util.StringUtil;
import org.testng.annotations.Test;
import org.wikidata.wdtk.datamodel.helpers.Datamodel;

import org.klear.wikibase.testing.TestingData;
import org.klear.wikibase.updates.MediaInfoEdit;
import org.klear.wikibase.updates.MediaInfoEditBuilder;

public class LabelScrutinizerTest extends ScrutinizerTest {

    @Override
    public EditScrutinizer getScrutinizer() {
        return new LabelScrutinizer();
    }

    @Test
    public void testTooLong() {
        String labelText = StringUtil.repeat('.', 251);
        MediaInfoEdit update = new MediaInfoEditBuilder(TestingData.newIdA)
                .addLabel(Datamodel.makeMonolingualTextValue(labelText, "en"), true)
                .addContributingRowId(123)
                .build();
        scrutinize(update);
        assertWarningsRaised(LabelScrutinizer.labelTooLongType);
    }
}
