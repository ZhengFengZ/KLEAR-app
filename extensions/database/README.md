This project is an KLEAR extension for importing database data using JDBC.
For exporting to a database, other code can be found under folder `KLEAR/main/src/com/google/refine/exporters/sql`

## Adding support for other database vendors

1. You'll want to register an additional Database Service:  https://github.com/KLEAR/KLEAR/blob/master/extensions/database/src/com/google/refine/extension/database/DatabaseService.java
2. Provide the connection and service classes, look at the PostgreSQL one or MySQL one as examples: https://github.com/KLEAR/KLEAR/tree/master/extensions/database/src/com/google/refine/extension/database
3. Then wire up the interface with defaults as desired: https://github.com/KLEAR/KLEAR/blob/master/extensions/database/module/scripts/index/database-source-ui.js#L93
4. Add drivers manually to the classpath, or update the pom file to provide them as dependencies as other DB libraries are done: https://github.com/KLEAR/KLEAR/blob/master/extensions/database/pom.xml
