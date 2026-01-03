
package org.klear.wikibase.qa.scrutinizers;

import java.util.Set;

import org.wikidata.wdtk.datamodel.interfaces.MonolingualTextValue;

import org.klear.wikibase.updates.ItemEdit;
import org.klear.wikibase.updates.LabeledStatementEntityEdit;
import org.klear.wikibase.updates.MediaInfoEdit;

/**
 * @author Lu Liu
 */
public abstract class DescriptionScrutinizer extends EditScrutinizer {

    @Override
    public void scrutinize(ItemEdit update) {
        Set<MonolingualTextValue> descriptions = update.getDescriptions();
        descriptions.addAll(update.getDescriptionsIfNew()); // merge
        for (MonolingualTextValue description : descriptions) {
            String descText = description.getText();
            if (descText == null) {
                continue;
            }
            descText = descText.trim();
            if (descText.length() == 0) {
                continue; // avoid NullPointerException
            }

            scrutinize(update, descText, description.getLanguageCode());
        }
    }

    @Override
    public void scrutinize(MediaInfoEdit update) {
        // no descriptions to scrutinize: do nothing
    }

    public abstract void scrutinize(LabeledStatementEntityEdit update, String descText, String lang);

}
