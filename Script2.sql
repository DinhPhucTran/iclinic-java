use cms;

insert into user_roles(role, position) values ('ROLE_ADMIN', 'Admin');
insert into user_roles(role, position) values ('ROLE_BS', 'Bác sĩ');
insert into user_roles(role, position) values ('ROLE_YT', 'Y tá');
insert into user_roles(role, position) values ('ROLE_NV', 'Nhân viên');
insert into user_roles(role, position) values ('ROLE_DS', 'Dược sĩ');

SET GLOBAL max_allowed_packet=1073741824;