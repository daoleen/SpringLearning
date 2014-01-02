USE SpringLearning_SpringJdbc;

INSERT INTO `Group` (`id`, `name`, `created_at`) VALUES (1, 'FKSIS', '2010-07-28');
INSERT INTO `Group` (`id`, `name`, `created_at`) VALUES (2, 'FITY', '2003-07-15');
INSERT INTO `Group` (`id`, `name`, `created_at`) VALUES (3, 'FPM', '2001-07-23');

INSERT INTO `Student` (`id`, `group_id`, `first_name`, `last_name`, `age`) VALUES (1, 1, 'ALEX', 'KOZLOV', '23.5');
INSERT INTO `Student` (`id`, `group_id`, `first_name`, `last_name`, `age`) VALUES (2, 1, 'MISHA', 'PUPKIN', '18.5');
INSERT INTO `Student` (`id`, `group_id`, `first_name`, `last_name`, `age`) VALUES (3, 2, 'ALEXEY', 'VOLKOV', '20.5');
INSERT INTO `Student` (`id`, `group_id`, `first_name`, `last_name`, `age`) VALUES (4, 3, 'GLEB', 'FOKUS', '28.5');
INSERT INTO `Student` (`id`, `group_id`, `first_name`, `last_name`, `age`) VALUES (5, 3, 'IVAN', 'VASILEV', '32.5');