CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount NUMBER,
    p_InterestRate NUMBER,
    p_LoanDurationYears NUMBER
) RETURN NUMBER
IS
    v_MonthlyRate NUMBER;
    v_NumPayments NUMBER;
    v_MonthlyInstallment NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 1200;
    v_NumPayments := p_LoanDurationYears * 12;

    IF v_MonthlyRate = 0 THEN
        v_MonthlyInstallment := p_LoanAmount / v_NumPayments;
    ELSE
        v_MonthlyInstallment := p_LoanAmount * v_MonthlyRate / (1 - POWER(1 + v_MonthlyRate, -v_NumPayments));
    END IF;

    RETURN v_MonthlyInstallment;
END CalculateMonthlyInstallment;
/
