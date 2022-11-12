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