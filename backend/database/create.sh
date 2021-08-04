#!/bin/bash
BASEDIR=$(dirname $0)
DATABASE=final_capstone
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema2.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
