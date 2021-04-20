insert into mboard(idx,member_num, REPLY)
values(1, '´äº¯');

update mboard
set    reply = '¤¾¤·'
WHERE  IDX = 1
AND    MEMBER_NUM = 1;
commit;