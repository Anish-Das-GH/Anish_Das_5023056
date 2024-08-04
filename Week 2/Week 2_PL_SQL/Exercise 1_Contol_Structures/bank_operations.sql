-- Scenario 1
DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, DOB
        FROM Customers;
    v_CustomerID Customers.CustomerID%TYPE;
    v_DOB Customers.DOB%TYPE;
    v_Age NUMBER;
BEGIN
    FOR rec IN cur_customers LOOP
        v_CustomerID := rec.CustomerID;
        v_DOB := rec.DOB;
        v_Age := TRUNC(MONTHS_BETWEEN(SYSDATE, v_DOB) / 12);

        IF v_Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 2

ALTER TABLE Customers ADD (IsVIP VARCHAR2(5));

DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
    v_CustomerID Customers.CustomerID%TYPE;
    v_Balance Customers.Balance%TYPE;
BEGIN
    FOR rec IN cur_customers LOOP
        v_CustomerID := rec.CustomerID;
        v_Balance := rec.Balance;

        IF v_Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = v_CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/


-- Scenario 3
DECLARE
    CURSOR cur_loans IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    v_LoanID Loans.LoanID%TYPE;
    v_CustomerID Loans.CustomerID%TYPE;
    v_Name Customers.Name%TYPE;
    v_EndDate Loans.EndDate%TYPE;
BEGIN
    FOR rec IN cur_loans LOOP
        v_LoanID := rec.LoanID;
        v_CustomerID := rec.CustomerID;
        v_Name := rec.Name;
        v_EndDate := rec.EndDate;

        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_Name || ', your loan with ID ' || v_LoanID || ' is due on ' || v_EndDate || '. Please ensure timely payment.');
    END LOOP;
END;
/

