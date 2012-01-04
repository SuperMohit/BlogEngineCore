# Ajout de trois utilisateurs dans la base de test
insert into user (USER_NAME,USER_PASSWORD) values ('laurent','s3cr3t');
insert into user (USER_NAME,USER_PASSWORD) values ('fabien','p@ssw0rd');
insert into user (USER_NAME,USER_PASSWORD) values ('jean','r@bb1t');

# Ajout de 5 articles par utilisateur
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Premier article de laurent','Premier contenu de Laurent',CURDATE(),CURDATE(),1);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Deuxieme article de laurent','Deuxieme contenu de Laurent',CURDATE(),CURDATE(),1);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Troisieme article de laurent','Troisieme contenu de Laurent',CURDATE(),CURDATE(),1);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Quatrieme article de laurent','Quatrieme contenu de Laurent',CURDATE(),CURDATE(),1);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Cinquieme article de laurent','Cinquieme contenu de Laurent',CURDATE(),CURDATE(),1);

insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Premier article de fabien','Premier contenu de fabien',CURDATE(),CURDATE(),2);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Deuxieme article de fabien','Deuxieme contenu de fabien',CURDATE(),CURDATE(),2);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Troisieme article de fabien','Troisieme contenu de fabien',CURDATE(),CURDATE(),2);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Quatrieme article de fabien','Quatrieme contenu de fabien',CURDATE(),CURDATE(),2);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Cinquieme article de fabien','Cinquieme contenu de fabien',CURDATE(),CURDATE(),2);

insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Premier article de jean','Premier contenu de jean',CURDATE(),CURDATE(),3);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Deuxieme article de jean','Deuxieme contenu de jean',CURDATE(),CURDATE(),3);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Troisieme article de jean','Troisieme contenu de jean',CURDATE(),CURDATE(),3);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Quatrieme article de jean','Quatrieme contenu de jean',CURDATE(),CURDATE(),3);
insert into post (POST_TITLE,POST_CONTENT,POST_CREATED,POST_MODIFIED,USER_ID) values ('Cinquieme article de jean','Cinquieme contenu de jean',CURDATE(),CURDATE(),3);