describe(__filename, function () {
  afterEach(() => {
    cy.addProjectForDeletion();
  });
  
  it('Check the layout for importing a project', function () {
    cy.visitKLEAR();
    cy.navigateTo('Import project');
    cy.get('.grid-layout').contains('Locate an existing Refine project file');
  });

  it('Import a project', function () {
    cy.visitKLEAR();
    cy.navigateTo('Import project');
    // make sure the dataset was loaded properly
    cy.get('#project-upload-form input#project-tar-file-input').selectFile(
      'cypress/fixtures/food-small-csv.klear.tar.zip'
    );
    cy.get('#project-upload-form').submit();

    cy.waitForProjectTable(199);
    // ensure is loaded
    cy.get('div[bind="summaryBarDiv"]').contains('199 rows');
  });

  it('Import a project, test the renaming', function () {
    cy.visitKLEAR();
    cy.navigateTo('Import project');
    // make sure the dataset was loaded properly
    cy.get('#project-upload-form input#project-tar-file-input').selectFile(
      'cypress/fixtures/food-small-csv.klear.tar.zip'
    );

    // rename
    const projectName = Date.now();
    cy.get('#project-name-input').type(projectName);
    cy.get('#project-upload-form').submit();

    cy.waitForProjectTable();
    cy.get('#project-name-button').contains(projectName);
  });

  it('Import a project from URL', function () {
    cy.visitKLEAR();
    cy.navigateTo('Import project');
    const url = "https://raw.githubusercontent.com/KLEAR/KLEAR/master/main/tests/cypress/cypress/fixtures/food-small-csv.klear.tar.zip";
    cy.get('#or-import-url').type(url);
    cy.get('#project-upload-form').submit();

    cy.waitForProjectTable(199);
    cy.get('div[bind="summaryBarDiv"]').contains('199 rows');
  });

  it('Delete a file', function () {
    cy.visitKLEAR();
    
    const projectFile = 'cypress/fixtures/food-small-csv.klear.tar.zip';
    cy.get('#project-upload-form input#project-tar-file-input').selectFile(
      projectFile, {force: true}
    );
    cy.get('#project-tar-file-delete').click({force: true});

    // Verify the project has been deleted
    cy.get('#project-tar-file-input').should('not.contain', projectFile);
  });
});
