select * from study_type;
select * from formatted_text;
select * from user;
select * from module;
select * from access_type;
select * from collection;
select * from flash_card;
select * from score;

INSERT INTO `demo_cp`.`study_type` (`study_type_name`) VALUES ('orally');
INSERT INTO `demo_cp`.`study_type` (`study_type_name`) VALUES ('writing');
# -------------------------------------------------------------------------------

INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('ape');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('an animal like a large monkey with no tail, that uses its arms to move through trees:');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('art');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('the making of objects, images, music, etc. that are beautiful or that express feelings');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('background');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('the things that can be seen behind the main things or people in a picture');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('brush');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('an object with short pieces of stiff hair, plastic, or wire attached to a base or handle, used for cleaning, arranging your hair, or painting');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('collect');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('to get and keep things of one type such as stamps or coins as a hobby');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('behaviour');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('the way that someone behaves');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('bull');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('a male cow, or the male of particular animals such as the elephant or the whale');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('camel');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('a large animal with a long neck, that lives in the desert and has one or two humps (= large raised areas of flesh) on its back');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('ancient');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('of or from a long time ago, having lasted for a very long time');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('architecture');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('the art and practice of designing and making buildings');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('castle');
INSERT INTO `demo_cp`.`formatted_text` (`text`) VALUES ('a large strong building, built in the past by a ruler or important person to protect the people inside from attack');

# --------------------------------------------------------

INSERT INTO `demo_cp`.`user` (`email`, `enable`, `password`, `user_name`) VALUES ('user@gmail.com', 1, 'fdas321fdf234233', 'user');
INSERT INTO `demo_cp`.`user` (`email`, `enable`, `password`, `user_name`) VALUES ('teacher.pin@gmail.com', 1, '21hiuhf7wyfh23hu', 'teacher');

# ------------------------------------------------------------------------------

INSERT INTO `demo_cp`.`access_type` (`access`) VALUES ('private');
INSERT INTO `demo_cp`.`access_type` (`access`) VALUES ('public');

# ------------------------------------------------------------------------------

INSERT INTO `demo_cp`.`module` (`module_name`, `access_type`, `user`) VALUES ('english words', '1', '1');
INSERT INTO `demo_cp`.`module` (`module_name`, `access_type`, `user`) VALUES ('vocabulary b1', '1', '2');

# ------------------------------------------------------------------------------

INSERT INTO `demo_cp`.`collection` (`collection_name`, `module`) VALUES ('culture topic', '1');
INSERT INTO `demo_cp`.`collection` (`collection_name`, `module`) VALUES ('animals', '2');
INSERT INTO `demo_cp`.`collection` (`collection_name`, `module`) VALUES ('buildings', '2');

# -------------------------------------------------------------------------------

INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('1', '2', '2');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('3', '4', '1');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('5', '6', '1');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('7', '8', '1');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('9', '10', '1');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('11', '12', '2');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('13', '14', '2');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('15', '16', '2');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('17', '18', '3');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('19', '20', '3');
INSERT INTO `demo_cp`.`flash_card` (`back_side`, `front_side`, `collection`) VALUES ('21', '22', '3');

# ----------------------------------------------------------

INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 1 day), '45', '2', '1');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 2 day), '95', '2', '2');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 3 day), '80', '2', '3');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 4 day), '70', '2', '4');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 5 day), '100', '2', '5');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 6 day), '100', '2', '6');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 7 day), '95', '2', '1');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 8 day), '95', '2', '8');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 9 day), '90', '1', '9');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 10 day), '100', '2', '5');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 11 day), '80', '1', '1');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 12 day), '50', '1', '1');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 13 day), '10', '1', '2');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 14 day), '35', '2', '6');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 15 day), '75', '2', '7');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 16 day), '80', '2', '8');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 17 day), '50', '2', '3');
INSERT INTO `demo_cp`.`score` (`date`, `score`, `study_type`, `flash_card`) VALUES (DATE_SUB(now(), interval 18 day), '60', '2', '11');

# ---------------------------------------------------






























