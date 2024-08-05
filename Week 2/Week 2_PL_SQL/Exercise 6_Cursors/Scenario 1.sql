DECLARE
    CURSOR c_Transactions IS
        SELECT CustomerID, TransactionDate, TransactionType, Amount
        FROM Transactions
        WHERE EXTRACT(MONTH FROM TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_CustomerID Transactions.CustomerID%TYPE;
    v_TransactionDate Transactions.TransactionDate%TYPE;
    v_TransactionType Transactions.TransactionType%TYPE;
    v_Amount Transactions.Amount%TYPE;
BEGIN
    OPEN c_Transactions;
    LOOP
        FETCH c_Transactions INTO v_CustomerID, v_TransactionDate, v_TransactionType, v_Amount;
        EXIT WHEN c_Transactions%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_CustomerID || ', Date: ' || v_TransactionDate || 
                             ', Type: ' || v_TransactionType || ', Amount: ' || v_Amount);
    END LOOP;
    CLOSE c_Transactions;
END;
/
