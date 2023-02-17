#!/bin/bash

mongoimport --db Xmeme --collection memes --drop --jsonArray --file ./sample-memes.json
mongoimport --db Xmeme --collection sequence --drop --jsonArray --file ./sample-sequence.json

