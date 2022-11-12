create user avengers with password 'cofmachpwd';
create database coffeemachine_avengers owner avengers;
grant connect on database coffeemachine_avengers to avengers;

-- Connection
-- psql -d coffeemachine -U p09713_1_2
