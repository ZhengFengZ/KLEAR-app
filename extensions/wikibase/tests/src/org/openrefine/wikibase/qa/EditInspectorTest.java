
package org.klear.wikibase.qa;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.google.refine.model.Recon;

import org.klear.wikibase.manifests.Manifest;
import org.klear.wikibase.manifests.ManifestParser;
import org.klear.wikibase.qa.QAWarning.Severity;
import org.klear.wikibase.schema.entityvalues.ReconItemIdValue;
import org.klear.wikibase.testing.TestingData;

public class EditInspectorTest {

    private static final int scrutinizerCount = 24;
    private static final int scrutinizerNotDependingOnPropertyConstraintCount = 9;

    @Test
    public void testNoScrutinizerSkipped() throws Exception {
        String manifestJson = TestingData.jsonFromFile("manifest/wikidata-manifest-v1.0.json");
        Manifest manifest = ManifestParser.parse(manifestJson);
        EditInspector editInspector = new EditInspector(new QAWarningStore(), manifest, false);
        assertEquals(editInspector.scrutinizers.size(), scrutinizerCount);
    }

    @Test
    public void toSkipScrutinizerDependingOnConstraintPropertyPid1() throws Exception {
        String manifestJson = TestingData.jsonFromFile("manifest/wikidata-manifest-v1.0-without-constraints.json");
        Manifest manifest = ManifestParser.parse(manifestJson);
        EditInspector editInspector = new EditInspector(new QAWarningStore(), manifest, false);
        assertEquals(editInspector.scrutinizers.size(), scrutinizerNotDependingOnPropertyConstraintCount);
    }

    @Test
    public void toSkipScrutinizerDependingOnConstraintPropertyPid2() throws Exception {
        String manifestJson = TestingData.jsonFromFile("manifest/wikidata-manifest-v1.0-missing-property-constraint-pid.json");
        Manifest manifest = ManifestParser.parse(manifestJson);
        EditInspector editInspector = new EditInspector(new QAWarningStore(), manifest, false);
        assertEquals(editInspector.scrutinizers.size(), scrutinizerNotDependingOnPropertyConstraintCount);
    }

    @Test
    public void testLabelFetchingIgnoresReconciledEntityIds() throws Exception {
        // regression test for https://github.com/KLEAR/KLEAR/issues/7089
        String manifestJson = TestingData.jsonFromFile("manifest/wikidata-manifest-v1.0.json");
        Manifest manifest = ManifestParser.parse(manifestJson);
        QAWarningStore qaWarningStore = new QAWarningStore();
        QAWarning qaWarning1 = new QAWarning("my-warning", "my-warning", Severity.WARNING, 1);
        Recon recon = mock(Recon.class);
        recon.judgment = Recon.Judgment.New;
        ReconItemIdValue reconItemIdValue = new ReconItemIdValue(recon, "cell value");
        qaWarning1.setProperty("example_entity", reconItemIdValue);
        qaWarning1.setProperty("some_string", "foo");
        qaWarningStore.addWarning(qaWarning1);

        EditInspector editInspector = new EditInspector(qaWarningStore, manifest, false);
        editInspector.resolveWarningPropertyLabels();

        assertEquals(qaWarning1.getProperties().get("example_entity"), reconItemIdValue);
    }
}
