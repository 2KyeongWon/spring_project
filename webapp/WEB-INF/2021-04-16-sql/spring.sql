insert into mboard(idx,member_num, REPLY)
values(1, '�亯');

update mboard
set    reply = '����'
WHERE  IDX = 1
AND    MEMBER_NUM = 1;
commit;