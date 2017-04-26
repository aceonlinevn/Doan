DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_user_rate_avg` $$

CREATE PROCEDURE sp_user_rate_avg (IN i_userid int, IN i_user_rate int, OUT o_user_rate_avg float)
BEGIN 
	DECLARE total int;
    SELECT user_vote_product_total into @total FROM user WHERE user_id = i_userid;
	UPDATE user
    SET user_rate_avg = (user_rate_avg*total + i_user_rate)/(total+1)
    , user_vote_product_total =  total + 1
    WHERE user_id = i_userid;
    SELECT user_rate_avg into o_user_rate_avg FROM user WHERE user_id = i_userid;
END $$
DELIMITER ;

Call sp_user_rate_avg(3,3,@a);

SELECT @a;

DELIMITER $$
DECLARE id int;
    SELECT count(*) INTO @id FROM user_rate WHERE user_id = 1 AND product_id=2;
SELECT @id

INSERT INTO `dacn_webbanhang`.`user_rate` (`user_id`, `product_id`, `user_rate_point`, `user_rate_comment`) VALUES ('1', '1', '1', 'abc');

DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_user_rate` $$
CREATE PROCEDURE sp_user_rate (IN i_userid char(20), IN i_product_id int, IN i_user_rate_point int,i_user_rate_comment TEXT)
BEGIN 
	DECLARE rate_count int;
	DECLARE rate_avg_count int;
    DECLARE rate_old int;
    SELECT count(*) into @rate_count FROM user_rate WHERE user_id = i_userid AND product_id=i_product_id;
    SELECT count(*) into @rate_avg_count FROM user_rate_avg WHERE user_id = i_userid;
    -- product have already, update
	IF(@rate_count > 0)
	THEN
		SELECT user_rate_point INTO @rate_old FROM user_rate WHERE user_id = i_userid AND product_id=i_product_id;
		UPDATE user_rate
		SET user_rate_point = i_user_rate_point,user_rate_comment = i_user_rate_comment
        WHERE user_id = i_userid AND product_id=i_product_id;
    ELSE
		INSERT INTO `dacn_webbanhang`.`user_rate` (`user_id`, `product_id`, `user_rate_point`, `user_rate_comment`) VALUES (i_userid, i_product_id, i_user_rate_point, i_user_rate_comment);
	END IF;
    -- update user_rate_avg
    IF(@rate_avg_count >0 AND @rate_count = 0)
    THEN
    
		UPDATE user_rate_avg
        SET user_rate_avg = (user_rate_avg*user_rate_total + i_user_rate_point)/(user_rate_total+1)
    , user_rate_total =  user_rate_total + 1
    WHERE user_id = i_userid;
	else if(@rate_avg_count >0 AND @rate_count > 0)
    THEN
    UPDATE user_rate_avg
        SET user_rate_avg = (user_rate_avg*user_rate_total - @rate_old+i_user_rate_point)/(user_rate_total)
        WHERE user_id = i_userid;
    ELSE
    INSERT INTO user_rate_avg (`user_id`, `user_rate_avg`, `user_rate_total`) VALUES (i_userid, i_user_rate_point, '1');
    END IF;
    END IF;
END $$
DELIMITER $$
