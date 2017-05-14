CREATE TABLE building
(
  id serial NOT NULL,
  name character varying(100),
  "number" character varying(50),
  road_id integer,
  parcel_id integer,
  geom geometry,
  CONSTRAINT building_pkey PRIMARY KEY (id)
);

