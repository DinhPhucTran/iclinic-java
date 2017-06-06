use cms;

insert into user_roles(role, position) values ('ROLE_ADMIN', 'Admin');
insert into user_roles(role, position) values ('ROLE_BS', 'Bác sĩ');
insert into user_roles(role, position) values ('ROLE_YT', 'Y tá');
insert into user_roles(role, position) values ('ROLE_NV', 'Nhân viên');
insert into user_roles(role, position) values ('ROLE_DS', 'Dược sĩ');

insert into user (username, password, full_name, enabled) values ('admin', '$2a$10$d8rnzxcFF8cJsd7Zmzi2UuXI6g.1O4LvwBXv055le1DGwYJhoEzjq', 'Administrator', 1);
insert into user (username, password, full_name, enabled) values ('bacsi', '$2a$10$Nyfnz6hEE3Z6spsLyisgjOGZmYuDTaZbVTB6n4oY2.A2DLPqd6NeG', 'Trần Bác Sĩ', 1);
insert into user (username, password, full_name, enabled) values ('yta', '$2a$10$itvgwj7eTKz2HKQdaBnTKuQYLizrr8etD3Oq17mleJ3VBw/n4iyba', 'Nguyễn Y Tá', 1);
insert into user (username, password, full_name, enabled) values ('duocsi', '$2a$10$k0/Wl3Zo.uJLWq6ChdotCOsrML5aUf7ySS2PCBiOlbC3rbmUYB5PC', 'Vũ Dược Sĩ', 1);
insert into user (username, password, full_name, enabled) values ('nhanvien', '$2a$10$iN3LrkcTLThxJ/KM7sNQrOAPSWpdyet8nmu2O5u59zPhoPdX3LYCi', 'Lê Nhân Viêni', 1);

SET GLOBAL max_allowed_packet=1073741824;