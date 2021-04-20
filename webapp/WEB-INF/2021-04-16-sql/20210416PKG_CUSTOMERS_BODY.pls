create or replace PACKAGE BODY PKG_CUSTOMERS AS 

  PROCEDURE PROC_CUSTOMER_LIST(
    IN_MEMBER_NUM IN NUMBER
,   O_CUR OUT SYS_REFCURSOR
  ) AS
  BEGIN 
    OPEN O_CUR FOR  
    SELECT IDX,CUSTOMER_IT,CUSTOMER_NAME,CUSTOMER_TEL,CUSTOMER_EMAIL,
           CUSTOMER_REMARKS,MEMBER_NUM
    FROM   CUSTOMERS
    WHERE  MEMBER_NUM = IN_MEMBER_NUM
    ORDER BY IDX DESC;
  END PROC_CUSTOMER_LIST;

  PROCEDURE PROC_CUSTOMER_INSERT( 
    IN_CUSTOMER_IT IN VARCHAR2,
    IN_CUSTOMER_NAME IN VARCHAR2,
    IN_CUSTOMER_TEL IN VARCHAR2,
    IN_CUSTOMER_EMAIL IN VARCHAR2,
    IN_CUSTOMER_REMARKS IN VARCHAR2,
    IN_MEMBER_NUM IN NUMBER
  ) AS
  V_IDX  NUMBER(5,0);
  BEGIN
     SELECT NVL(MAX(IDX),0)+1 
     INTO   V_IDX
     FROM   CUSTOMERS
      WHERE  MEMBER_NUM      = IN_MEMBER_NUM;

     
     INSERT INTO CUSTOMERS(IDX,CUSTOMER_IT,CUSTOMER_NAME,CUSTOMER_TEL,
                            CUSTOMER_EMAIL,CUSTOMER_REMARKS,MEMBER_NUM)
     VALUES(V_IDX, IN_CUSTOMER_IT, IN_CUSTOMER_NAME, IN_CUSTOMER_TEL,
            IN_CUSTOMER_EMAIL,IN_CUSTOMER_REMARKS,IN_MEMBER_NUM);
     COMMIT;
  END PROC_CUSTOMER_INSERT;

END PKG_CUSTOMERS;