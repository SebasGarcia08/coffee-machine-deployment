# Coffe machine deployment

# Members

Group: avengers

* Sebastián García Acosta 
* 
* 
* 
*
*


## Getting started 

# Requirements

* Java

* Zeroc ICE

* Postgres 

* Oracle BD


# Configuration

* xhgrid 10: DB postgres server

user: postgres
password: postgres

user: "avengers"
password: "cofmachpwd"
database name: "coffeemachine_avengers"

1. Create database in xhgrid2 with this command

'''bash
psql -h xhgrid2 -U postgres -c "\i scripts/postgres/coffeemach-user.sql"
'''

2. Execute scripts in order to create tables in the database

'''bash
psql -h xhgrid2 -U avengers -d coffeemachine_avengers -c "\i scripts/postgres/coffeemach-ddl.sql"
'''

3. Insert new rows in the created tables

'''bash
psql -h xhgrid2 -U avengers -d coffeemachine_avengers -c "\i scripts/postgres/coffeemach-inserts.sql"
'''


4. Compile the project 

'''bash
# Cd into src_postgres folder
cd coffe-machine-deployment/java-components/coffeemach/src_postgres/

# Compile 
gradle --build-file build.gradle

# If above does not work, then try with the wrapper
./gradlew build
'''

