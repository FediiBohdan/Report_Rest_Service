create schema andersen;

create table if not exists andersen.login
(
	id bigserial not null
		constraint login_pkey
			primary key,
	nickname varchar(20),
	password varchar(20)
);

create table if not exists andersen.user
(
	id bigserial not null
		constraint user_pkey
			primary key,
	name varchar(30),
	surname varchar(30),
	patronymic varchar(30),
	email varchar(254),
	login_id bigint
		constraint user_login_id_fkey
			references login,
	dateoflastupdate timestamp,
	dateofcreation timestamp,
	isdeleted boolean
);

create table if not exists andersen.report
(
	id bigserial not null
		constraint report_pkey
			primary key,
	user_id bigint
		constraint report_user_id_fkey
			references user,
	dateofreport timestamp,
	report text
);

