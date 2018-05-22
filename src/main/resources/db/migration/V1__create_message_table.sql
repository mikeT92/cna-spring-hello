CREATE TABLE t_message (
	id 						UUID NOT NULL,
	code 					VARCHAR(32) NOT NULL,
	locale 					VARCHAR(8) NOT NULL,
	text 					VARCHAR(256) NOT NULL,
	opt_lock_version        BIGINT NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX pk_message_id ON t_message ( id );
CREATE UNIQUE INDEX i_message_natural_id ON t_message ( code, locale );

ALTER TABLE t_message ADD PRIMARY KEY USING INDEX pk_message_id;
ALTER TABLE t_message ADD UNIQUE USING INDEX i_message_natural_id;
