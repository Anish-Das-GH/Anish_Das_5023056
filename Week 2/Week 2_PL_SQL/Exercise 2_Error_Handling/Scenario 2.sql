CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
)
IS
BEGIN
    BEGIN
 
        UPDATE Employees
        SET Salary = Salary + (Salary * p_Percentage / 100)
        WHERE EmployeeID = p_EmployeeID;

        IF SQL%NOTFOUND THEN
            RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found.');
        END IF;

        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
END UpdateSalary;
/
